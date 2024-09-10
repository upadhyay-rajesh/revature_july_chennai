package com.onlineshopboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopboot.dao.AdminDAOInterface;
import com.onlineshopboot.dao.BuyerDAOInterface;
import com.onlineshopboot.entity.Customer;
import com.onlineshopboot.entity.Orders;
import com.onlineshopboot.entity.ShopingCart;

@Service

public class BuyerService implements BuyerServiceInterface{
	
	@Autowired
	private BuyerDAOInterface bdao;

	@Override
	public int createProfile(Customer c) {
		// TODO Auto-generated method stub
		return bdao.createProfileDao(c);
	}

	@Override
	public int findMaxOrderService() {
		return bdao.findMaxOrderDAO();
	}

	@Override
	public List<Object> findTotalProductService(Object attribute, int order_no) {
		return bdao.findTotalProductDAO(attribute,order_no);
	}

	@Override
	public int addOrderService(Orders order) {
		return bdao.addOrderDAO(order);
	}

	@Override
	public void deleteFromCartService(Object attribute) {
		bdao.deleteFromCartDAO(attribute);
		
	}

	@Override
	public int addtoCartService(ShopingCart sCart) {
		return bdao.addtoCartDAO(sCart);
	}

	@Override
	public int updateProductService(String string, int productId, int quantity) {
		return bdao.updateProductDAO(string,productId,quantity);
	}

}
