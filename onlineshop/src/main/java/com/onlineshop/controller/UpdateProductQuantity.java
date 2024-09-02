package com.onlineshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.service.CustomerServiceInterface;
import com.onlineshop.utility.ServiceFactory;


@WebServlet("/UpdateProductQuantity")
public class UpdateProductQuantity extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Getting all the data from the user/cutomer
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession();
        String discount_price = null;
        Double productPrice = 0.0;
        CustomerServiceInterface cService=ServiceFactory.getObject("cusomer");
        try {
        	int updateQuantity=cService.updateProductService(session.getAttribute("id").toString(),productId,quantity);
           //If cart is sucessfully updated
            if (updateQuantity > 0) {
                //Sending response back to the user/customer.
                response.sendRedirect("checkout.jsp");
                //If cart is not updated
            } else {
                 //Sending response back to the user/customer.
                response.sendRedirect("checkout.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}