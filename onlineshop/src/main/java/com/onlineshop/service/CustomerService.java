package com.onlineshop.service;

import java.util.List;

import com.onlineshop.dao.CustomerDAOInterface;
import com.onlineshop.entity.Customer;
import com.onlineshop.entity.Orders;
import com.onlineshop.entity.Product;
import com.onlineshop.entity.ShopingCart;
import com.onlineshop.utility.DaoFactory;

public class CustomerService implements CustomerServiceInterface {

	@Override
	public int addCustomerService(Customer customer) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.addCustomerDAO(customer);
	}

	@Override
	public int addProductService(Product product) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.addProductDAO(product);
	}

	@Override
	public int addtoCartService(ShopingCart sCart) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.addtoCartDAO(sCart);
	}

	@Override
	public int addOrderService(Orders order) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.addOrderDAO(order);
	}

	@Override
	public void deleteFromCartService(Object attribute) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		cDao.deleteFromCartDAO(attribute);
		
	}

	@Override
	public int findMaxOrderService() {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.findMaxOrderDAO();
	}

	@Override
	public List<Orders> findTotalProductService(Object attribute, int order_no) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.findTotalProductDAO(attribute,order_no);
	}

	@Override
	public int updateOrderStatusService(String orderId) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.updateOrderStatusDAO(orderId);
	}

	@Override
	public int updateProductService(String attribute, int productId,int quantity) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.updateProductDAO(attribute,productId,quantity);
	}

	@Override
	public String adminLoginService(String email, String pass) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.adminLoginDAO(email,pass);
	}

	@Override
	public Customer customerLoginService(String email, String pass) {
		CustomerDAOInterface cDao=DaoFactory.getObject("customer");
		return cDao.customerLoginDAO(email,pass);
	}

}
