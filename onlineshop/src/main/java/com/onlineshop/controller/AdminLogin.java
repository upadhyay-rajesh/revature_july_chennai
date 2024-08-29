package com.onlineshop.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.service.CustomerServiceInterface;
import com.onlineshop.utility.ServiceFactory;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Getting all the parameters from the frontend (admin)
            String email = request.getParameter("email");
            String pass = request.getParameter("upass");

            //Retriving our session
            HttpSession hs = request.getSession();

            CustomerServiceInterface cService=ServiceFactory.getObject("cusomer");
            String i=cService.adminLoginService(email,pass);
            
            if (i!=null) {
                hs.setAttribute("uname", i);
                //Redirecting admin to dashboard page
                response.sendRedirect("dashboard.jsp");

            } else {
                //If details are wrong
                String message = "You have enter wrong credentials";
                hs.setAttribute("credential", message);
                //Redirecting admin to admin login page
                response.sendRedirect("admin-login.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
