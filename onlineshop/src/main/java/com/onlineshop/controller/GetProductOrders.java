package com.onlineshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineshop.entity.Orders;
import com.onlineshop.service.CustomerServiceInterface;
import com.onlineshop.utility.ServiceFactory;


@WebServlet(name = "GetProductsOrder", urlPatterns = {"/GetProductsOrder"})
public class GetProductOrders extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creating Session
        HttpSession hs = request.getSession();
        int order_no = 1000;
        int orderProducts = 0;
        //Getting all the parameters from the user
        int paymentId = Integer.parseInt(request.getParameter("payment_id"));
        String customerName = request.getParameter("name");
        String mobile_number = request.getParameter("phone");
        String email_id = request.getParameter("email");
        String address = request.getParameter("address");
        String address_type = request.getParameter("addressType");
        String pincode = request.getParameter("pincode");
        String product_name = null;
        int quantity = 0;
        String product_price = null;
        String product_selling_price = null;
        String product_total_price = null;
        String order_status = null;
        String payment_mode = request.getParameter("payment");
        HttpSession session = request.getSession();
        //Storing payment attrbute in session
        session.setAttribute("paymentId", paymentId);
        
        CustomerServiceInterface cService=ServiceFactory.getObject("cusomer");

        try {
            //Getting maximium column of tblorders table
        	order_no=cService.findMaxOrderService();
        	
        	order_no = 1000 + order_no;
           
            //Getting all the orders from the database
        	List<Orders> totalProduct=cService.findTotalProductService(session.getAttribute("id"),order_no);
           
            for (Orders oo:totalProduct) {
                
                String image_name = oo.getImage();
                		
                product_name = oo.getProduct_name();
                quantity = oo.getQuantity();
                product_price = oo.getProduct_price();
                product_selling_price = oo.getProduct_selling_price();
                product_total_price = oo.getProduct_total_price();
                order_status = "Pending";
                //Inserting product details inside the table
                Orders order=new Orders();
                order.setOrder_no(order_no);
                order.setCustomer_name(customerName);
                order.setMobile_number(mobile_number);
                order.setEmail_id(email_id);
                order.setAddress(address);
                order.setAddress_type(address_type);
                order.setPincode(pincode);
                order.setImage(image_name);
                order.setProduct_name(product_name);
                order.setQuantity(quantity);
                order.setProduct_price(product_price);
                order.setProduct_selling_price(product_selling_price);
                order.setProduct_total_price(product_total_price);
                order.setOrder_status(order_status);
                order.setPayment_mode(payment_mode);
                order.setPayment_id(paymentId);
                
               
                orderProducts=cService.addOrderService(order);
              
            }
            cService.deleteFromCartService(session.getAttribute("id"));
            if (orderProducts > 0) {
                //Sending response back to the user/customer
                String message = "Thank you for your order.";
                hs.setAttribute("success", message);
                response.sendRedirect("checkout.jsp");
            } else {
                response.sendRedirect("checkout.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
