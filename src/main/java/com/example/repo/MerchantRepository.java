package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Merchant;

@Repository
public interface MerchantRepository extends  JpaRepository<Merchant, String> {

}
