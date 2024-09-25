package com.buyerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buyerservice.entity.Orders;


@Repository
public interface OrderDAOInterface extends JpaRepository<Orders, Integer>{

}
