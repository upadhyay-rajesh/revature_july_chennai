package com.buyerservice.controller;

import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.buyerservice.entity.Orders;
import com.buyerservice.entity.ShopingCart;
import com.buyerservice.service.BuyerServiceInterface;

@RestController
public class BuyerController {
	
	@Autowired
	private BuyerServiceInterface bservice;
	
	@PostMapping("AddToCart")
	public int addCustomer(@RequestBody ShopingCart sCart) {
	
		return bservice.addtoCartService(sCart);
	}
	
	
	
	@GetMapping("updateProductService/{cid}/{productId}/{quantity}")
	public int updateProductQuantity(@PathVariable("quantity") int quantity,@PathVariable("productId") int productId,@PathVariable("cid") String customerId) {
	
         return bservice.updateProductService(customerId,productId,quantity);
	}
	
	@GetMapping("maxpaymentid")
	public int maxpaymentid() {
		return bservice.findmaxpaymentidService();
	}
	
	@GetMapping("findMaxOrder")
	public int findMaxOrders() {
		return bservice.findMaxOrderService();
	}
	
	@GetMapping("findTotalProduct/{cid}/{orderid}")
	public List<Object> findTotalProduct(@PathVariable("cid") Object customerid,@PathVariable("orderid") int order_no) {
		return bservice.findTotalProductService(customerid,order_no);
	}
	
	@GetMapping("totalbill/{cid}")
	public List<Object> totalbill(@PathVariable("cid") Object customerid) {
		return bservice.totalbillService1(customerid);
	}
	
	@GetMapping("findTotalProduct1/{cid}")
	public List<Object> findTotalProduct1(@PathVariable("cid") Object customerid) {
		return bservice.findTotalProductService1(customerid);
	}
	
	@PostMapping("addOrderService")
	public int addOrderService(@RequestBody Orders order) {
	
		return bservice.addOrderService(order);
	}
	
	@GetMapping("deletefromcart/{cid}")
	public int deletefromcart(@PathVariable("cid") Object customerid) {
		bservice.deleteFromCartService(customerid);
		return 1;
	}
	
	@GetMapping("myorder/{cid}")
	public List<Orders> findTotalProduct1(@PathVariable("cid") String name) {
		return bservice.findMyOrderService(name);
	}
	
}

   
     








