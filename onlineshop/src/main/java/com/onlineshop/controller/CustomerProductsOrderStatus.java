package com.onlineshop.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineshop.service.CustomerServiceInterface;
import com.onlineshop.utility.ServiceFactory;


@WebServlet("/CustomerProductsOrderStatus")
public class CustomerProductsOrderStatus extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	 CustomerServiceInterface cService=ServiceFactory.getObject("cusomer");
        	 int statusMode=cService.updateOrderStatusService(request.getParameter("orderId"));
           // int statusMode = 0;
            //Taking input from admin order-id to get the order status from the database
            
            if (statusMode > 0) {
                //Sending response back to admin-all-orders.jsp page when sql query executed sucesfully
                response.sendRedirect("admin-all-orders.jsp");
            } else {
                //Sending response back to admin-all-orders.jsp page
                response.sendRedirect("admin-all-orders.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
