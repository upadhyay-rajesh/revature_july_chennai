package com.onlineshop.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.entity.Customer;
import com.onlineshop.service.CustomerServiceInterface;
import com.onlineshop.utility.ServiceFactory;

@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Retrieving values from the frontend
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String pincode = request.getParameter("pincode");
        
        Customer customer=new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setMobile(mobile);
        customer.setGender(gender);
        customer.setAddress(address);
        customer.setPincode(pincode);
        
        CustomerServiceInterface cService=ServiceFactory.getObject("customer");
        int addCustomer=cService.addCustomerService(customer);
        

        //Creating Session
        HttpSession hs = request.getSession(true);

        
        try {
            
            if (addCustomer > 0) {
                String message = "Customer register successfully.";
                //Passing message via session.
                hs.setAttribute("success-message", message);
                //Sending response back to the user/customer
                response.sendRedirect("customer-register.jsp");
            } else {
                //If customer fails to register 
                String message = "Customer registration fail";
                //Passing message via session.
                hs.setAttribute("fail-message", message);
                //Sending response back to the user/customer
                response.sendRedirect("customer-register.jsp");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
