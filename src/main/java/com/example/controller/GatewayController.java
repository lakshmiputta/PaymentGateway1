package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Merchant;
import com.example.entity.PaymentDetails;
import com.example.service.GatewayService;

import jakarta.validation.Valid;


@RestController
public class GatewayController {
	@Autowired
	private GatewayService gatewayService;
	
	@PostMapping("/Registration")
	public ResponseEntity<Object> registration(@Valid @RequestBody Merchant merchant)
	
	{ 
		Object register= gatewayService.merchantRegistration(merchant);
		return new ResponseEntity<Object>( register,HttpStatus.OK);
	}
	@PostMapping("/PaymentDetails")
	public ResponseEntity<Object>  paymentDetails(@Valid @RequestBody PaymentDetails pay)
	{
	   Object payment= gatewayService.paymentDetails(pay);
		return new  ResponseEntity<Object>( payment,HttpStatus.OK);
	
	}
	@GetMapping("/CheckStatus/{paymentId}")
	public ResponseEntity<Object>  checkStatus(@PathVariable String paymentId)
	{
		Object status= gatewayService.statusChecking(paymentId);
		return new  ResponseEntity<Object>( status,HttpStatus.OK);
	}
	@GetMapping("/PaymentList/{merchantName}")
	public ResponseEntity<Object>  paymentList(@PathVariable String merchantName)
	{
		Object list= gatewayService.getPaymentList(merchantName);
		return new  ResponseEntity<Object>( list,HttpStatus.OK);
	}

}
