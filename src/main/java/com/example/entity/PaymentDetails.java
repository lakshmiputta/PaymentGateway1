package com.example.entity;

import jakarta.validation.constraints.NotBlank;

public class PaymentDetails {

	 @NotBlank(message = " httpMessage:MerchantId is mandatory")
	private String merchantId;
	
	 @NotBlank(message = "Amount is mandatory")
	private String amount;
	
	 @NotBlank(message = "Currency is mandatory")
	private String currency;
	
	 @NotBlank(message = "OrderId is mandatory")
	private String orderId;
	
	private String payId;
	 
	private String paymentStatus;



	

	
	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
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

	

}
