package com.retailerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailerservice.entity.Orders;

@Repository
public interface OrderDAOInterface extends JpaRepository<Orders, Integer>{

}