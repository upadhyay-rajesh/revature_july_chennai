package com.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.DemoServiceInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

@RestController
public class DemoController {
	
	//@RequestMapping(value = "viewAllProfile" , method = HttpMethod.GET, produces = )
	
	
	@Autowired
	private DemoServiceInterface dservice;
	
	
	@GetMapping("viewAllProfile")
	public List<Employee> viewAllProfile() {
		return dservice.viewAllEmployee();
	}
	
	@GetMapping("viewProfile/{userid}")
	public Employee viewProfile(@PathVariable("userid") String email) {
		Employee e1=new Employee();
		e1.setEmail(email);
		
		
		return dservice.viewEmployee(e1);
	}
	
	
	
	@PostMapping("createProfile")
	public Employee createProfile(@RequestBody Employee ee) {
		Employee e1=dservice.createProfileService(ee);
		return e1;
	}
	@PutMapping("editProfile/{userid}")
	public Employee editProfile(@PathVariable("userid") String email,@RequestBody Employee ee) {
		ee.setEmail(email);
		return dservice.editProfileService(ee);
	}
	@DeleteMapping("deleteProfile/{userid}")
	public String deleteProfile(@PathVariable("userid") String email) {
		Employee e1=new Employee();
		e1.setEmail(email);
		
		
		return dservice.deleteEmployee(e1);
	}
	
	@PostMapping("loginProfile")
	public Employee loginProfile(@RequestBody Employee ee) {
		Employee e1=dservice.loginProfileService(ee);
		return e1;
	}

}









