package com.example.JdbcTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.example.entity.Merchant;
import com.example.entity.PaymentDetails;
@Repository
public class DaoJdbcTemplate {
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  private final String INSERT_MERCHANT="INSERT INTO MerchantTable VALUES (?,?,?,?,?,?);";
	  private final String INSERT_PAYMENT="INSERT INTO PaymentTable VALUES (?,?,?,?,?,?);";
	  private final String GET_MERCHANTID="SELECT merchantId FROM MerchantTable WHERE merchantId=? ";
	  public final String GET_STATUS="SELECT * FROM PaymentTable WHERE  paymentId=?";
	  public final String GET_PAYMENT_LIST="SELECT pay.merchantId,pay.amount,pay.currency,pay.orderId,pay.paymentId, merchant.merchantName,pay.paymentStatus "
	  		+ "FROM PaymentTable pay "
	  		+ "Inner JOIN MerchantTable merchant  "
	  		+ "ON pay.merchantId=merchant.merchantId "
	  		+ "WHERE merchantName like ?";
	  
	  
	  public Object saveMerchant(Merchant merchant) {
		  return jdbcTemplate
	                .update(INSERT_MERCHANT, merchant.getMerchantId(),merchant.getmerchantName(),
	                		merchant.getEmail(),merchant.getBusiness(),merchant.getAddress(),merchant.getPhone());  
	  }
	  public Object savePayment(PaymentDetails pay) {
		  return jdbcTemplate
	                .update(INSERT_PAYMENT, pay.getPayId(),pay.getMerchantId(),pay.getAmount(),pay.getCurrency(),
	                		pay.getOrderId(),pay.getPaymentStatus());   
	  }
	  public String gettingMerchantID(String merchantId) {
		  return jdbcTemplate
	                .queryForObject(GET_MERCHANTID,String.class,merchantId); 
	  }
	 
	public PaymentDetails getStatus(String paymentId) {
		
		return jdbcTemplate
		        .queryForObject(GET_STATUS,new BeanPropertyRowMapper<PaymentDetails>(PaymentDetails.class),paymentId); 

	  }
	 
		public List<PaymentDetails> paymentList(String merchantName) {
			
//		return jdbcTemplate.query(GET_PAYMENT_LIST, new RowMapperResultSetExtractor<>(new BeanPropertyRowMapper<PaymentDetails>(PaymentDetails.class)), "%"+merchantName+"%");
			return jdbcTemplate.query(GET_PAYMENT_LIST, new PaymentDetailsRowmapper(), "%"+merchantName+"%");

		}
		
	
}

		  
		  
		  
  
		  
				  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
