package com.amazonclientapp.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.amazonclientapp.dto.Customer;
import com.amazonclientapp.dto.Orders;
import com.amazonclientapp.dto.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	@RequestMapping("AddCustomer")
	public ModelAndView addCustomer(HttpServletRequest request,HttpServletResponse response, @RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("email") String email,@RequestParam("address") String address,@RequestParam("mobile") String mobile,@RequestParam("gender") String gender,@RequestParam("pincode") String pincode) {
		    
		Customer customer=new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setMobile(mobile);
        customer.setGender(gender);
        customer.setAddress(address);
        customer.setPincode(pincode);
		
		
		
		List<ServiceInstance> instances=discoveryClient.getInstances("ADMINSERVICE");
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl=serviceInstance.getUri().toString(); //return http://localhost:8080
		
		baseUrl=baseUrl+"/AddCustomer";
		
		RestTemplate restTemplate=new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Customer> entity = new HttpEntity<Customer>(customer,headers);

		ResponseEntity<Object> str = restTemplate.exchange(baseUrl, HttpMethod.POST, entity, Object.class);
			int addCustomer=	(int) str.getBody();

		ModelAndView mv=new ModelAndView();
		HttpSession hs = request.getSession(true);
           
            if (addCustomer > 0) {
                String message = "Customer register successfully.";
                
                //sending email
              //  Mailer.send(email, "registration completed", "we are glad to inform that registration got completed"); 
                //Passing message via session.
                hs.setAttribute("success-message", message);
                //Sending response back to the user/customer
               
                mv.setViewName("customer-register.jsp");
            } else {
                //If customer fails to register 
                String message = "Customer registration fail";
                //Passing message via session.
                hs.setAttribute("fail-message", message);
                //Sending response back to the user/customer
               
                mv.setViewName("customer-register.jsp");
            }
	
		return mv;
	}
	
	
	@RequestMapping("AdminLogin")
	public ModelAndView loginCustomer(HttpServletRequest request,HttpServletResponse response,@RequestParam("upass") String password,@RequestParam("email") String email) {
		
		HttpSession hs = request.getSession();
		Customer customer=new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        
        List<ServiceInstance> instances=discoveryClient.getInstances("ADMINSERVICE");
		ServiceInstance serviceInstance=instances.get(0);
		String baseUrl=serviceInstance.getUri().toString(); //return http://localhost:8080
		baseUrl=baseUrl+"/AdminLogin";
		
		RestTemplate restTemplate=new RestTemplate();
	
		List<Object> cc1 = restTemplate.postForObject(
				baseUrl, customer, List.class);
				
		LinkedHashMap<String,String> ss=(LinkedHashMap<String,String>)cc1.get(0);
		
		
		int noofproduct=(Integer)cc1.get(1);
		int nooforder=(Integer)cc1.get(2);
		int noofcustomer=(Integer)cc1.get(3);
		
        ModelAndView mv=new ModelAndView();
        
        if (ss.get("name")!=null) {
            hs.setAttribute("uname", ss.get("name"));
            mv.addObject("nooforder", nooforder);
            mv.addObject("noofcustomer", noofcustomer);
            mv.addObject("noofproduct", noofproduct);
            
            mv.setViewName("dashboard.jsp");
          

        } else {
            //If details are wrong
            String message = "You have enter wrong credentials";
            hs.setAttribute("credential", message);
            //Redirecting admin to admin login page
            mv.setViewName("admin-login.jsp");
        }
		
		return mv;
	}
	/*
	@RequestMapping("CustomerProductsOrderStatus")
	public ModelAndView CustomerProductsOrderStatus(HttpServletRequest request,HttpServletResponse response,@RequestParam("upass") String password,@RequestParam("email") String email) {
		ModelAndView mv=new ModelAndView();
		HttpSession hs = request.getSession();
		 int statusMode=aservice.updateOrderStatusService(request.getParameter("orderId"));
         // int statusMode = 0;
          //Taking input from admin order-id to get the order status from the database
          
          if (statusMode > 0) {
              //Sending response back to admin-all-orders.jsp page when sql query executed sucesfully
        	  mv.setViewName("admin-all-orders.jsp");
          } else {
              //Sending response back to admin-all-orders.jsp page
        	  mv.setViewName("admin-all-orders.jsp");
          }
     
       
		
		return mv;
	}
	*/
	@RequestMapping("allorderes")
	public ModelAndView CustomerProductsOrderStatus() {
		ModelAndView mv=new ModelAndView();
		List<ServiceInstance> instances=discoveryClient.getInstances("ADMINSERVICE");
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl=serviceInstance.getUri().toString(); //return http://localhost:8080
		
		baseUrl=baseUrl+"/allOrderes";
		
		RestTemplate restTemplate=new RestTemplate();

		
		List<Orders> user = restTemplate.getForObject(baseUrl, List.class, 1L);
		
		
		System.out.println("hello "+user);
		
		mv.addObject("orderresult", user);
		mv.setViewName("admin-all-orders.jsp");
		
		return mv;
	}
	
	@RequestMapping("viewproducts")
	public ModelAndView viewProducts() {
		ModelAndView mv=new ModelAndView();
		List<ServiceInstance> instances=discoveryClient.getInstances("ADMINSERVICE");
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl=serviceInstance.getUri().toString(); //return http://localhost:8080
		
		baseUrl=baseUrl+"/viewproducts";
		
		RestTemplate restTemplate=new RestTemplate();

			List user = restTemplate.getForObject(baseUrl, List.class, 1L);
		
		
		System.out.println("hello "+user);
		
		mv.addObject("productresult", user);
		mv.setViewName("admin-view-product.jsp");
		
		return mv;
	}
	
	@RequestMapping("viewcustomers")
	public ModelAndView viewcustomers() {
		ModelAndView mv=new ModelAndView();
		List<ServiceInstance> instances=discoveryClient.getInstances("ADMINSERVICE");
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl=serviceInstance.getUri().toString(); //return http://localhost:8080
		
		baseUrl=baseUrl+"/viewcustomers";
		
		RestTemplate restTemplate=new RestTemplate();
	List<Customer> user = restTemplate.getForObject(baseUrl, List.class, 1L);
		
		
		System.out.println("hello "+user);
		
		mv.addObject("customerresult", user);
		mv.setViewName("admin-view-customers.jsp");
		
		return mv;
	}
	
	
	
}
