package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity(name="merchant")
public class Merchant {
	@Id
	@Column(name="merchantid")
	private String merchantId;
	@Column(name="name")
	private String merchantName;
	@Column(name="email")
	private String email;
	@Column(name="business")
	private String business;
	@Column(name="address")
	private String address;
	@Column(name="phone")
	private int phone;
	
	public Merchant() {
		super();
	}
	public Merchant(String merchantId, String name, String email, String business, String address, int phone) {
		super();
		this.merchantId = merchantId;
		this.merchantName = name;
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
	public void setName(String name) {
		this.merchantName = name;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

}
