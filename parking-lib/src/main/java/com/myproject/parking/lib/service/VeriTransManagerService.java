package com.myproject.parking.lib.service;

import id.co.veritrans.mdk.v1.VtGatewayConfig;
import id.co.veritrans.mdk.v1.VtGatewayConfigBuilder;
import id.co.veritrans.mdk.v1.VtGatewayFactory;
import id.co.veritrans.mdk.v1.config.EnvironmentType;
import id.co.veritrans.mdk.v1.exception.RestClientException;
import id.co.veritrans.mdk.v1.gateway.VtDirect;
import id.co.veritrans.mdk.v1.gateway.model.AbstractVtRequest;
import id.co.veritrans.mdk.v1.gateway.model.Address;
import id.co.veritrans.mdk.v1.gateway.model.CustomerDetails;
import id.co.veritrans.mdk.v1.gateway.model.TransactionDetails;
import id.co.veritrans.mdk.v1.gateway.model.TransactionItem;
import id.co.veritrans.mdk.v1.gateway.model.VtResponse;
import id.co.veritrans.mdk.v1.gateway.model.builder.CreditCardBuilder;
import id.co.veritrans.mdk.v1.gateway.model.vtdirect.CreditCardRequest;

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

import com.myproject.parking.lib.data.Product;
import com.myproject.parking.lib.data.VeriTransVO;
import com.myproject.parking.lib.entity.TransactionDetailVO;
import com.myproject.parking.lib.entity.TransactionVO;
import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.mapper.TransactionDetailMapper;
import com.myproject.parking.lib.mapper.TransactionMapper;
import com.myproject.parking.lib.mapper.UserDataMapper;
import com.myproject.parking.lib.utils.Constants;

@Service
public class VeriTransManagerService {

	private static final Logger LOG = LoggerFactory.getLogger(VeriTransManagerService.class);
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@Autowired
	private TransactionMapper transactionMapper;
	
	@Autowired
	private TransactionDetailMapper transactionDetailMapper;
	
	@Autowired
	private AppsTimeService timeService;
	
	@Autowired
	private CheckSessionKeyService checkSessionKeyService;
	
	private String clientKey;
	private String serverKey;
	private String environment;
    private int connectionPoolSize;

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getServerKey() {
		return serverKey;
	}

