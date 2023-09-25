package com.example.payrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entity.PaymentDetails;



@Repository
public interface PaymentRepository  extends  JpaRepository<PaymentDetails, String> {

}
