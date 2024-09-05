package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface DemoServiceInterface {

	Employee createProfileService(Employee ee);

	List<Employee> viewAllEmployee();

	Employee viewEmployee(Employee e1);

	Employee editProfileService(Employee ee);

	String deleteEmployee(Employee e1);

	Employee loginProfileService(Employee ee);

}
