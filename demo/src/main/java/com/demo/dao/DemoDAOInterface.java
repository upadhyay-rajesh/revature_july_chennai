package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.Employee;

@Repository
public interface DemoDAOInterface extends JpaRepository<Employee, String>{
	@Query(value = "from com.demo.entity.Employee e where e.email=:em and e.password=:pwd", nativeQuery = true)
	public void login(@Param("em") String uname, @Param("pwd") String password);
}
