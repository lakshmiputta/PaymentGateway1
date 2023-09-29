package com.example.entity;




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Merchant {
	
	 @NotBlank(message = " MerchantId is mandatory")
	private String merchantId;
	
	 @NotBlank(message = " MerchantName should not be null")
	private String merchantName;
	
@Email(message = "Email Format is not correct")
	private String email;
	
	 @NotBlank(message = " Business is mandatory")
	private String business;
	
	 @NotBlank(message = " Address is mandatory")
	private String address;	

	
	 @NotBlank(message = " Phone is mandatory")
	private String phone;
	
	 
	public Merchant() {
		super();
	}
	public Merchant(String merchantId, String merchantName, String email, String business, String address, String phone) {
		super();
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.email = email;
		this.business = business;
		this.address = address;
		this.phone = phone;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getmerchantName() {
		return merchantName;
	}
	public void setName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
