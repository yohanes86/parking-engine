package com.myproject.parking.trx.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myproject.parking.lib.data.PaymentVO;
import com.myproject.parking.lib.service.CheckUserService;
import com.myproject.parking.lib.service.ParkingEngineException;
import com.myproject.parking.lib.utils.GenerateAccessToken;
import com.myproject.parking.lib.utils.MessageUtils;
import com.myproject.parking.trx.logic.BaseQueryLogic;
import com.paypal.api.payments.Address;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentWithPayPal implements BaseQueryLogic {
	private static final Logger LOG = LoggerFactory.getLogger(PaymentWithPayPal.class);
			
	@Autowired
	private CheckUserService checkUserService;
	Map<String, String> map = new HashMap<String, String>();
	@Override
	public String process(HttpServletRequest req,HttpServletResponse response,String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :"+pathInfo);		
		String result = "";
		String approvalUrl = "";
		String payerId = "";
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
			if (req.getParameter("PayerID") != null) {
				Payment payment = new Payment();
				if (req.getParameter("guid") != null) {
					payment.setId(map.get(req.getParameter("guid")));
				}

				PaymentExecution paymentExecution = new PaymentExecution();
				paymentExecution.setPayerId(req.getParameter("PayerID"));
				try {
					createdPayment = payment.execute(apiContext, paymentExecution);
					payerId = req.getParameter("PayerID");
				} catch (PayPalRESTException e) {
					throw e;
				}
			} else {
				PaymentVO paymentVO = mapper.readValue(data, PaymentVO.class);
				checkUserService.isValidUser(paymentVO.getEmail(),paymentVO.getSessionId());
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
				transaction
						.setDescription("Payment Parking Online");

				// ### Items
				Item item = new Item();
				item.setName("Ground Coffee 40 oz").setQuantity("1").setCurrency("USD").setPrice("1");
				ItemList itemList = new ItemList();
				List<Item> items = new ArrayList<Item>();
				items.add(item);
				itemList.setItems(items);
				
				transaction.setItemList(itemList);
				
				
				// The Payment creation API requires a list of
				// Transaction; add the created `Transaction`
				// to a List
				List<Transaction> transactions = new ArrayList<Transaction>();
				transactions.add(transaction);

				// ###Payer
				// A resource representing a Payer that funds a payment
				// Payment Method
				// as 'paypal'
				Payer payer = new Payer();
				payer.setPaymentMethod("paypal");

				// ###Payment
				// A Payment Resource; create one using
				// the above types and intent as 'sale'
				Payment payment = new Payment();
				payment.setIntent("sale");
				payment.setPayer(payer);
				payment.setTransactions(transactions);

				// ###Redirect URLs
				RedirectUrls redirectUrls = new RedirectUrls();
				String guid = UUID.randomUUID().toString().replaceAll("-", "");
				redirectUrls.setCancelUrl(req.getScheme() + "://"
						+ req.getServerName() + ":" + req.getServerPort()
						+ req.getContextPath() + "/trx/paymentPayPal?guid=" + guid);
				redirectUrls.setReturnUrl(req.getScheme() + "://"
						+ req.getServerName() + ":" + req.getServerPort()
						+ req.getContextPath() + "/trx/paymentPayPal?guid=" + guid);
				payment.setRedirectUrls(redirectUrls);

				
				// Create a payment by posting to the APIService
				// using a valid AccessToken
				// The return object contains the status;
				try {
					createdPayment = payment.create(apiContext);
					LOG.info("Created payment with id = "
							+ createdPayment.getId() + " and status = "
							+ createdPayment.getState());
					// ###Payment Approval Url
					Iterator<Links> links = createdPayment.getLinks().iterator();
					while (links.hasNext()) {
						Links link = links.next();
						if (link.getRel().equalsIgnoreCase("approval_url")) {
							req.setAttribute("redirectURL", link.getHref());
							LOG.info("Redirect Url = " + link.getHref());
							approvalUrl = link.getHref();
						}
					}
					map.put(guid, createdPayment.getId());
				} catch (PayPalRESTException e) {
					throw e;
				}
			}				
			result = MessageUtils.handleSuccess("[Approval Url : " + approvalUrl + "]"+"[Payer Id : " + payerId + "]"+" Payment ID : " + createdPayment.getId() 
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
	
}
