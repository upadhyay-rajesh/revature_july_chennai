package com.onlineshopboot.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.onlineshopboot.entity.Customer;
import com.onlineshopboot.service.AdminServiceInterface;

@Controller
public class AdminController {
	
	@Autowired
	private AdminServiceInterface aservice;
	
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
		
		int addCustomer=aservice.createProfile(customer);
		
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

     
        String i=aservice.adminLoginService(email,password);
        
        ModelAndView mv=new ModelAndView();
        
        if (i!=null) {
            hs.setAttribute("uname", i);
            //Redirecting admin to dashboard page
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
}

    






