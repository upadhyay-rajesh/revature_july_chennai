package com.revshop.service;

import java.util.List;

import com.revshop.entity.Product;

public interface RetailerServiceInterface {
	int registerSeller();
	//• ReceiveAnEmailRegardingRegistrationStatus();
	 List<Product> manageInventoryAndProductDetails();
	int addProducts(Product product);
	 List<Product> placedOrders();
	//• Receive email notifications when a user places an order.
	String discounts();
	List<Product> graphicalDashboard();
	String getNotificationWhenUserSubmitsAReview();
	List<Product> lowStockInventory();
}
