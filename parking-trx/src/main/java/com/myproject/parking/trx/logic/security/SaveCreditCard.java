// #CreateCreditCard Sample
// Using the 'vault' API, you can store a 
// Credit Card securely on PayPal. You can
// use a saved Credit Card to process
// a payment in the future.
// The following code demonstrates how 
// can save a Credit Card on PayPal using 
// the Vault API.
// API used: POST /v1/vault/credit-card
package com.myproject.parking.trx.logic.security;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myproject.parking.lib.data.PaymentVO;
import com.myproject.parking.lib.utils.GenerateAccessToken;
import com.myproject.parking.trx.logic.BaseQueryLogic;
import com.paypal.api.payments.CreditCard;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class SaveCreditCard implements BaseQueryLogic {

	private static final Logger LOG = LoggerFactory.getLogger(SaveCreditCard.class);

	@Override
	public String process(String data, ObjectMapper mapper, String pathInfo) {
		LOG.debug("Start process Query :" + pathInfo);
		String result = "";
		try {
			PaymentVO paymentVO = mapper.readValue(data, PaymentVO.class);
			saveCreditCard(paymentVO);
			result =  mapper.writeValueAsString(paymentVO);
		} catch (PayPalRESTException e) {
			LOG.error("PayPalRESTException when processing " + pathInfo, e);
		} catch (Exception e) {
			LOG.error("Unexpected exception when processing " + pathInfo, e);			
		}
		return result;
	}

	public void saveCreditCard(PaymentVO paymentVO) throws PayPalRESTException {
		// ###CreditCard
				// A resource representing a credit card that can be
				// used to fund a payment.
				CreditCard creditCard = new CreditCard();
				creditCard.setExpireMonth(11);
				creditCard.setExpireYear(2018);
				creditCard.setNumber("4417119669820331");
				creditCard.setType("visa");

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
					 * String requestId = Long.toString(System.nanoTime();
					 * APIContext apiContext = new APIContext(accessToken, requestId ));
					 */
					
					// ###Save
					// Creates the credit card as a resource
					// in the PayPal vault. The response contains
					// an 'id' that you can use to refer to it
					// in the future payments.
					CreditCard createdCreditCard = creditCard.create(apiContext);
					
					LOG.info("Credit Card Created With ID: " + createdCreditCard.getId());
				} catch (PayPalRESTException e) {
					throw e;
				}
	}
}
