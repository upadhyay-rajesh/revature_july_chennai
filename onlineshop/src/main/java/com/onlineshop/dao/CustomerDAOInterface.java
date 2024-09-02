package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.entity.Customer;
import com.onlineshop.entity.Orders;
import com.onlineshop.entity.Product;
import com.onlineshop.entity.ShopingCart;

public interface CustomerDAOInterface {

	int addCustomerDAO(Customer customer);

	int addProductDAO(Product product);

	int addtoCartDAO(ShopingCart sCart);

	int addOrderDAO(Orders order);

	void deleteFromCartDAO(Object attribute);

	int findMaxOrderDAO();

	List<Orders> findTotalProductDAO(Object attribute, int order_no);

	int updateOrderStatusDAO(String orderId);

	int updateProductDAO(String attribute, int productId,int quantity);

	String adminLoginDAO(String email, String pass);

	Customer customerLoginDAO(String email, String pass);

}
