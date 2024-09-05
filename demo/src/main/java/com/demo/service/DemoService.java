package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.DemoDAOInterface;
import com.demo.entity.Employee;

@Service
@Transactional
public class DemoService implements DemoServiceInterface {
	
	@Autowired
	private DemoDAOInterface ddao;

	@Override
	public Employee createProfileService(Employee ee) {
		ddao.save(ee);
		return ee;
	}


	public List<Employee> viewAllEmployee() {
		// TODO Auto-generated method stub
		return ddao.findAll();
	}


	@Override
	public Employee viewEmployee(Employee e1) {
		Employee ee=null;
		Optional<Employee> ll= ddao.findById(e1.getEmail());
		if(ll.isPresent()) {
			ee= ll.get();
		}
		return ee;
	}


	@Override
	public Employee editProfileService(Employee ee) {
		ddao.saveAndFlush(ee);
		return ee;
	}


	@Override
	public String deleteEmployee(Employee e1) {
		ddao.deleteById(e1.getEmail());
		return "profile deleted";
	}


	@Override
	public Employee loginProfileService(Employee ee) {
		ddao.login(ee.getEmail(), ee.getPassword());
		return ee;
	}

}








