package com.adminservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adminservice.entity.Customer;
import com.adminservice.entity.Product;

@Repository
public interface ProductDAOInterface extends JpaRepository<Product, Integer>{
	@Modifying(clearAutomatically = true)
	@Query("update Product set name=:name, price=:p, description=:d,mrp_price=:mp,active=:a where id=:id")
	int editProduct(@Param("name") String name,@Param("p") String price,@Param("d") String description,@Param("mp") String mrp,@Param("a") String act,@Param("id") int id );
	
	
}
