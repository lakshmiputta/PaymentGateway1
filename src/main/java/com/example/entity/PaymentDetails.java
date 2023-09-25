package com.example.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity(name="payment")
public class PaymentDetails {

	@Id
	private String payId;
	
	@Column(name="merchantid")
	private String merchantId;
	
	@Column(name="payment_amount")
	private int amount;
	
	@Column(name="currency_mode")
	private String currency;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "payment_status")
	private String paymentStatus;

	

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentDetails get() {
		// TODO Auto-generated method stub
		return null;
	}

}
