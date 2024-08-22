package com.revshop.dao;

import java.util.List;

import com.revshop.entity.Product;

public interface RetailerDAOInterface {
	int registerSeller();
	//• ReceiveAnEmailRegardingRegistrationStatus();
	 List<Product> manageInventoryAndProductDetailsDAO();
	int addProductsDAO(Product product);
	 List<Product> placedOrdersDAO();
	//• Receive email notifications when a user places an order.
	String discountsDAO();
	List<Product> graphicalDashboardDAO();
	String getNotificationWhenUserSubmitsAReviewDAO();
	List<Product> lowStockInventoryDAO();
}
