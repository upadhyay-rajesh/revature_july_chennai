package com.adminservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adminservice.entity.Customer;
import com.adminservice.entity.Product;

@Repository
public interface ProductDAOInterface extends JpaRepository<Product, Integer>{
	
	
}
