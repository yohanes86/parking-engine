package com.myproject.parking.trx.payment;

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
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.parking.lib.data.Product;
import com.myproject.parking.lib.data.TransactionVO;
import com.myproject.parking.lib.data.VeriTransVO;
import com.myproject.parking.lib.service.AppsTimeService;
import com.myproject.parking.lib.service.CheckUserService;
import com.myproject.parking.lib.service.ParkingEngineException;
import com.myproject.parking.lib.service.VeriTransManagerService;
import com.myproject.parking.lib.utils.MessageUtils;
import com.myproject.parking.trx.logic.BaseQueryLogic;

public class ReceiveTransactionFromVeriTrans implements BaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(ReceiveTransactionFromVeriTrans.class);
			
	@Autowired
	private CheckUserService checkUserService;
	
	@Autowired
	private VeriTransManagerService veriTransManagerService;
	
	@Autowired
	private AppsTimeService timeServer;
	
	@Override
	public String process(HttpServletRequest request,HttpServletResponse response,String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		String result = "";
		try {		
			TransactionVO transaction = new TransactionVO(); 
			VeriTransVO veriTransVO = mapper.readValue(data, VeriTransVO.class);
			charge(veriTransVO.getTokenId(),transaction,veriTransVO);
			result = MessageUtils.handleSuccess("Payment ID : " + transaction.getId() 
					+ " Price : " + transaction.getTotalPriceIdr() + " Payment Status : " + transaction.getPaymentStatus(), mapper);
		} catch (ParkingEngineException e) {
			result = MessageUtils.handleException(e, "", mapper);
			LOG.error("ParkingEngineException when processing " + pathInfo + " Error Message " + result);
		} catch (RestClientException e) {			
			result = MessageUtils.handleException(e, "RestClientException when processing "+ e.getMessage(), mapper);
			LOG.error("RestClientException when processing " + pathInfo + " Error Message " + result);
		} catch (Exception e) {			
			result = MessageUtils.handleException(e, "Unexpected exception when processing "+ e.getMessage(), mapper);
			LOG.error("Unexpected exception when processing " + pathInfo + " Error Message " + result);
		}
		return result;
	}
	
	private void charge(String vtToken,TransactionVO transaction,VeriTransVO veriTransVO) throws ParkingEngineException,RestClientException {
		LOG.debug(" Process charge to veritrans token: "+vtToken);		
		try {
			final CreditCardRequest request = createCreditCardRequest(vtToken,veriTransVO);
			VtDirect vtDirect = veriTransManagerService.getVtGatewayFactory().vtDirect();			
            final VtResponse vtResponse = vtDirect.charge(request);            
            transaction.setPaymentTransactionId(vtResponse.getTransactionId());
            transaction.setPaymentFdsStatus(vtResponse.getFraudStatus() == null ? null : vtResponse.getFraudStatus().name());
            transaction.setPaymentStatus(vtResponse.getTransactionStatus() == null ? null : vtResponse.getTransactionStatus().name());
            LOG.debug(" Response veritrans : " +vtResponse.getStatusCode() + " Error Message : " + vtResponse.getStatusMessage());
            if (!vtResponse.getStatusCode().equals("200")) {
            	throw new ParkingEngineException(ParkingEngineException.VERITRANS_CHARGE_FAILED);
            }        
		} catch (RestClientException e) {
			throw e;
		}
			
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
