package com.onlineshopboot.controller;

import java.io.IOException;
import java.util.List;

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
import com.onlineshopboot.entity.Orders;
import com.onlineshopboot.entity.ShopingCart;
import com.onlineshopboot.service.AdminServiceInterface;
import com.onlineshopboot.service.BuyerServiceInterface;

@Controller
public class BuyerController {
	
	@Autowired
	private BuyerServiceInterface bservice;
	
	@RequestMapping("AddToCart")
	public ModelAndView addCustomer(HttpServletRequest request,HttpServletResponse response) {
		 int id = 0;
		 ModelAndView mv=new ModelAndView();
	        //Getting all the parameters from the user
	        int productId = Integer.parseInt(request.getParameter("productId"));
	        String price = request.getParameter("price");
	        String mrp_price = request.getParameter("mrp_price");
	        
	        HttpSession hs = request.getSession();
	       
	            //If user session is null user have to re-login
	            if ((String) hs.getAttribute("name") == null) {
	               mv.setViewName("customer-login.jsp");
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
	                
	              
	                int addToCart=bservice.addtoCartService(sCart);
	               
	                if (addToCart > 0) {
	                	mv.setViewName("index.jsp");
	                }
	            }
				
		return mv;
	}
	
	
	@RequestMapping("GetProductsOrder")
	public ModelAndView loginCustomer(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv=new ModelAndView();
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
        
         //Storing payment attrbute in session
         hs.setAttribute("paymentId", paymentId);
        

         try {
             //Getting maximium column of tblorders table
         	order_no=bservice.findMaxOrderService();
         	
         	order_no = 1000 + order_no;
            
             //Getting all the orders from the database
         	List<Object> totalProduct=bservice.findTotalProductService(hs.getAttribute("id"),order_no);
            
             for (Object oo1:totalProduct) {
            	 
            	 Orders oo=(Orders)oo1;
                 
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
                 
                
                 orderProducts=bservice.addOrderService(order);
               
             }
             bservice.deleteFromCartService(hs.getAttribute("id"));
             if (orderProducts > 0) {
                 //Sending response back to the user/customer
                 String message = "Thank you for your order.";
                 hs.setAttribute("success", message);
                 mv.setViewName("checkout.jsp");
             } else {
            	 mv.setViewName("checkout.jsp");
             }
         } catch (Exception e) {
             System.out.println(e);
         }
		
		
		
		
		return mv;
	}
	
	@RequestMapping("UpdateProductQuantity")
	public ModelAndView updateProductQuantity(HttpServletRequest request,HttpServletResponse response) {
		 int id = 0;
		 ModelAndView mv=new ModelAndView();
		 int quantity = Integer.parseInt(request.getParameter("quantity"));
         int productId = Integer.parseInt(request.getParameter("productId"));
         HttpSession session = request.getSession();
         String discount_price = null;
         Double productPrice = 0.0;
      
         try {
         	int updateQuantity=bservice.updateProductService(session.getAttribute("id").toString(),productId,quantity);
            //If cart is sucessfully updated
             if (updateQuantity > 0) {
                 //Sending response back to the user/customer.
            	 mv.setViewName("checkout.jsp");
                 //If cart is not updated
             } else {
                  //Sending response back to the user/customer.
            	 mv.setViewName("checkout.jsp");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return mv;
	}
}

   
     








