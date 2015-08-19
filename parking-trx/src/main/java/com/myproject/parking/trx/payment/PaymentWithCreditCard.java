package com.myproject.parking.trx.payment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.parking.lib.data.PaymentVO;
import com.myproject.parking.lib.entity.TrxPayment;
import com.myproject.parking.lib.service.AppsTimeService;
import com.myproject.parking.lib.service.CheckUserService;
import com.myproject.parking.lib.service.ParkingEngineException;
import com.myproject.parking.lib.utils.CipherUtil;
import com.myproject.parking.lib.utils.GenerateAccessToken;
import com.myproject.parking.lib.utils.MessageUtils;
import com.myproject.parking.trx.logic.BaseQueryLogic;
import com.paypal.api.payments.Address;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentWithCreditCard implements BaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(PaymentWithCreditCard.class);
			
	@Autowired
	private CheckUserService checkUserService;
	
	@Autowired
	private AppsTimeService timeServer;
	
	@Override
	public String process(HttpServletRequest request,HttpServletResponse response,String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		String result = "";
		try {						
			PaymentVO paymentVO = mapper.readValue(data, PaymentVO.class);
			checkUserService.isValidUser(paymentVO.getEmail(),paymentVO.getSessionKey());
			Payment createdPayment = createPayment(paymentVO);				
			result = MessageUtils.handleSuccess("Payment ID : " + createdPayment.getId() 
					+ " Created Date : " + createdPayment.getCreateTime() + " State : " + createdPayment.getState(), mapper);
		} catch (ParkingEngineException e) {
			LOG.error("ParkingEngineException when processing " + pathInfo, e);
			result = MessageUtils.handleException(e, "", mapper);
		} catch (PayPalRESTException e) {
			LOG.error("PayPalRESTException when processing " + pathInfo, e);
			result = MessageUtils.handleException(e, "PayPalRESTException when processing "+ e.getMessage(), mapper);
		} catch (Exception e) {
			LOG.error("Unexpected exception when processing " + pathInfo, e);
			result = MessageUtils.handleException(e, "Unexpected exception when processing "+ e.getMessage(), mapper);
		}
		return result;
	}
	
	private void savePayment(Payment payment) throws ParkingEngineException {
		TrxPayment trxPayment = new TrxPayment();
		if(!StringUtils.isEmpty(payment.getId())){
			trxPayment.setPaymentId(payment.getId());	
		}
		trxPayment.setCreateTime(timeServer.getCurrentTime());
		trxPayment.setUpdateTime(timeServer.getCurrentTime());
		if(!StringUtils.isEmpty(payment.getPayer().getPaymentMethod())){
			trxPayment.setPaymentMethod(payment.getPayer().getPaymentMethod());
		}
		
		// belum selesai
		
	}
	
	private void updatePayment(Payment payment) throws ParkingEngineException {
		// cari trxPayment dari payment id
		// update state,updateTime
	}
	
	private Payment createPayment(PaymentVO paymentVO) throws PayPalRESTException,ParkingEngineException {
		// ###Address
		// Base Address object used as shipping or billing
		// address in a payment. [Optional]
		Address billingAddress = new Address();
		billingAddress.setCity(paymentVO.getAddress().getCity());
		billingAddress.setCountryCode(paymentVO.getAddress().getCountryCode());
		billingAddress.setLine1(paymentVO.getAddress().getLine1());
		billingAddress.setPostalCode(paymentVO.getAddress().getPostalCode());
		billingAddress.setState(paymentVO.getAddress().getState());

		// ###CreditCard
		// A resource representing a credit card that can be
		// used to fund a payment.
		CreditCard creditCard = new CreditCard();
		creditCard.setBillingAddress(billingAddress);
		creditCard.setCvv2(paymentVO.getCreditCard().getCvv2());
		creditCard.setExpireMonth(paymentVO.getCreditCard().getExpireMonth());
		creditCard.setExpireYear(paymentVO.getCreditCard().getExpireYear());
		creditCard.setFirstName(paymentVO.getCreditCard().getFirstName());
		creditCard.setLastName(paymentVO.getCreditCard().getLastName());
		creditCard.setNumber(paymentVO.getCreditCard().getNumber());
		creditCard.setType(paymentVO.getCreditCard().getType());

		// ###Details
		// Let's you specify details of a payment amount.
		Details details = new Details();
		details.setShipping("0");
		details.setSubtotal("1");
		details.setTax("0");

		// ###Amount
		// Let's you specify a payment amount.
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal("1");
		amount.setDetails(details);

		// ###Transaction
		// A transaction defines the contract of a
		// payment - what is the payment for and who
		// is fulfilling it. Transaction is created with
		// a `Payee` and `Amount` types
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("Payment For Parking Online");

		// The Payment creation API requires a list of
		// Transaction; add the created `Transaction`
		// to a List
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// ###FundingInstrument
		// A resource representing a Payeer's funding instrument.
		// Use a Payer ID (A unique identifier of the payer generated
		// and provided by the facilitator. This is required when
		// creating or using a tokenized funding instrument)
		// and the `CreditCardDetails`
		FundingInstrument fundingInstrument = new FundingInstrument();
		fundingInstrument.setCreditCard(creditCard);

		// The Payment creation API requires a list of
		// FundingInstrument; add the created `FundingInstrument`
		// to a List
		List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
		fundingInstrumentList.add(fundingInstrument);

		// ###Payer
		// A resource representing a Payer that funds a payment
		// Use the List of `FundingInstrument` and the Payment Method
		// as 'credit_card'
		Payer payer = new Payer();
		payer.setFundingInstruments(fundingInstrumentList);
		payer.setPaymentMethod("credit_card");

		// ###Payment
		// A Payment Resource; create one using
		// the above types and intent as 'sale'
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);
		Payment createdPayment = null;
		try {
			// ###AccessToken
			// Retrieve the access token from
			// OAuthTokenCredential by passing in
			// ClientID and ClientSecret
			// It is not mandatory to generate Access Token on a per call basis.
			// Typically the access token can be generated once and
			// reused within the expiry window
			String accessToken = GenerateAccessToken.getAccessToken();

			// ### Api Context
			// Pass in a `ApiContext` object to authenticate
			// the call and to send a unique request id
			// (that ensures idempotency). The SDK generates
			// a request id if you do not pass one explicitly.
			APIContext apiContext = new APIContext(accessToken);
			// Use this variant if you want to pass in a request id
			// that is meaningful in your application, ideally
			// a order id.
			/*
			 * String requestId = Long.toString(System.nanoTime(); APIContext
			 * apiContext = new APIContext(accessToken, requestId ));
			 */

			// Create a payment by posting to the APIService
			// using a valid AccessToken
			// The return object contains the status;
			
			savePayment(payment);
			createdPayment = payment.create(apiContext);
			updatePayment(createdPayment);
			LOG.info("Created payment with id = " + createdPayment.getId()
					+ " and status = " + createdPayment.getState());
//			ResultPrinter.addResult(req, resp, "Payment with Credit Card",
//					Payment.getLastRequest(), Payment.getLastResponse(), null);
		} catch (PayPalRESTException e) {
			throw e;
		} catch (ParkingEngineException e) {
			throw e;
		}
		return createdPayment;
		
	}
	
}
