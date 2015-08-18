package com.myproject.parking.lib.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class TrxPayment implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * {"id":"PAY-9S330095V5543212RKXJA4XI","create_time":"2015-08-17T16:39:57Z",
	 * "update_time":"2015-08-17T16:40:01Z",
	 * "state":"approved","intent":"sale","payer":{"payment_method":"credit_card","funding_instruments":[{"credit_card":{"type":"visa","number":"xxxxxxxxxxxx7004","expire_month":"11","expire_year":"2018","first_name":"Joe","last_name":"Shopper"}}]},"transactions":[{"amount":{"total":"12.00","currency":"USD","details":{"subtotal":"12.00"}},"description":"creating a direct payment with credit card","related_resources":[{"sale":{"id":"2WW82402HE129220T","create_time":"2015-08-17T16:39:57Z","update_time":"2015-08-17T16:40:01Z","amount":{"total":"12.00","currency":"USD"},"state":"completed","parent_payment":"PAY-9S330095V5543212RKXJA4XI","links":[{"href":"https://api.sandbox.paypal.com/v1/payments/sale/2WW82402HE129220T","rel":"self","method":"GET"},{"href":"https://api.sandbox.paypal.com/v1/payments/sale/2WW82402HE129220T/refund","rel":"refund","method":"POST"},{"href":"https://api.sandbox.paypal.com/v1/payments/payment/PAY-9S330095V5543212RKXJA4XI","rel":"parent_payment","method":"GET"}]}}]}],"links":[{"href":"https://api.sandbox.paypal.com/v1/payments/payment/PAY-9S330095V5543212RKXJA4XI","rel":"self","method":"GET"}]}
	 */
	private long id;
	private String paymentId; // PAY-9S330095V5543212RKXJA4XI
	private Date createTime;
	private Date updateTime;
	private String state;
	private String paymentMethod;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
