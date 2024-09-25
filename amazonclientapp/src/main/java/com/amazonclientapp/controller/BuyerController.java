package com.amazonclientapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.amazonclientapp.dto.Customer;
import com.amazonclientapp.dto.Orders;
import com.amazonclientapp.dto.Product;
import com.amazonclientapp.dto.ShopingCart;

@Controller
public class BuyerController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("AddToCart")
	public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response) {
		int id = 0;
		System.out.println("inn bu");
		ModelAndView mv = new ModelAndView();
		// Getting all the parameters from the user
		int productId = Integer.parseInt(request.getParameter("productId"));
		String price = request.getParameter("price");
		String mrp_price = request.getParameter("mrp_price");

		HttpSession hs = request.getSession();

		// If user session is null user have to re-login
		if ((String) hs.getAttribute("name") == null) {
			mv.setViewName("customer-login.jsp");
			// Inserting cart details to the database
		} else {
			int customerId = (int) hs.getAttribute("id");
			System.out.println();
			ShopingCart sCart = new ShopingCart();
			sCart.setCustomer_id(customerId);
			sCart.setDiscount_price(price);
			sCart.setMrp_price(mrp_price);
			sCart.setProduct_id(productId);
			sCart.setQuantity(1);
			sCart.setTotal_price(price);
			sCart.setId(id);

			List<ServiceInstance> instances = discoveryClient.getInstances("BUYERSERVICE");
			ServiceInstance serviceInstance = instances.get(0);

			String baseUrl = serviceInstance.getUri().toString(); // return http://localhost:8080

			baseUrl = baseUrl + "/AddToCart";

			RestTemplate restTemplate = new RestTemplate();
			int addToCart = restTemplate.postForObject(baseUrl, sCart, Integer.class);
			System.out.println("buyer " + addToCart);
			// int addToCart=bservice.addtoCartService(sCart);

			if (addToCart > 0) {
				List<ServiceInstance> instances5 = discoveryClient.getInstances("ADMINSERVICE");
				ServiceInstance serviceInstance5 = instances5.get(0);
				String baseUrl1 = serviceInstance5.getUri().toString(); // return http://localhost:8080

				baseUrl1 = baseUrl1 + "/viewproducts";
				List<Product> allproduct = restTemplate.getForObject(baseUrl1, List.class, 1L);

				List<ServiceInstance> instances1 = discoveryClient.getInstances("RETAILERSERVICE");
				ServiceInstance serviceInstance1 = instances1.get(0);
				String baseUrl2 = serviceInstance1.getUri().toString(); // return http://localhost:8080
				baseUrl2 = baseUrl2 + "/totalcountofcartitem/" + customerId;

				RestTemplate restTemplate2 = new RestTemplate();
				int i1 = restTemplate2.getForObject(baseUrl2, Integer.class, 1L);
				mv.addObject("totalcartitem", i1);

				mv.addObject("allproduct", allproduct);

				mv.setViewName("index1.jsp");
			}
		}

		return mv;
	}

	@RequestMapping("GetProductsOrder")
	public ModelAndView loginCustomer(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		HttpSession hs = request.getSession();
		int order_no = 1000;
		int orderProducts = 0;
		// Getting all the parameters from the user
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

		// Storing payment attrbute in session
		hs.setAttribute("paymentId", paymentId);

		try {
			// Getting maximium column of tblorders table

			List<ServiceInstance> instances = discoveryClient.getInstances("BUYERSERVICE");
			ServiceInstance serviceInstance = instances.get(0);

			String baseUrl = serviceInstance.getUri().toString(); // return http://localhost:8080

			baseUrl = baseUrl + "/findMaxOrder";

			RestTemplate restTemplate = new RestTemplate();
			order_no = restTemplate.getForObject(baseUrl, Integer.class);
			System.out.println("orderno " + order_no);
			// order_no=bservice.findMaxOrderService();

			order_no = 1000 + order_no;

			List<ServiceInstance> instances1 = discoveryClient.getInstances("BUYERSERVICE");
			ServiceInstance serviceInstance1 = instances1.get(0);

			String baseUrl1 = serviceInstance1.getUri().toString(); // return http://localhost:8080

			baseUrl1 = baseUrl1 + "/findTotalProduct/" + hs.getAttribute("id") + "/" + order_no;

			RestTemplate restTemplate1 = new RestTemplate();
			List<Object> totalProduct = restTemplate1.getForObject(baseUrl1, List.class, 1L);
			System.out.println(totalProduct);
			// Getting all the orders from the database
			// List<Object>
			// totalProduct=bservice.findTotalProductService(hs.getAttribute("id"),order_no);
			// [9.png, dfdf, 1, 678, 333, 333, 2]
			for (Object oo1 : totalProduct) {
				List l1 = (List) oo1;
				System.out.println(l1.get(0) + "  " + l1.get(1));
				// Orders oo=(Orders)oo1;

				String image_name = l1.get(0).toString();

				product_name = l1.get(1).toString();
				quantity = (int) l1.get(2);
				product_price = l1.get(3).toString();
				product_selling_price = l1.get(4).toString();
				product_total_price = l1.get(5).toString();
				order_status = "Pending";
				// Inserting product details inside the table
				Orders order = new Orders();
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

				List<ServiceInstance> instances2 = discoveryClient.getInstances("BUYERSERVICE");
				ServiceInstance serviceInstance2 = instances2.get(0);

				String baseUrl2 = serviceInstance2.getUri().toString(); // return http://localhost:8080

				baseUrl2 = baseUrl2 + "/addOrderService";

				RestTemplate restTemplate2 = new RestTemplate();
				orderProducts = restTemplate2.postForObject(baseUrl2, order, Integer.class);
				System.out.println("orderproduct " + orderProducts);
				// orderProducts=bservice.addOrderService(order);

			}
			List<ServiceInstance> instances3 = discoveryClient.getInstances("BUYERSERVICE");
			ServiceInstance serviceInstance3 = instances3.get(0);

			String baseUrl3 = serviceInstance3.getUri().toString(); // return http://localhost:8080

			baseUrl3 = baseUrl3 + "/deletefromcart/" + hs.getAttribute("id");

			RestTemplate restTemplate3 = new RestTemplate();
			restTemplate3.getForObject(baseUrl3, Integer.class);

			// bservice.deleteFromCartService(hs.getAttribute("id"));
			if (orderProducts > 0) {
				// Sending response back to the user/customer
				String message = "Thank you for your order.";
				hs.setAttribute("success", message);
				mv.setViewName("checkout1.jsp");
			} else {
				mv.setViewName("checkout.jsp");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return mv;
	}

	@RequestMapping("UpdateProductQuantity")
	public ModelAndView updateProductQuantity(HttpServletRequest request, HttpServletResponse response) {
		int id = 0;

		ModelAndView mv = new ModelAndView();
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		HttpSession session = request.getSession();
		String discount_price = null;
		Double productPrice = 0.0;

		try {
			List<ServiceInstance> instances3 = discoveryClient.getInstances("BUYERSERVICE");
			ServiceInstance serviceInstance3 = instances3.get(0);

			String baseUrl3 = serviceInstance3.getUri().toString(); // return http://localhost:8080

			baseUrl3 = baseUrl3 + "/updateProductService/" + session.getAttribute("id").toString() + "/" + productId
					+ "/" + quantity;

			RestTemplate restTemplate3 = new RestTemplate();
			int updateQuantity = restTemplate3.getForObject(baseUrl3, Integer.class);

			// int
			// updateQuantity=bservice.updateProductService(session.getAttribute("id").toString(),productId,quantity);
			// If cart is sucessfully updated
			if (updateQuantity > 0) {
				// Sending response back to the user/customer.
				mv.setViewName("checkout.jsp");
				// If cart is not updated
			} else {
				// Sending response back to the user/customer.
				mv.setViewName("checkout.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("checkout")
	public ModelAndView checkout(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();

		List<ServiceInstance> instances1 = discoveryClient.getInstances("RETAILERSERVICE");
		ServiceInstance serviceInstance1 = instances1.get(0);
		String baseUrl2 = serviceInstance1.getUri().toString(); // return http://localhost:8080
		baseUrl2 = baseUrl2 + "/totalcountofcartitem/" + session.getAttribute("id");

		RestTemplate restTemplate2 = new RestTemplate();
		int i1 = restTemplate2.getForObject(baseUrl2, Integer.class, 1L);
		mv.addObject("totalcartitem", i1);

		System.out.println("total cart item " + i1);
		// ----------------------------------------------------------------
		List<ServiceInstance> instances3 = discoveryClient.getInstances("BUYERSERVICE");
		ServiceInstance serviceInstance3 = instances3.get(0);

		String baseUrl3 = serviceInstance3.getUri().toString(); // return http://localhost:8080

		baseUrl3 = baseUrl3 + "/findTotalProduct1/" + session.getAttribute("id");

		RestTemplate restTemplate3 = new RestTemplate();
		List<Object> totalorder = restTemplate3.getForObject(baseUrl3, List.class);
		mv.addObject("totalorder", totalorder);
		System.out.println("total order " + totalorder);
		List l1 = (List) totalorder.get(0);
		System.out.println(l1.get(0) + "  " + l1.get(1));
		System.out.println(totalorder.get(1));
		// ---------------------------------------------------------------------
		List<ServiceInstance> instances4 = discoveryClient.getInstances("BUYERSERVICE");
		ServiceInstance serviceInstance4 = instances4.get(0);

		String baseUrl4 = serviceInstance4.getUri().toString(); // return http://localhost:8080

		baseUrl4 = baseUrl4 + "/totalbill/" + session.getAttribute("id");

		RestTemplate restTemplate4 = new RestTemplate();
		List<Object> totalbill = restTemplate4.getForObject(baseUrl4, List.class);
		mv.addObject("totalbill", totalbill);
		System.out.println("total bill " + totalbill);
		// --------------------------------------------------
		List<ServiceInstance> instances5 = discoveryClient.getInstances("ADMINSERVICE");
		ServiceInstance serviceInstance5 = instances5.get(0);
		String baseUrl5 = serviceInstance5.getUri().toString(); // return http://localhost:8080

		baseUrl5 = baseUrl5 + "/customerbyid/" + session.getAttribute("id");
		RestTemplate restTemplate5 = new RestTemplate();
		Customer customer = restTemplate5.getForObject(baseUrl5, Customer.class, 1L);
		mv.addObject("customer", customer);
		System.out.println("customer " + customer);
		// ----------------------------------------------------------------------
		List<ServiceInstance> instances6 = discoveryClient.getInstances("BUYERSERVICE");
		ServiceInstance serviceInstance6 = instances6.get(0);

		String baseUrl6 = serviceInstance6.getUri().toString(); // return http://localhost:8080

		baseUrl6 = baseUrl6 + "/maxpaymentid";

		RestTemplate restTemplate6 = new RestTemplate();
		int maxpaymentid = restTemplate6.getForObject(baseUrl6, Integer.class);
		mv.addObject("maxpaymentid", maxpaymentid);
		System.out.println("max payment id " + maxpaymentid);
		mv.setViewName("checkout.jsp");

		return mv;
	}

	@RequestMapping("myorder")
	public ModelAndView myorder(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();

		List<ServiceInstance> instances1 = discoveryClient.getInstances("RETAILERSERVICE");
		ServiceInstance serviceInstance1 = instances1.get(0);
		String baseUrl2 = serviceInstance1.getUri().toString(); // return http://localhost:8080
		baseUrl2 = baseUrl2 + "/totalcountofcartitem/" + session.getAttribute("id");

		RestTemplate restTemplate2 = new RestTemplate();
		int i1 = restTemplate2.getForObject(baseUrl2, Integer.class, 1L);
		mv.addObject("totalcartitem", i1);

		List<ServiceInstance> instances3 = discoveryClient.getInstances("BUYERSERVICE");
		ServiceInstance serviceInstance3 = instances3.get(0);

		String baseUrl3 = serviceInstance3.getUri().toString(); // return http://localhost:8080

		baseUrl3 = baseUrl3 + "/myorder/" + session.getAttribute("name");

		RestTemplate restTemplate3 = new RestTemplate();
		List<Orders> totalorder = restTemplate3.getForObject(baseUrl3, List.class);
		mv.addObject("myorder", totalorder);
		System.out.println("total order " + totalorder);
		
		mv.setViewName("my-orders.jsp");
		
		return mv;
	}

}
