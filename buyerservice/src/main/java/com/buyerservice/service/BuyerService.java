package com.buyerservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buyerservice.dao.OrderDAOInterface;
import com.buyerservice.dao.ProductDAOInterface;
import com.buyerservice.dao.RetailerDAOInterface;
import com.buyerservice.dao.ShopingCartDAOInterface;
import com.buyerservice.entity.Orders;
import com.buyerservice.entity.ShopingCart;

@Service
@Transactional
public class BuyerService implements BuyerServiceInterface {

	@Autowired
	private RetailerDAOInterface adminDAO;

	@Autowired
	private OrderDAOInterface orderDAO;

	@Autowired
	private ProductDAOInterface productDAO;

	@Autowired
	private ShopingCartDAOInterface shopingDAO;

	@Override
	public int findMaxOrderService() {
		List<Orders> ll = orderDAO.findAll();
		int i = 0;
		for (Orders oo : ll) {
			i = oo.getOrder_no();
		}
		return i;
	}

	@Override
	public List<Object> findTotalProductService(Object attribute, int order_no) {
		return shopingDAO.findTotalProductDAO(Integer.parseInt(attribute.toString()));
	}
	@Override
	public List<Object> findTotalProductService1(Object attribute) {
		return shopingDAO.findTotalProductDAO(Integer.parseInt(attribute.toString()));
	}

	@Override
	public int addOrderService(Orders order) {
		orderDAO.save(order);
		return 1;
	}

	@Override
	public void deleteFromCartService(Object attribute) {

		//shopingDAO.deleteFromCartDAO(Integer.parseInt(attribute.toString()));
		shopingDAO.deleteAll();

	}

	@Override
	public int addtoCartService(ShopingCart sCart) {
		shopingDAO.save(sCart);
		return 1;
	}

	@Override
	public int updateProductService(String string, int productId, int quantity) {

		int i = 0;
		String discount_price = null;
		double productPrice = 0;

		List<ShopingCart> ll = shopingDAO.updateCartDAO(Integer.parseInt(string), productId);

		for (ShopingCart ss2 : ll) {

			discount_price = ss2.getDiscount_price();
			// Converting into double from string
			productPrice = Double.parseDouble(discount_price);
		}
		productPrice = productPrice * quantity;

		ShopingCart s1 = new ShopingCart();
		s1.setQuantity(quantity);
		s1.setCustomer_id(Integer.parseInt(string));
		s1.setProduct_id(productId);
		s1.setTotal_price("" + productPrice);

		shopingDAO.saveAndFlush(s1);
		i = 1;
		return i;

	}

	@Override
	public List<Object> totalbillService1(Object customerid) {
		List<ShopingCart> ss= shopingDAO.findAll();
		double totalprice=0.0;
		double mrpprice=0.0;
		for(ShopingCart s1:ss) {
			if(s1.getCustomer_id()==Integer.parseInt(customerid.toString())) {
				totalprice=totalprice+Double.parseDouble(s1.getTotal_price());
				mrpprice=mrpprice+Double.parseDouble(s1.getMrp_price());
			}
		}
		List<Object> ll=new ArrayList<Object>();
		ll.add(totalprice);
		ll.add(mrpprice);
		return ll;
	}

	@Override
	public int findmaxpaymentidService() {
		List<Orders> ll = orderDAO.findAll();
		int i = 0;
		for (Orders oo : ll) {
			i = oo.getPayment_id();
		}
		return i;
	}

	@Override
	public List<Orders> findMyOrderService(String name) {
		List<Orders> ll = orderDAO.findAll();
		List<Orders> ll1=new ArrayList<Orders>();
		for (Orders oo : ll) {
			if(oo.getCustomer_name().equals(name)) {
				ll1.add(oo);
			}
		}
		return ll1;
	}

}
