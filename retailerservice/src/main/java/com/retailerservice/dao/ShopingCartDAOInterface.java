package com.retailerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailerservice.entity.ShopingCart;

@Repository
public interface ShopingCartDAOInterface extends JpaRepository<ShopingCart, Integer>{

}
