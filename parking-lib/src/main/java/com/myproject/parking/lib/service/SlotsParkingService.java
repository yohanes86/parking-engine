package com.myproject.parking.lib.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.parking.lib.data.Address;
import com.myproject.parking.lib.data.CustomerDetail;
import com.myproject.parking.lib.data.Product;
import com.myproject.parking.lib.data.SlotsParkingVO;
import com.myproject.parking.lib.data.TransactionDetails;
import com.myproject.parking.lib.data.VeriTransVO;
import com.myproject.parking.lib.entity.TransactionDetailVO;
import com.myproject.parking.lib.entity.TransactionVO;
import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.mapper.SlotsParkingMapper;
import com.myproject.parking.lib.mapper.TransactionDetailMapper;
import com.myproject.parking.lib.mapper.TransactionMapper;
import com.myproject.parking.lib.mapper.UserDataMapper;
import com.myproject.parking.lib.utils.CommonUtil;
import com.myproject.parking.lib.utils.Constants;

@Service
public class SlotsParkingService {
	private static final Logger LOG = LoggerFactory.getLogger(SlotsParkingService.class);
	
	@Autowired
	private SlotsParkingMapper slotsParkingMapper;
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@Autowired
	private AppsTimeService timeService;
	
	@Autowired
	private TransactionMapper transactionMapper;
	
	@Autowired
	private TransactionDetailMapper transactionDetailMapper;
	
	@Autowired
	private CheckSessionKeyService checkSessionKeyService;
	
