package com.onlineshop.controller;
import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.entity.Customer;
import com.onlineshop.service.CustomerServiceInterface;
import com.onlineshop.utility.ServiceFactory;

@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Getting all data from user/customer
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        
        CustomerServiceInterface cService=ServiceFactory.getObject("cusomer");
        Customer i=cService.customerLoginService(email,pass);
        
        //Creating Session
        HttpSession hs = request.getSession();
        try {
             if (email != null && pass != null) {
                if (i!=null) {
                    //Storing the login details in session
                    hs.setAttribute("id", i.getId());
                    hs.setAttribute("name", i.getName());
                    //Redirecting response to the index.jsp
                    response.sendRedirect("index.jsp");
                } else {
                    //If wrong credentials are entered
                    String message = "You have enter wrong credentials";
                    hs.setAttribute("credential", message);
                    //Redirecting response to the customer-login.jsp
                    response.sendRedirect("customer-login.jsp");
                }
            } else {
                //If username or password is empty or null
                String message = "User name or Password is null";
                hs.setAttribute("credential", message);
                //Redirecting response to the customer-login.jsp
                response.sendRedirect("customer-login.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
