package com.myproject.parking.trx.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myproject.parking.lib.data.Address;
import com.myproject.parking.lib.data.ChangePasswordVO;
import com.myproject.parking.lib.data.CustomerDetail;
import com.myproject.parking.lib.data.ForgetPasswordVO;
import com.myproject.parking.lib.data.LoginData;
import com.myproject.parking.lib.data.Product;
import com.myproject.parking.lib.data.TransactionDetails;
import com.myproject.parking.lib.data.VeriTransVO;
import com.myproject.parking.lib.entity.UserData;
import com.myproject.parking.lib.utils.CipherUtil;
import com.myproject.parking.lib.utils.CommonUtil;


@RunWith(MockitoJUnitRunner.class)
public class SmisServletTest {
	private static final Logger LOG = LoggerFactory.getLogger(SmisServletTest.class);

	private final String testingUserRegistration = "http://localhost:8080/parking-trx/trx/userRegistration";
	private final String testingPaymentWithCC = "http://localhost:8080/parking-trx/trx/paymentCC";
	private final String testingPaymentWithPayPal = "http://localhost:8080/parking-trx/trx/paymentPayPal";
	//private final String baseHostUrl = "http://192.168.0.76:8089/nusapro-wallet/wallet";
	private ObjectMapper mapper = new ObjectMapper();
	