	@Transactional(rollbackFor=Exception.class)
	public SlotsParkingVO findSlotsByMall(SlotsParkingVO slotsParkingVO) throws ParkingEngineException {
		LOG.debug("process find Slots By Mall with param slotsParkingVO : " + slotsParkingVO);	
		UserData user = userDataMapper.findUserDataByEmail(slotsParkingVO.getEmail());
		if(user == null){
			LOG.error("Can't find User with email : " + slotsParkingVO.getEmail());
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_NOT_FOUND);
		}
		if(Constants.BLOCKED == user.getStatus()){
			LOG.error("User already blocked");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_BLOCKED);
		}
		if(Constants.PENDING == user.getStatus()){
			LOG.error("User not active");
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_NOT_ACTIVE);
		}		
		if(StringUtils.isEmpty(user.getSessionKey())){
			LOG.error("User Must Login Before make transaction, Parameter email : " + slotsParkingVO.getEmail());
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_NOT_LOGIN);
		}
		if(!user.getSessionKey().equals(slotsParkingVO.getSessionKey())){
			LOG.error("Wrong Session Key, Parameter email : " + slotsParkingVO.getEmail());
			throw new ParkingEngineException(ParkingEngineException.ENGINE_SESSION_KEY_DIFFERENT);
		}		
		checkSessionKeyService.checkSessionKey(user.getTimeGenSessionKey(), slotsParkingVO.getEmail());
		SlotsParkingVO slotsAvailable = null;
		slotsAvailable = slotsParkingMapper.findSlotsParkingAvailable(slotsParkingVO.getMallName());
		if(slotsAvailable!=null){
			slotsAvailable.setEmail(slotsParkingVO.getEmail());
			slotsAvailable.setSessionKey(slotsParkingVO.getSessionKey());
			saveTransaction(generateDataTransaction(slotsAvailable.getEmail()));
			updateSlotStatus(slotsAvailable.getIdSlot());
		}else{
			throw new ParkingEngineException(ParkingEngineException.ENGINE_SLOT_NOT_AVAILABLE);
		}
		LOG.debug("process find Slots By Mall DONE with param slotsAvailable : " + slotsAvailable);
		return slotsAvailable;
	}
	
	protected void updateSlotStatus(int idSlot) {	
		// update mall slot menjadi 1 alias booked tapi belum bayar
		transactionDetailMapper.updateMallSlotStatus(idSlot);
	}
	
	protected TransactionVO saveTransaction(VeriTransVO veriTransVO) {		
        TransactionVO ret = new TransactionVO();
        ret.setBillingAddress(veriTransVO.getCustomerDetail().getBillingAddress().getAddress());
        ret.setBillingCity(veriTransVO.getCustomerDetail().getBillingAddress().getCity());
        ret.setBillingCountryCode(veriTransVO.getCustomerDetail().getBillingAddress().getCountryCode());
        ret.setBillingFirstName(veriTransVO.getCustomerDetail().getBillingAddress().getFirstName());
        ret.setBillingLastName(veriTransVO.getCustomerDetail().getBillingAddress().getLastName());
        ret.setBillingPhone(veriTransVO.getCustomerDetail().getBillingAddress().getPhone());
        ret.setBillingPostalCode(veriTransVO.getCustomerDetail().getBillingAddress().getPostalCode());

        ret.setCustomerEmail(veriTransVO.getCustomerDetail().getEmail());
        ret.setCustomerFirstName(veriTransVO.getCustomerDetail().getFirstName());
        ret.setCustomerLastName(veriTransVO.getCustomerDetail().getLastName());
        ret.setCustomerPhone(veriTransVO.getCustomerDetail().getPhone());

        ret.setShippingAddress(veriTransVO.getCustomerDetail().getShippingAddress().getAddress());
        ret.setShippingCity(veriTransVO.getCustomerDetail().getShippingAddress().getCity());
        ret.setShippingCountryCode(veriTransVO.getCustomerDetail().getShippingAddress().getCountryCode());
        ret.setShippingFirstName(veriTransVO.getCustomerDetail().getShippingAddress().getFirstName());
        ret.setShippingLastName(veriTransVO.getCustomerDetail().getShippingAddress().getLastName());
        ret.setShippingPhone(veriTransVO.getCustomerDetail().getShippingAddress().getPhone());
        ret.setShippingPostalCode(veriTransVO.getCustomerDetail().getShippingAddress().getPostalCode());

        ret.setPaymentFdsStatus(null);
        ret.setPaymentMethod(veriTransVO.getPaymentMethod());
        ret.setPaymentOrderId(veriTransVO.getTransactionDetails().getOrderId());
        ret.setPaymentStatus(null);
        ret.setPaymentTransactionId(null);      

        ret.setTotalPriceIdr(veriTransVO.getTotalPriceIdr());
        Date now = timeService.getCurrentTime();
        ret.setCreatedBy(Constants.SYSTEM);
        ret.setUpdatedBy(Constants.SYSTEM);
        ret.setCreatedOn(now);
        ret.setUpdatedOn(now);
        generateBookingCode(ret);
        // insert ke db TRX HEADER
        // get id        
        transactionMapper.createTransaction(ret);
        for (Product product : veriTransVO.getListProducts()) {
			TransactionDetailVO transactionDetailVO = new TransactionDetailVO();
			transactionDetailVO.setPriceEachIdr(product.getPriceIdr());
			transactionDetailVO.setNameItem(product.getLongName());
			transactionDetailVO.setTransactionId(ret.getId()); // ambil dari header punya id
			// insert ke db TRX DETAIL
			transactionDetailMapper.createTransactionDetail(transactionDetailVO);
		}
        LOG.debug(" Save Payment Transaction to DB: "+ ret);
        return ret;
    }
	
	private VeriTransVO generateDataTransaction(String email){
		VeriTransVO veriTransVO = new VeriTransVO();
		veriTransVO.setEmail(email);
		veriTransVO.setSessionKey("");
		veriTransVO.setTotalPriceIdr(new Long(0));
		veriTransVO.setTokenId("");
		veriTransVO.setPaymentMethod("Credit Card");
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setFirstName("");
		customerDetail.setLastName("");
		customerDetail.setEmail(email);
		customerDetail.setPhone("");
		Address billAddress = new Address();
		billAddress.setFirstName("");
		billAddress.setLastName("");
		billAddress.setAddress("");
		billAddress.setCity("");
		billAddress.setPhone("");
		billAddress.setPostalCode("");
		
		Address shipAddress = new Address();
		shipAddress.setFirstName("");
		shipAddress.setLastName("");
		shipAddress.setAddress("");
		shipAddress.setCity("");
		shipAddress.setPhone("");
		shipAddress.setPostalCode("");
		customerDetail.setBillingAddress(billAddress);
		customerDetail.setShippingAddress(shipAddress);
		
		TransactionDetails transactionDetails = new  TransactionDetails();
		transactionDetails.setOrderId(UUID.randomUUID().toString());
		transactionDetails.setGrossAmount(new Long(0));
		
		Product product = new Product();
		product.setId(new Long(1));
		product.setLongName("");
		product.setPriceIdr(new Long(0));
		product.setShortName("");
		product.setThumbnailFilePath("");
		List<Product> listProducts = new ArrayList<Product>();
		listProducts.add(product);
		veriTransVO.setCustomerDetail(customerDetail);
		veriTransVO.setTransactionDetails(transactionDetails);
		veriTransVO.setListProducts(listProducts);
		return veriTransVO;
	}
	
	private void generateBookingCode(TransactionVO ret){
		String bookingCode = CommonUtil.generateNumeric(Constants.LENGTH_GENERATE_BOOKING_CODE);
		ret.setBookingCode(bookingCode);		
	}
	
}
