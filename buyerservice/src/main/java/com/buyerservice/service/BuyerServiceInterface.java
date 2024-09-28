package com.buyerservice.service;

import java.util.List;

import com.buyerservice.entity.Customer;
import com.buyerservice.entity.Orders;
import com.buyerservice.entity.ShopingCart;



public interface BuyerServiceInterface {

	int findMaxOrderService();

	List<Object> findTotalProductService(Object attribute, int order_no);

	int addOrderService(Orders order);

	void deleteFromCartService(Object attribute);

	int addtoCartService(ShopingCart sCart);

	int updateProductService(String string, int productId, int quantity);

	List<Object> findTotalProductService1(Object customerid);

	List<Object> totalbillService1(Object customerid);

	int findmaxpaymentidService();

	List<Orders> findMyOrderService(String name);

	void removeFromCartService(Object productid);

}
