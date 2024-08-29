package com.onlineshop.entity;

public class ShopingCart {
	private String discount_price;
	private String total_price;
	private String mrp_price;
	private int id;
	private int customer_id;
	private int product_id;
	private int quantity;
	public String getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(String discount_price) {
		this.discount_price = discount_price;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	public String getMrp_price() {
		return mrp_price;
	}
	public void setMrp_price(String mrp_price) {
		this.mrp_price = mrp_price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}
