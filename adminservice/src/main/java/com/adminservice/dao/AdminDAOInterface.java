package com.adminservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adminservice.entity.Customer;

@Repository
public interface AdminDAOInterface extends JpaRepository<Customer, Integer>{
	
	@Query("from com.adminservice.entity.Customer e where e.email=:em and e.password=:pwd")
	public Customer loginUser(@Param("em") String email, @Param("pwd") String password);

}
