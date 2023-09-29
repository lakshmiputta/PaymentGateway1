package com.example.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.entity.PaymentDetails;

public class PaymentDetailsRowmapper implements ResultSetExtractor<List<PaymentDetails>>{

	@Override
	public List<PaymentDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<PaymentDetails> paymentsList=new ArrayList<PaymentDetails>();
		while(rs.next()) {
			PaymentDetails payObj=new PaymentDetails();
			payObj.setPayId(rs.getString("paymentId"));
			payObj.setCurrency(rs.getString("currency"));
			payObj.setAmount(rs.getString("amount"));
			payObj.setMerchantId(rs.getString("merchantId"));
			payObj.setOrderId(rs.getString("orderId"));
			payObj.setPaymentStatus(rs.getString("paymentStatus"));
			paymentsList.add(payObj);
			
		}
		return paymentsList;
	}

}
