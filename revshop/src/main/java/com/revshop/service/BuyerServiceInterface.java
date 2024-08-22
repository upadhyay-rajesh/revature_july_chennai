package com.revshop.service;

import java.util.List;

import com.revshop.entity.Bill;
import com.revshop.entity.Order;
import com.revshop.entity.OrderDetails;
import com.revshop.entity.Product;
import com.revshop.entity.RateReview;

public interface BuyerServiceInterface {
	Product viewProductDetails();
	List<Product> browseProductsByCategory();
	String addProductsToCart();
	String removeProductsToCart();
	Bill checkout();
	String getEmailNotifications();
	List<Order> viewOrderHistory();
	RateReview rateAndReviewProducts();
	String complaintAgainstTheSeller();
	String returnADefectiveProduct();
	String saveProductAsFavorite();
	OrderDetails generateInvoice();
	String makeaymentUsingThePaymentGateway();

}













