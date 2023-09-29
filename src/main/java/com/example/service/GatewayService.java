package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.JdbcTemplate.DaoJdbcTemplate;
import com.example.entity.Merchant;
import com.example.entity.PaymentDetails;
import com.example.exception.EmptyInputException;


@Service
public class GatewayService {
	@Autowired
 private DaoJdbcTemplate daoJdbcTemplate;
	 
	
	public String paymentId;
	public  Object merchantRegistration(Merchant merchant) {
//	validate(merchant);
		try {
		
	String register = merchantId(merchant.getMerchantId());
		return new GatewayResponse("Already Registered",HttpStatus.ALREADY_REPORTED);
		}
		catch(EmptyResultDataAccessException e)
		{
			daoJdbcTemplate.saveMerchant(merchant);
			return new GatewayResponse("You are Registered",HttpStatus.OK);	
		}
	}

	 public String merchantId(String MerchantId)
		{
		String merchant= daoJdbcTemplate.gettingMerchantID(MerchantId);
	
		return MerchantId.isBlank()?"No":"yes";
		
		}
	 public void validate(Merchant merchant)  { 
		  
		  if(merchant.getMerchantId()==null||merchant.getmerchantName()==null||merchant.getEmail()==null||merchant.getAddress()==null||merchant.getBusiness()==null)
		   { 
		    throw new EmptyInputException("Input fields should not be empty"); 
		   
		  } 
		   }
	 public Object paymentDetails(PaymentDetails pay ) {
			
			int randomNo=(int) (Math.random()*999900)+100000;
			String paymentId=String.valueOf(randomNo);

			try
			{
				String msg=this.merchantId(pay.getMerchantId());
				pay.setPayId(paymentId);
				pay.setPaymentStatus("Payment Successful...");
				daoJdbcTemplate.savePayment(pay);
				return new GatewayResponse("Payment Successfull and PaymentId is:" +paymentId,HttpStatus.OK);
			}
			
			catch(EmptyResultDataAccessException e)
			{
				pay.setPaymentStatus("Payment Failed..");
				pay.setPayId(paymentId);
				daoJdbcTemplate.savePayment(pay);
				return new GatewayResponse("Unsuccessfull Payment",HttpStatus.CONFLICT);
			}
}
	 public Object statusChecking(@PathVariable String paymentId) {
			try{
				PaymentDetails pay=  daoJdbcTemplate.getStatus(paymentId);
				pay.setPayId(paymentId);
				return pay;
				}
	        catch(EmptyResultDataAccessException e){
		          return new GatewayResponse("Payment with PaymentId "+paymentId+" NotFound",HttpStatus.NOT_FOUND);
		}
	 }
		public Object getPaymentList(@PathVariable String merchantName) {
			
			try{
			
		      List<PaymentDetails> list=daoJdbcTemplate.paymentList(merchantName);
		     if( list.isEmpty())
		     {
			      return new GatewayResponse("Payment with Merchant Name "+merchantName+" NotFound",HttpStatus.NOT_FOUND);

		     }

				return list;
		}
	         catch(EmptyResultDataAccessException e){
		      return new GatewayResponse("Payment with Merchant Name "+merchantName+" NotFound",HttpStatus.NOT_FOUND);

	   }

	}
}
	