	public void setServerKey(String serverKey) {
		this.serverKey = serverKey;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public int getConnectionPoolSize() {
		return connectionPoolSize;
	}

	public void setConnectionPoolSize(int connectionPoolSize) {
		this.connectionPoolSize = connectionPoolSize;
	}

	public VtGatewayFactory getVtGatewayFactory() {
		VtGatewayConfigBuilder vtGatewayConfigBuilder = new VtGatewayConfigBuilder();
		vtGatewayConfigBuilder.setServerKey(serverKey);
		vtGatewayConfigBuilder.setClientKey(clientKey);
		vtGatewayConfigBuilder.setEnvironmentType(EnvironmentType.valueOf(environment));
		vtGatewayConfigBuilder.setMaxConnectionPoolSize(connectionPoolSize);
		VtGatewayConfig vtGatewayConfig = vtGatewayConfigBuilder.createVtGatewayConfig();
		return new VtGatewayFactory(vtGatewayConfig);
	}
	
	@Transactional(rollbackFor={Exception.class})
	public void charge(String vtToken,TransactionVO transactionVO,VeriTransVO veriTransVO) throws ParkingEngineException,RestClientException {
		LOG.debug(" Process charge to veritrans with token: "+vtToken + " email : " + veriTransVO.getEmail());
		LOG.debug(" Parameter VeriTransVO: "+veriTransVO);
		UserData user = userDataMapper.findUserDataByEmail(veriTransVO.getEmail());
		if(user == null){
			LOG.error("Can't find User with email : " + veriTransVO.getEmail());
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
			LOG.error("User Must Login Before make transaction, Parameter email : " + veriTransVO.getEmail());
			throw new ParkingEngineException(ParkingEngineException.ENGINE_USER_NOT_LOGIN);
		}
		if(!user.getSessionKey().equals(veriTransVO.getSessionKey())){
			LOG.error("Wrong Session Key, Parameter email : " + veriTransVO.getEmail());
			throw new ParkingEngineException(ParkingEngineException.ENGINE_SESSION_KEY_DIFFERENT);
		}
		checkSessionKeyService.checkSessionKey(user.getTimeGenSessionKey(), veriTransVO.getEmail());
		try {
			final CreditCardRequest request = createCreditCardRequest(vtToken,veriTransVO);
			transactionVO = saveTransaction(veriTransVO);
			VtDirect vtDirect = getVtGatewayFactory().vtDirect();			
            final VtResponse vtResponse = vtDirect.charge(request);            
            transactionVO.setPaymentTransactionId(vtResponse.getTransactionId());
            transactionVO.setPaymentFdsStatus(vtResponse.getFraudStatus() == null ? null : vtResponse.getFraudStatus().name());
            transactionVO.setPaymentStatus(vtResponse.getTransactionStatus() == null ? null : vtResponse.getTransactionStatus().name());
            
            LOG.debug(" Response veritrans : " +vtResponse.getStatusCode() + " Error Message : " + vtResponse.getStatusMessage() 
            		+ " with token: "+vtToken + " email : " + veriTransVO.getEmail());
            if (!vtResponse.getStatusCode().equals("200")) {
            	throw new ParkingEngineException(ParkingEngineException.VERITRANS_CHARGE_FAILED);
            }        
            transactionMapper.updateTransactionStatus(transactionVO.getPaymentTransactionId(), 
            		transactionVO.getPaymentFdsStatus(), transactionVO.getPaymentStatus(), transactionVO.getPaymentOrderId());
		} catch (RestClientException e) {
			throw e;
		}
		LOG.debug(" Parameter TransactionVO: "+transactionVO);
	}
	
	
	protected TransactionVO saveTransaction(VeriTransVO veriTransVO) {		
        final TransactionVO ret = new TransactionVO();
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
	
	protected void setVtRequestParam(final AbstractVtRequest vtRequest,VeriTransVO veriTransVO) {
        vtRequest.setCustomerDetails(toCustomerDetails(veriTransVO));

        vtRequest.setTransactionDetails(toTransactionDetails(veriTransVO));
        vtRequest.setItemDetails(toTransactionItems(veriTransVO));
    }
	
	protected CustomerDetails toCustomerDetails(VeriTransVO veriTransVO) {
        final CustomerDetails ret = new CustomerDetails();
        ret.setFirstName(veriTransVO.getCustomerDetail().getFirstName());
        ret.setLastName(veriTransVO.getCustomerDetail().getLastName());
        ret.setEmail(veriTransVO.getCustomerDetail().getEmail());
        ret.setPhone(veriTransVO.getCustomerDetail().getPhone());

        ret.setBillingAddress(new Address());
        ret.getBillingAddress().setAddress(veriTransVO.getCustomerDetail().getBillingAddress().getAddress());
        ret.getBillingAddress().setCity(veriTransVO.getCustomerDetail().getBillingAddress().getCity());
        ret.getBillingAddress().setCountryCode("IDN");
        ret.getBillingAddress().setFirstName(veriTransVO.getCustomerDetail().getBillingAddress().getFirstName());
        ret.getBillingAddress().setLastName(veriTransVO.getCustomerDetail().getBillingAddress().getLastName());
        ret.getBillingAddress().setPhone(veriTransVO.getCustomerDetail().getBillingAddress().getPhone());
        ret.getBillingAddress().setPostalCode(veriTransVO.getCustomerDetail().getBillingAddress().getPostalCode());

        ret.setShippingAddress(new Address());
        ret.getShippingAddress().setAddress(veriTransVO.getCustomerDetail().getShippingAddress().getAddress());
        ret.getShippingAddress().setCity(veriTransVO.getCustomerDetail().getShippingAddress().getCity());
        ret.getShippingAddress().setCountryCode("IDN");
        ret.getShippingAddress().setFirstName(veriTransVO.getCustomerDetail().getShippingAddress().getFirstName());
        ret.getShippingAddress().setLastName(veriTransVO.getCustomerDetail().getShippingAddress().getLastName());
        ret.getShippingAddress().setPhone(veriTransVO.getCustomerDetail().getShippingAddress().getPhone());
        ret.getShippingAddress().setPostalCode(veriTransVO.getCustomerDetail().getShippingAddress().getPostalCode());

        return ret;
    }
	
	protected TransactionDetails toTransactionDetails(VeriTransVO veriTransVO) {
        final TransactionDetails ret = new TransactionDetails();

        ret.setGrossAmount(veriTransVO.getTransactionDetails().getGrossAmount()); // bisa ditambah fee kita nantinya
        ret.setOrderId(UUID.randomUUID().toString());

        return ret;
    }
	
	protected List<TransactionItem> toTransactionItems(VeriTransVO veriTransVO) {
        final List<TransactionItem> ret = new ArrayList<TransactionItem>(veriTransVO.getListProducts().size());
        for (final Product product : veriTransVO.getListProducts()) {         
            ret.add(new TransactionItem(
                    product.getId().toString(),
                    product.getShortName(),
                    product.getPriceIdr(),
                    veriTransVO.getListProducts().size()
            ));
        }
        return ret;
    }
	
	protected CreditCardRequest createCreditCardRequest(final String vtToken,VeriTransVO veriTransVO) {
        final CreditCardRequest ret = new CreditCardRequest();
        setVtRequestParam(ret,veriTransVO);
        ret.setCreditCard(new CreditCardBuilder().createCreditCard());
        ret.getCreditCard().setCardToken(vtToken);
        return ret;
    }
	
}
