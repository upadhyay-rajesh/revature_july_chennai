package com.adminservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adminservice.entity.Customer;
import com.adminservice.entity.Orders;
import com.adminservice.entity.Product;
import com.adminservice.service.AdminServiceInterface;

@RestController
public class AdminController {
	
	@Autowired
	private AdminServiceInterface adminService;
	
	@PostMapping("AddCustomer")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		int addCustomer=adminService.createProfile(customer);
		
	
        ResponseEntity<Object> rEntity=new ResponseEntity<Object>(addCustomer, HttpStatus.OK);
		return rEntity;
	}
	
	
	@PostMapping("AdminLogin")
	public ResponseEntity<List<Object>> loginCustomer(@RequestBody Customer customer) {
	    Customer c=adminService.adminLoginService(customer);
	    ResponseEntity<List<Object>> rEntity=null;
	    List<Object> ll=new ArrayList<Object>();
       // System.out.println(c.getAddress()+c.getName());
	    if(c!=null  && c.getEmail().equals("admin@gmail.com")) {
	    	List<Product> ll1= adminService.getAllProducts();
	    	int allproduct=ll1.size();
	    	List<Orders> ll2=adminService.getAllOrderes();
	    	int allorders=ll2.size();
	    	List<Customer> ll3=adminService.getAllCustomers();
	    	int allcustomer=ll3.size();
	    	ll.add(c);
	    	ll.add(allproduct);
	    	ll.add(allorders);
	    	ll.add(allcustomer);
	    	rEntity=new ResponseEntity<List<Object>>(ll, HttpStatus.OK);
	    }
	    rEntity=new ResponseEntity<List<Object>>(ll, HttpStatus.OK);
		
		return rEntity;
	}
	
	@GetMapping("CustomerProductsOrderStatus/{oid}")
	public int CustomerProductsOrderStatus(@PathVariable("oid") String orderid) {
		
		 int statusMode=adminService.updateOrderStatusService(Integer.parseInt(orderid));
		 
		 
		return statusMode;
	}
	
	@GetMapping("allOrderes")
	public List<Orders> getAllOrderes(){
		return adminService.getAllOrderes();
	}
	
	@GetMapping("viewproducts")
	public List<Product> viewAllProduct(){
		return adminService.getAllProducts();
	}
	
	@GetMapping("viewcustomers")
	public List<Customer> viewAllCustomers(){
		return adminService.getAllCustomers();
	}
	
	@GetMapping("customerbyid/{cid}")
	public Customer customerbyid(@PathVariable("cid") String cid){
		return adminService.getCustomerById(cid);
	}
	
	@GetMapping("deleteorder/{cid}")
	public int deleteorderbyid(@PathVariable("cid") String oid){
		return adminService.deleteorderById(Integer.parseInt(oid));
	}
	
	@GetMapping("editorder/{cid}")
	public Product editorderbyid(@PathVariable("cid") String oid){
		return adminService.editorderById(Integer.parseInt(oid));
	}
	@PostMapping("editproduct")
	public int editproduct(@RequestBody Product pp){
		return adminService.editproduct(pp);
	}
}




