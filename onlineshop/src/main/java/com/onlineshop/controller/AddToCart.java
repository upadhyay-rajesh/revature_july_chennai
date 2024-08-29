package com.onlineshop.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.entity.ShopingCart;
import com.onlineshop.service.CustomerServiceInterface;
import com.onlineshop.utility.ServiceFactory;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = 0;

        //Getting all the parameters from the user
        int productId = Integer.parseInt(request.getParameter("productId"));
        String price = request.getParameter("price");
        String mrp_price = request.getParameter("mrp_price");
        HttpSession hs = request.getSession();
        try {
            //If user session is null user have to re-login
            if ((String) hs.getAttribute("name") == null) {
                response.sendRedirect("customer-login.jsp");
                //Inserting cart details to the database
            } else {
                int customerId = (int) hs.getAttribute("id");
                ShopingCart sCart=new ShopingCart();
                sCart.setCustomer_id(customerId);
                sCart.setDiscount_price(price);
                sCart.setMrp_price(mrp_price);
                sCart.setProduct_id(productId);
                sCart.setQuantity(1);
                sCart.setTotal_price(price);
                sCart.setId(id);
                
                CustomerServiceInterface cService=ServiceFactory.getObject("cusomer");
                int addToCart=cService.addtoCartService(sCart);
               
                if (addToCart > 0) {
                    response.sendRedirect("index.jsp");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
