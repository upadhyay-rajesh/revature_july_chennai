package com.onlineshopboot.service;

import java.util.List;

import com.onlineshopboot.entity.Customer;
import com.onlineshopboot.entity.Orders;
import com.onlineshopboot.entity.ShopingCart;

public interface BuyerServiceInterface {

	int createProfile(Customer c);

	int findMaxOrderService();

	List<Object> findTotalProductService(Object attribute, int order_no);

	int addOrderService(Orders order);

	void deleteFromCartService(Object attribute);

	int addtoCartService(ShopingCart sCart);

	int updateProductService(String string, int productId, int quantity);

}
