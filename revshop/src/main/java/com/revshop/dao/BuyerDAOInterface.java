package com.revshop.dao;

import java.util.List;

import com.revshop.entity.Bill;
import com.revshop.entity.Order;
import com.revshop.entity.OrderDetails;
import com.revshop.entity.Product;
import com.revshop.entity.RateReview;

public interface BuyerDAOInterface {
	Product viewProductDetailsDAO();
	List<Product> browseProductsByCategoryDAO();
	String addProductsToCartDAO();
	String removeProductsToCartDAO();
	Bill checkoutDAO();
	String getEmailNotificationsDAO();
	List<Order> viewOrderHistoryDAO();
	RateReview rateAndReviewProductsDAO();
	String complaintAgainstTheSellerDAO();
	String returnADefectiveProductDAO();
	String saveProductAsFavoriteDAO();
	OrderDetails generateInvoiceDAO();
	String makeaymentUsingThePaymentGatewayDAO();
}
