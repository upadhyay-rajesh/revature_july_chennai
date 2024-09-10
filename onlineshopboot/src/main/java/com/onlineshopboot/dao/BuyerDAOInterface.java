package com.onlineshopboot.dao;

import java.util.List;

import com.onlineshopboot.entity.Customer;
import com.onlineshopboot.entity.Orders;
import com.onlineshopboot.entity.ShopingCart;

public interface BuyerDAOInterface {

	int createProfileDao(Customer c);

	int findMaxOrderDAO();

	List<Object> findTotalProductDAO(Object attribute, int order_no);

	int addOrderDAO(Orders order);

	void deleteFromCartDAO(Object attribute);

	int addtoCartDAO(ShopingCart sCart);

	int updateProductDAO(String string, int productId, int quantity);

}