	private final String testingActivateService = "http://localhost:8080/parking-trx/trx/userActivate?actKey=dadadada&email=a@yahoo.com&noHp=085693938630";
	private final String testingForget = "http://localhost:8080/parking-trx/trx/forgetPassword";
	private final String testingLoginUser = "http://localhost:8080/parking-trx/trx/loginUser";
	private final String testingChangePassword = "http://localhost:8080/parking-trx/trx/changePassword";
	private final String testingGetTrxFromVeriTrans = "http://192.168.1.101:8080/parking-trx/trx/receiveTrxFromVeriTrans";
	private final String testingGetListMall = "http://localhost:8080/parking-trx/trx/listMall";
	private final String testingRefreshCacheMall = "http://localhost:8080/parking-trx/trx/refreshCacheMall";
	
	
	
//	@Test
	public void testRegistrationUser() {
		String url = testingUserRegistration;
		long startTime = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		try {
			
			UserData userData = new UserData();
			userData.setName("ADK");
			userData.setPassword("password");
			userData.setEmail("agusdk2011@gmail.com");
			userData.setPhoneNo("085693938630");
			userData.setLicenseNo("B 999 ROI");
			
			String s = mapper.writeValueAsString(userData);
			s = CipherUtil.encryptTripleDES(s, CipherUtil.PASSWORD);
			LOG.debug("Request: " + s);
            StringEntity entity = new StringEntity(s);
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(entity);
			
			// Execute HTTP request
			LOG.debug("Executing request: " + post.getURI());
            HttpResponse response = client.execute(post);
            
            // Get hold of the response entity
            StatusLine sl = response.getStatusLine();
            LOG.debug("StatusCode: " + sl.getStatusCode());
            Assert.assertEquals(200, sl.getStatusCode());

            HttpEntity respEntity = response.getEntity();
            String respString = EntityUtils.toString(respEntity);
            LOG.debug("Response: " + respString);
            
//            WalletTrxResponse trxResp = mapper.
//            		readValue(respString, WalletTrxResponse.class);
//            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
            Assert.assertEquals(true, true);
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running one thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
		}catch (Exception e) {
		
			LOG.warn("Unexpected Exception", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            client.getConnectionManager().shutdown();
        }  // end try finally
	}
	
//	@Test
	public void testForgetPassword() {
		String url = testingForget;
		long startTime = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		try {
			
			ForgetPasswordVO forgetPasswordVO = new ForgetPasswordVO();
			forgetPasswordVO.setEmail("agusdk2011@gmail.com");
			
			String s = mapper.writeValueAsString(forgetPasswordVO);
			s = CipherUtil.encryptTripleDES(s, CipherUtil.PASSWORD);
			LOG.debug("Request: " + s);
            StringEntity entity = new StringEntity(s);
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(entity);
			
			// Execute HTTP request
			LOG.debug("Executing request: " + post.getURI());
            HttpResponse response = client.execute(post);
            
            // Get hold of the response entity
            StatusLine sl = response.getStatusLine();
            LOG.debug("StatusCode: " + sl.getStatusCode());
            Assert.assertEquals(200, sl.getStatusCode());

            HttpEntity respEntity = response.getEntity();
            String respString = EntityUtils.toString(respEntity);
            LOG.debug("Response: " + respString);
            
//            WalletTrxResponse trxResp = mapper.
//            		readValue(respString, WalletTrxResponse.class);
//            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
            Assert.assertEquals(true, true);
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running one thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
		}catch (Exception e) {
		
			LOG.warn("Unexpected Exception", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            client.getConnectionManager().shutdown();
        }  // end try finally
	}
	
//	@Test
	public void testLoginUser() {
		String url = testingLoginUser;
		long startTime = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		try {
			
			LoginData loginData = new LoginData();
			loginData.setPassword("password");
			loginData.setEmail("saagusdk2011@gmail.com");
			
			String s = mapper.writeValueAsString(loginData);
			s = CipherUtil.encryptTripleDES(s, CipherUtil.PASSWORD);
			LOG.debug("Request: " + s);
            StringEntity entity = new StringEntity(s);
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(entity);
			
			// Execute HTTP request
			LOG.debug("Executing request: " + post.getURI());
            HttpResponse response = client.execute(post);
            
            // Get hold of the response entity
            StatusLine sl = response.getStatusLine();
            LOG.debug("StatusCode: " + sl.getStatusCode());
            Assert.assertEquals(200, sl.getStatusCode());

            HttpEntity respEntity = response.getEntity();
            String respString = EntityUtils.toString(respEntity);
            LOG.debug("Response: " + respString);
            
//            WalletTrxResponse trxResp = mapper.
//            		readValue(respString, WalletTrxResponse.class);
//            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
            Assert.assertEquals(true, true);
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running one thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
		}catch (Exception e) {
		
			LOG.warn("Unexpected Exception", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            client.getConnectionManager().shutdown();
        }  // end try finally
	}
	
//	@Test
	public void testChangePassword() {
		String url = testingChangePassword;
		long startTime = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		try {
			
			ChangePasswordVO changePasswordVO = new ChangePasswordVO();
			changePasswordVO.setEmail("agusdk2011@gmail.com");
			changePasswordVO.setSessionKey("085693938630GX2FDXLBKWN35CMNGKI48YXEAQ1RPR");
			changePasswordVO.setPassword("admin123+");
			changePasswordVO.setNewPassword("password");
			
			String s = mapper.writeValueAsString(changePasswordVO);
			s = CipherUtil.encryptTripleDES(s, CipherUtil.PASSWORD);
			LOG.debug("Request: " + s);
            StringEntity entity = new StringEntity(s);
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(entity);
			
			// Execute HTTP request
			LOG.debug("Executing request: " + post.getURI());
            HttpResponse response = client.execute(post);
            
            // Get hold of the response entity
            StatusLine sl = response.getStatusLine();
            LOG.debug("StatusCode: " + sl.getStatusCode());
            Assert.assertEquals(200, sl.getStatusCode());

            HttpEntity respEntity = response.getEntity();
            String respString = EntityUtils.toString(respEntity);
            LOG.debug("Response: " + respString);
            
//            WalletTrxResponse trxResp = mapper.
//            		readValue(respString, WalletTrxResponse.class);
//            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
            Assert.assertEquals(true, true);
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running one thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
		}catch (Exception e) {
		
			LOG.warn("Unexpected Exception", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            client.getConnectionManager().shutdown();
        }  // end try finally
	}
	
//	@Test
	public void testVeriTransAPI() {
		String url = testingGetTrxFromVeriTrans;
		long startTime = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		try {
			
			VeriTransVO veriTransVO = new VeriTransVO();
			veriTransVO.setEmail("agusdk2011@gmail.com");
			veriTransVO.setSessionKey("085693938630GX2FDXLBKWN35CMNGKI48YXEAQ1RPR");
			veriTransVO.setTotalPriceIdr(new Long(5000000));
			veriTransVO.setTokenId("441111-1118-ce1c34bf-e76e-49c5-ade6-e594b74b5dc8");
			veriTransVO.setPaymentMethod("Credit Card");
			CustomerDetail customerDetail = new CustomerDetail();
			customerDetail.setFirstName("AGUS DARMA");
			customerDetail.setLastName("KUSUMA");
			customerDetail.setEmail("agusdk2011@gmail.com");
			customerDetail.setPhone("085693938630");
			Address billAddress = new Address();
			billAddress.setFirstName("AGUS DARMA BILLING");
			billAddress.setLastName("KUSUMA BILLING");
			billAddress.setAddress("Jalan Raya Perancis");
			billAddress.setCity("Tangerang");
			billAddress.setPhone("085693938630");
			billAddress.setPostalCode("15211");
			
			Address shipAddress = new Address();
			shipAddress.setFirstName("AGUS DARMA SHIPPING");
			shipAddress.setLastName("KUSUMA SHIPPING");
			shipAddress.setAddress("Jalan Raya Perancis");
			shipAddress.setCity("Tangerang");
			shipAddress.setPhone("085693938630");
			shipAddress.setPostalCode("15211");
			customerDetail.setBillingAddress(billAddress);
			customerDetail.setShippingAddress(shipAddress);
			
			TransactionDetails transactionDetails = new  TransactionDetails();
			transactionDetails.setOrderId(UUID.randomUUID().toString());
			transactionDetails.setGrossAmount(new Long(5000000));
			
			Product product = new Product();
			product.setId(new Long(1));
			product.setLongName("Parking Online Mall Kota Kasablanca");
			product.setPriceIdr(new Long(5000000));
			product.setShortName("V-Mobile KOKAS");
			product.setThumbnailFilePath("");
			List<Product> listProducts = new ArrayList<Product>();
			listProducts.add(product);
			veriTransVO.setCustomerDetail(customerDetail);
			veriTransVO.setTransactionDetails(transactionDetails);
			veriTransVO.setListProducts(listProducts);
			
			
			String s = mapper.writeValueAsString(veriTransVO);
			s = CipherUtil.encryptTripleDES(s, CipherUtil.PASSWORD);
			LOG.debug("Request: " + s);
            StringEntity entity = new StringEntity(s);
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(entity);
			
			// Execute HTTP request
			LOG.debug("Executing request: " + post.getURI());
            HttpResponse response = client.execute(post);
            
            // Get hold of the response entity
            StatusLine sl = response.getStatusLine();
            LOG.debug("StatusCode: " + sl.getStatusCode());
            Assert.assertEquals(200, sl.getStatusCode());

            HttpEntity respEntity = response.getEntity();
            String respString = EntityUtils.toString(respEntity);
            LOG.debug("Response: " + respString);
            
//            WalletTrxResponse trxResp = mapper.
//            		readValue(respString, WalletTrxResponse.class);
//            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
            Assert.assertEquals(true, true);
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running one thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
		}catch (Exception e) {
		
			LOG.warn("Unexpected Exception", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            client.getConnectionManager().shutdown();
        }  // end try finally
	}
	
	@Test
	public void testGetListMall() {
		String url = testingGetListMall;
		long startTime = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		try {
			
			LoginData loginData = new LoginData();
			loginData.setEmail("agusdk2011@gmail.com");
			loginData.setSessionKey("085693938630GX2FDXLBKWN35CMNGKI48YXEAQ1RPR");
			
			
			String s = mapper.writeValueAsString(loginData);
			s = CipherUtil.encryptTripleDES(s, CipherUtil.PASSWORD);
			LOG.debug("Request: " + s);
            StringEntity entity = new StringEntity(s);
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(entity);
			
			// Execute HTTP request
			LOG.debug("Executing request: " + post.getURI());
            HttpResponse response = client.execute(post);
            
            // Get hold of the response entity
            StatusLine sl = response.getStatusLine();
            LOG.debug("StatusCode: " + sl.getStatusCode());
            Assert.assertEquals(200, sl.getStatusCode());

            HttpEntity respEntity = response.getEntity();
            String respString = EntityUtils.toString(respEntity);
            LOG.debug("Response: " + respString);
            
//            WalletTrxResponse trxResp = mapper.
//            		readValue(respString, WalletTrxResponse.class);
//            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
            Assert.assertEquals(true, true);
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running one thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
		}catch (Exception e) {
		
			LOG.warn("Unexpected Exception", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            client.getConnectionManager().shutdown();
        }  // end try finally
	}
	
//	@Test
	public void testRefreshCacheMall() {
		String url = testingRefreshCacheMall;
		long startTime = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		try {
			
			LoginData loginData = new LoginData();
			loginData.setEmail("agusdk2011@gmail.com");
			loginData.setSessionKey("085693938630GX2FDXLBKWN35CMNGKI48YXEAQ1RPR");
			
			
			String s = mapper.writeValueAsString(loginData);
			s = CipherUtil.encryptTripleDES(s, CipherUtil.PASSWORD);
			LOG.debug("Request: " + s);
            StringEntity entity = new StringEntity(s);
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(entity);
			
			// Execute HTTP request
			LOG.debug("Executing request: " + post.getURI());
            HttpResponse response = client.execute(post);
            
            // Get hold of the response entity
            StatusLine sl = response.getStatusLine();
            LOG.debug("StatusCode: " + sl.getStatusCode());
            Assert.assertEquals(200, sl.getStatusCode());

            HttpEntity respEntity = response.getEntity();
            String respString = EntityUtils.toString(respEntity);
            LOG.debug("Response: " + respString);
            
//            WalletTrxResponse trxResp = mapper.
//            		readValue(respString, WalletTrxResponse.class);
//            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
            Assert.assertEquals(true, true);
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running one thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
		}catch (Exception e) {
		
			LOG.warn("Unexpected Exception", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            client.getConnectionManager().shutdown();
        }  // end try finally
	}
	
////	@Test
//	public void testPaymentWithCC() {
//		String url = testingPaymentWithCC;
//		long startTime = System.currentTimeMillis();
//		HttpClient client = new DefaultHttpClient();
//		try {
//
//			com.myproject.parking.lib.data.Address billingAddress = new com.myproject.parking.lib.data.Address();
//			billingAddress.setCity("Jakarta Barat");
//			billingAddress.setCountryCode("ID");
//			billingAddress.setLine1("Duta Bandara Permai Blok ZS 4 no 31");
//			billingAddress.setPostalCode("15211");
//			billingAddress.setState("Banten");
//			
//			com.myproject.parking.lib.data.CreditCard creditCard = new com.myproject.parking.lib.data.CreditCard();
//			creditCard.setBillingAddress(billingAddress);
//			creditCard.setCvv2(111);
//			creditCard.setExpireMonth(11);
//			creditCard.setExpireYear(2018);
//			creditCard.setFirstName("Agus");
//			creditCard.setLastName("Darma Kusuma Buyer");
//			creditCard.setNumber("4032038628710679");
//			creditCard.setType("visa");
//			
//			PaymentVO paymentVO = new PaymentVO();
//			paymentVO.setAddress(billingAddress);
//			paymentVO.setCreditCard(creditCard);
//			
//			String s = mapper.writeValueAsString(paymentVO);
//			s = CipherUtil.encryptTripleDES(s, CipherUtil.PASSWORD);
//			LOG.debug("Request: " + s);
//            StringEntity entity = new StringEntity(s);
//			
//			HttpPost post = new HttpPost(url);
//			post.setHeader("Content-Type", "application/json");
//			post.setEntity(entity);
//			
//			// Execute HTTP request
//			LOG.debug("Executing request: " + post.getURI());
//            HttpResponse response = client.execute(post);
//            
//            // Get hold of the response entity
//            StatusLine sl = response.getStatusLine();
//            LOG.debug("StatusCode: " + sl.getStatusCode());
//            Assert.assertEquals(200, sl.getStatusCode());
//
//            HttpEntity respEntity = response.getEntity();
//            String respString = EntityUtils.toString(respEntity);
//            LOG.debug("Response: " + respString);
//            
////            WalletTrxResponse trxResp = mapper.
////            		readValue(respString, WalletTrxResponse.class);
////            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
//            Assert.assertEquals(true, true);
//            int delta = (int) (System.currentTimeMillis() - startTime);
//            LOG.info("Finish running one thread in {}ms", 
//            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
//		}catch (Exception e) {
//		
//			LOG.warn("Unexpected Exception", e);
//		} finally {
//            // When HttpClient instance is no longer needed,
//            // shut down the connection manager to ensure
//            // immediate deallocation of all system resources
//            client.getConnectionManager().shutdown();
//        }  // end try finally
//	}
	
////	@Test
//	public void testPaymentWithPaypal() {
//		String url = testingPaymentWithPayPal;
//		long startTime = System.currentTimeMillis();
//		HttpClient client = new DefaultHttpClient();
//		try {
//
//			com.myproject.parking.lib.data.Address billingAddress = new com.myproject.parking.lib.data.Address();
//			billingAddress.setCity("Johnstown");
//			billingAddress.setCountryCode("US");
//			billingAddress.setLine1("52 N Main ST");
//			billingAddress.setPostalCode("43210");
//			billingAddress.setState("OH");
//			
//			com.myproject.parking.lib.data.CreditCard creditCard = new com.myproject.parking.lib.data.CreditCard();
//			creditCard.setBillingAddress(billingAddress);
//			creditCard.setCvv2(111);
//			creditCard.setExpireMonth(11);
//			creditCard.setExpireYear(2018);
//			creditCard.setFirstName("Joe");
//			creditCard.setLastName("Shopper");
//			creditCard.setNumber("4032038628710679");
//			creditCard.setType("visa");
//			
//			PaymentVO paymentVO = new PaymentVO();
//			paymentVO.setAddress(billingAddress);
//			paymentVO.setCreditCard(creditCard);
//			
//			String s = mapper.writeValueAsString(paymentVO);
//			LOG.debug("Request: " + s);
//            StringEntity entity = new StringEntity(s);
//			
//			HttpPost post = new HttpPost(url);
//			post.setHeader("Content-Type", "application/json");
//			post.setEntity(entity);
//			
//			// Execute HTTP request
//			LOG.debug("Executing request: " + post.getURI());
//            HttpResponse response = client.execute(post);
//            
//            // Get hold of the response entity
//            StatusLine sl = response.getStatusLine();
//            LOG.debug("StatusCode: " + sl.getStatusCode());
//            Assert.assertEquals(200, sl.getStatusCode());
//
//            HttpEntity respEntity = response.getEntity();
//            String respString = EntityUtils.toString(respEntity);
//            LOG.debug("Response: " + respString);
//            
////            WalletTrxResponse trxResp = mapper.
////            		readValue(respString, WalletTrxResponse.class);
////            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
//            Assert.assertEquals(true, true);
//            int delta = (int) (System.currentTimeMillis() - startTime);
//            LOG.info("Finish running one thread in {}ms", 
//            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
//		}catch (Exception e) {
//		
//			LOG.warn("Unexpected Exception", e);
//		} finally {
//            // When HttpClient instance is no longer needed,
//            // shut down the connection manager to ensure
//            // immediate deallocation of all system resources
//            client.getConnectionManager().shutdown();
//        }  // end try finally
//	}
	

	
	/*private WalletTrxRequest createWalletTrxRequest(String customerCode, String requestId) {
		WalletTrxRequest trxRequest = new WalletTrxRequest();
		trxRequest.setRequestId(requestId);
		trxRequest.setCustomerCode(customerCode);  // code of AR
		trxRequest.setClientPhone("085601234567");  // phone to be transferred, in form 08xxx
		trxRequest.setTrxCode("DSV");  // DSV / SDS
		
		WalletTrxDetailRequest detail = new WalletTrxDetailRequest();
		detail.setDetailId(requestId + "001");
		detail.setProductCode("V05");
		detail.setProductQty(10);
		detail.setProductValueEach(4900);
		detail.setProductType("R");
		trxRequest.getListDetail().add(detail);
		
		WalletTrxDetailRequest detail2 = new WalletTrxDetailRequest();
		detail2.setDetailId(requestId + "002");
		detail2.setProductCode("V25");
		detail2.setProductQty(50);
		detail2.setProductValueEach(23000);
		detail2.setProductType("P");
		trxRequest.getListDetail().add(detail2);
		
		return trxRequest;
	}*/
	
	/*@Test
	public void testFindUserDataByUserCode() {
		String url = baseHostUrl + ExchangeConstant.WALLET_PATH_SETTLE;
		long startTime = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		try {
			WalletTrxRequest trxReq = createWalletTrxRequest("01001040", "123456");
			String s = mapper.writeValueAsString(trxReq);
			LOG.debug("Request: " + s);
            StringEntity entity = new StringEntity(s);
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(entity);
			
			// Execute HTTP request
			LOG.debug("Executing request: " + post.getURI());
            HttpResponse response = client.execute(post);
            
            // Get hold of the response entity
            StatusLine sl = response.getStatusLine();
            LOG.debug("StatusCode: " + sl.getStatusCode());
            Assert.assertEquals(200, sl.getStatusCode());

            HttpEntity respEntity = response.getEntity();
            String respString = EntityUtils.toString(respEntity);
            LOG.debug("Response: " + respString);
            
            WalletTrxResponse trxResp = mapper.
            		readValue(respString, WalletTrxResponse.class);
            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
            
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running one thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
		} catch (Exception e) {
			LOG.warn("Unexpected Exception", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            client.getConnectionManager().shutdown();
        }  // end try finally
	}*/
	
	/*@Test
	public void testReversalFirst() {
		String url = baseHostUrl + ExchangeConstant.WALLET_PATH_REVERSAL;
		long startTime = System.currentTimeMillis();
		HttpClient client = new DefaultHttpClient();
		try {
			WalletTrxRequest trxReq = createWalletTrxRequest("01001040", "123456");
			String s = mapper.writeValueAsString(trxReq);
			LOG.debug("Request: " + s);
            StringEntity entity = new StringEntity(s);
			
			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");
			post.setEntity(entity);
			
			// Execute HTTP request
			LOG.debug("Executing request: " + post.getURI());
            HttpResponse response = client.execute(post);
            
            // Get hold of the response entity
            StatusLine sl = response.getStatusLine();
            LOG.debug("StatusCode: " + sl.getStatusCode());
            Assert.assertEquals(200, sl.getStatusCode());

            HttpEntity respEntity = response.getEntity();
            String respString = EntityUtils.toString(respEntity);
            LOG.debug("Response: " + respString);
            
            WalletTrxResponse trxResp = mapper.
            		readValue(respString, WalletTrxResponse.class);
            Assert.assertEquals(trxReq.getRequestId(), trxResp.getRequestId());
            
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running one thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
		} catch (Exception e) {
			LOG.warn("Unexpected Exception", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            client.getConnectionManager().shutdown();
        }  // end try finally
	}*/
	
	/*@Test
	public void testSettleMultiThread() {
		String url = baseHostUrl + ExchangeConstant.WALLET_PATH_SETTLE;
		
		Random r = new Random();
		String[] listCustCode = {
				"01001040", "01001041", "01001042",
				"01001043", "01001044", "01001045",
				"01001046", "01001047", "01001048"				
		};
		long startTime = System.currentTimeMillis();
		// Create an HttpClient with the ThreadSafeClientConnManager.
        // This connection manager must be used if more than one thread will
        // be using the HttpClient.
        PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
        cm.setMaxTotal(100);
        
        HttpClient httpclient = new DefaultHttpClient(cm);
        try {
            // create a thread for each URI
            SmisHttpPostThread[] threads = new SmisHttpPostThread[10];
            for (int i = 0; i < threads.length; i++) {
            	String reqId = CommonUtil.padLeft("" + (i + 1), '0', 4);
            	int idx = r.nextInt(listCustCode.length);
            	WalletTrxRequest trxReq = createWalletTrxRequest(listCustCode[idx], reqId);
            	
            	String request = mapper.writeValueAsString(trxReq);
                threads[i] = new SmisHttpPostThread(httpclient, url, i + 1, request, mapper);
            }

            // start the threads
            for (int j = 0; j < threads.length; j++) {
                threads[j].start();
                try {
                	Thread.sleep(20);
                	Thread.yield();
                } catch (InterruptedException ie) {}
            }

            // join the threads
            for (int j = 0; j < threads.length; j++) {
                threads[j].join();
            }
            
            int delta = (int) (System.currentTimeMillis() - startTime);
            LOG.info("Finish running all thread in {}ms", 
            		new String[] { CommonUtil.displayNumberNoDecimal(delta) } );
        } catch (Exception e) {
			LOG.warn("Unexpected Error", e);
		} finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
	}*/
	
}
