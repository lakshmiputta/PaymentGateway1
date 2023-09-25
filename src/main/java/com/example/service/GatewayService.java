package com.example.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Merchant;
import com.example.entity.PaymentDetails;
import com.example.exception.EmptyInputException;
import com.example.payrepo.PaymentRepository;
import com.example.repo.MerchantRepository;


@Service
public class GatewayService {
	@Autowired
	private MerchantRepository repo;
	private PaymentRepository payRepo;
	@Autowired
	public GatewayService(MerchantRepository  repo, PaymentRepository payRepo) {
		this.repo = repo;
		this.payRepo = payRepo;
	}
	
	public  Object merchantRegistration(Merchant merchant) {
		validate(merchant);
		String r = merchantId(merchant.getMerchantId());
		if(r.equals("Yes")){
			return new GatewayResponse("Already Registered",200,HttpStatus.ALREADY_REPORTED);
		} 
		else {
			repo.save(merchant);
			return new GatewayResponse("You are Registered",201,HttpStatus.OK);
		}
	}
		 public Object paymentDetails(PaymentDetails pay ) {
		
		int rNo=(int) (Math.random()*9000)+1000;
		String paymentId=String.valueOf(rNo);
		String msg=this.merchantId(pay.getMerchantId());
		pay.setPayId(paymentId);
		if(msg.equals("Yes"))
		{
			pay.setPaymentStatus("Payment Successful...");
			payRepo.save(pay);
			return new GatewayResponse("Payment Successfull and PaymentId is:" +paymentId,200,HttpStatus.OK);
		}
		else
		{
			pay.setPaymentStatus("Payment Failed..");
			payRepo.save(pay);
			return new GatewayResponse("Unsuccessfull Payment",409,HttpStatus.CONFLICT);
		}
		 }
		public Object statusChecking(@PathVariable String paymentId) {
			
			Optional<PaymentDetails> pd= payRepo.findById(paymentId);
			if(pd.isEmpty()) {
				return new GatewayResponse("Payment with PaymentId "+paymentId+" NotFound",409,HttpStatus.CONFLICT);
			}
			//return pd.get().getPaymentStatus();
			return pd.get();
		}
//	public Object getPaymentList(@PathVariable String merchantName) {
//			
//			Optional<PaymentDetails> pd=payRepo.findById(merchantId);
//			if(pd.isEmpty()) {
//				return new GatewayResponse("Payment with Merchant name "+merchantName+" NotFound",409,HttpStatus.CONFLICT);
//			}
//			//return pd.get().getPaymentStatus();
//			return pd.get();
//		}
		
	 public String merchantId(String MerchantId)
		{
			Optional<Merchant> m=repo.findById(MerchantId);
			if(m.isEmpty())
			{
				return "No";
			}
			else {
				return "Yes";
			}
		}
	 
	 public void validate(Merchant merchant)
	 {
		 if(merchant.getMerchantId()==null||merchant.getmerchantName()==null||merchant.getEmail()==null||merchant.getAddress()==null||merchant.getBusiness()==null)
		 {
			 throw new EmptyInputException("Input fields should not be empty");
		 }
	 }
	 

}
