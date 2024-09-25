package com.buyerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.buyerservice.entity.Customer;



@Repository
public interface RetailerDAOInterface extends JpaRepository<Customer, Integer>{
	

}
