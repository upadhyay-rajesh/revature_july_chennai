package com.onlineshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.onlineshop.entity.Customer;
import com.onlineshop.entity.Orders;
import com.onlineshop.entity.Product;
import com.onlineshop.entity.ShopingCart;
import com.onlineshop.utility.DatabaseConnection;

public class CustomerDAO implements CustomerDAOInterface {

	@Override
	public int addCustomerDAO(Customer customer) {
		 int addCustomer=0;
		/* try {
	            //Connecting database connection and querying in the database
			 Connection con=DatabaseConnection.getConnection();
			 PreparedStatement ps=con.prepareStatement("insert into tblcustomer(address,email,gender,name,password,phone,pin_code)values(?,?,?,?,?,?,?)");
			 ps.setString(1, customer.getAddress());
			 ps.setString(2,customer.getEmail() );
			 ps.setString(3, customer.getGender());
			 ps.setString(4, customer.getName());
			 ps.setString(5, customer.getPassword());
			 ps.setString(6, customer.getMobile());
			 ps.setString(7,customer.getPincode() );
			 addCustomer  = ps.executeUpdate();

	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }*/
		 
		 Session ss=DatabaseConnection.getConnectionwithhibernate();
		 
		 EntityTransaction et=ss.getTransaction();
		 
		 et.begin();
		 	ss.save(customer);
		 et.commit();
		 
		 addCustomer=1;
		 return addCustomer;
	}

	@Override
	public int addProductDAO(Product product) {
		int addCustomer=0;
		/* try {
	            //Connecting database connection and querying in the database
			 System.out.println("hello");
			 Connection con=DatabaseConnection.getConnection();
			 PreparedStatement ps=con.prepareStatement("insert into tblproduct(id,active,code,description,image,image_name,name,price,mrp_price,product_category) values(?,?,?,?,?,?,?,?,?,?)");
			 ps.setInt(1,product.getId() );
			 ps.setString(2, product.getActive());
			 ps.setString(3, product.getCode());
			 ps.setString(4,product.getDescription() );
			 ps.setString(5, product.getImage());
			 ps.setString(6,product.getImage_name() );
			 ps.setString(7, product.getName());
			 ps.setString(8, product.getPrice());
			 ps.setString(9,product.getMrp_price() );
			 ps.setString(10, product.getProduct_category());
			 addCustomer  = ps.executeUpdate();

	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }*/
		 
		
		 Session ss=DatabaseConnection.getConnectionwithhibernate();
		 
		 EntityTransaction et=ss.getTransaction();
		 
		 et.begin();
		 ss.save(product);
		 et.commit();
		 
		 addCustomer=1;
		 return addCustomer;
	}

	@Override
	public int addtoCartDAO(ShopingCart sCart) {
		int addCustomer=0;
		/* try {
	            //Connecting database connection and querying in the database
			 Connection con=DatabaseConnection.getConnection();
			 PreparedStatement ps=con.prepareStatement("insert into tblcart values(?,?,?,?,?,?,?)");
			 ps.setInt(1,sCart.getId() );
			 ps.setString(2, sCart.getDiscount_price());
			 ps.setInt(3, sCart.getQuantity());
			 ps.setString(4,sCart.getTotal_price() );
			 ps.setInt(5, sCart.getCustomer_id());
			 ps.setInt(6,sCart.getProduct_id() );
			 ps.setString(7, sCart.getMrp_price());
			 
			 addCustomer  = ps.executeUpdate();

	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		 */
		 Session ss=DatabaseConnection.getConnectionwithhibernate();
		 
		 EntityTransaction et=ss.getTransaction();
		 
		 et.begin();
		 ss.save(sCart);
		 et.commit();
		 
		 addCustomer=1;
		 return addCustomer;
	}

	@Override
	public int addOrderDAO(Orders order) {
		int addCustomer=0;
		/* try {
	            //Connecting database connection and querying in the database
			 Connection con=DatabaseConnection.getConnection();
			 PreparedStatement ps=con.prepareStatement("insert into tblorders(order_no,customer_name,mobile_number,email_id,address,address_type,pincode,image,product_name,quantity,product_price,product_selling_price,product_total_price,order_status,payment_mode,payment_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			 ps.setInt(1,order.getOrder_no());
			 ps.setString(2, order.getCustomer_name());
			 ps.setString(3, order.getMobile_number());
			 ps.setString(4,order.getEmail_id() );
			 ps.setString(5, order.getAddress());
			 ps.setString(6, order.getAddress_type());
			 ps.setString(7,order.getPincode());
			 ps.setString(8, order.getImage());
			 ps.setString(9, order.getProduct_name());
			 ps.setInt(10,order.getQuantity());
			 ps.setString(11, order.getProduct_price());
			 ps.setString(12, order.getProduct_selling_price());
			 ps.setString(13,order.getProduct_total_price());
			 ps.setString(14, order.getOrder_status());
			 ps.setString(15,order.getPayment_mode());
			 ps.setInt(16, order.getPayment_id());
			
			 
			 addCustomer  = ps.executeUpdate();

	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }*/
		 
Session ss=DatabaseConnection.getConnectionwithhibernate();
		 
		 EntityTransaction et=ss.getTransaction();
		 
		 et.begin();
		 ss.save(order);
		 et.commit();
		 
		 addCustomer=1;
		 return addCustomer;
	}

	@Override
	public void deleteFromCartDAO(Object attribute) {
		
		/* try {
	            //Connecting database connection and querying in the database
			 Connection con=DatabaseConnection.getConnection();
			 PreparedStatement ps=con.prepareStatement("delete from tblcart where customer_id=?");
			 ps.setObject(1,attribute );
		
			 
			  ps.executeUpdate();

	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		*/
		Session ss=DatabaseConnection.getConnectionwithhibernate();
		 
		 EntityTransaction et=ss.getTransaction();
		 
		 et.begin();
		 
		Query q=ss.createQuery("delete from com.onlineshop.entity.ShopingCart s where s.customer_id=:cid");
		q.setParameter("cid", attribute);
		
		q.executeUpdate();
		
		 et.commit();
		
	}

	@Override
	public int findMaxOrderDAO() {
		int r=0;
		try {
            //Connecting database connection and querying in the database
		 Connection con=DatabaseConnection.getConnection();
		 PreparedStatement ps=con.prepareStatement("select max(order_no) from tblorders");
		
		 ResultSet res= ps.executeQuery();

		 if(res.next()) {
			 r=res.getInt(1);
		 }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		Session ss=DatabaseConnection.getConnectionwithhibernate();
		 
		Query q=ss.createQuery("select max(s.order_no) from com.onlineshop.entity.Orders s");
		q.getResultList();
		
		return r;
	}

	@Override
	public List<Orders> findTotalProductDAO(Object attribute, int order_no) {
		
		/*try {
            //Connecting database connection and querying in the database
		 Connection con=DatabaseConnection.getConnection();
		 PreparedStatement ps=con.prepareStatement("select tblproduct.image_name,tblproduct.name,tblcart.quantity,tblcart.mrp_price,tblcart.discount_price,tblcart.total_price,tblcart.product_id from tblproduct,tblcart where tblproduct.id=tblcart.product_id and customer_id=?");
		 ps.setObject(1,attribute );
	
		 ResultSet totalProduct= ps.executeQuery();

		 while(totalProduct.next()) {
			 order_no++;
             String image_name = totalProduct.getString(1);
             String product_name = totalProduct.getString(2);
             int  quantity = totalProduct.getInt(3);
             String product_price = totalProduct.getString(4);
             String product_selling_price = totalProduct.getString(5);
             String product_total_price = totalProduct.getString(6);
             String order_status = "Pending";
             
             Orders oo=new Orders();
             oo.setImage(image_name);
             oo.setProduct_name(product_name);
             oo.setQuantity(quantity);
             oo.setProduct_price(product_price);
             oo.setProduct_selling_price(product_selling_price);
             oo.setProduct_total_price(product_total_price);
             oo.setOrder_status(order_status);
             ll.add(oo);
		 }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		*/
		Session ss=DatabaseConnection.getConnectionwithhibernate();
		 
		Query q=ss.createQuery("select tblproduct.image_name,tblproduct.name,tblcart.quantity,tblcart.mrp_price,tblcart.discount_price,tblcart.total_price,tblcart.product_id from tblproduct,tblcart where tblproduct.id=tblcart.product_id and customer_id=?");
		List<Orders> ll=q.getResultList();
		return ll;
	}

	@Override
	public int updateOrderStatusDAO(String orderId) {
		int i=0;
		 try {
	            //Connecting database connection and querying in the database
			 Connection con=DatabaseConnection.getConnection();
			 PreparedStatement ps=con.prepareStatement("select order_status from tblorders where order_no=?");
			 ps.setString(1, orderId);
			 ResultSet rs=ps.executeQuery();
	            while (rs.next()) {
	                if (rs.getString(1).equals("Deliver")) {
	                	PreparedStatement ps1=con.prepareStatement("update tblorders set order_status='Pending' where order_no=?");
	       			 	ps1.setString(1, orderId);
	       			 	i=ps1.executeUpdate();
	                    } else {
	                	PreparedStatement ps2=con.prepareStatement("update tblorders set order_status='Deliver' where order_no=?");
	       			 	ps2.setString(1, orderId);
	       			 	i=ps2.executeUpdate();
	                    }
	            }

	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		
		return i;
	}

	@Override
	public int updateProductDAO(String attribute, int productId,int quantity) {
		int i=0;
		String discount_price=null;
		double productPrice=0;
		 try {
	            //Connecting database connection and querying in the database
			 Connection con=DatabaseConnection.getConnection();
			 PreparedStatement ps=con.prepareStatement("select discount_price from tblcart where customer_id=? and product_id=?");
			 ps.setString(1, attribute);
			 ps.setInt(2, productId);
			 ResultSet rs=ps.executeQuery();
			 while (rs.next()) {
	                //Gettinh data
	                discount_price = rs.getString("discount_price");
	                //Converting into double from string
	                productPrice = Double.parseDouble(discount_price);
	            }
	            productPrice = productPrice * quantity;
	            
	           
	                	PreparedStatement ps1=con.prepareStatement("update tblcart set quantity=?,total_price=? where customer_id=? and product_id=?");
	       			 	ps1.setInt(1, quantity);
	       			 	ps1.setDouble(2, productPrice);
	       			 	ps1.setString(3, attribute);
	       			 	ps1.setInt(4, productId);
	       			 	
	       			 	i=ps1.executeUpdate();
	                   
	            

	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		
		return i;
	}

	@Override
	public String adminLoginDAO(String email, String pass) {
		String r=null;
		try {
            //Connecting database connection and querying in the database
		 Connection con=DatabaseConnection.getConnection();
		 PreparedStatement ps=con.prepareStatement("select * from tbladmin where email=? AND password=?");
		ps.setString(1, email);
		ps.setString(2, pass);
		 ResultSet res= ps.executeQuery();

		 if(res.next()) {
			 r=res.getString("name");
		 }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return r;
	}

	@Override
	public Customer customerLoginDAO(String email, String pass) {
		Customer r=null;
		try {
            //Connecting database connection and querying in the database
		 Connection con=DatabaseConnection.getConnection();
		 PreparedStatement ps=con.prepareStatement("select * from tblcustomer where email=? AND password=?");
		ps.setString(1, email);
		ps.setString(2, pass);
		 ResultSet res= ps.executeQuery();

		 if(res.next()) {
			 r=new Customer();
			r.setId(res.getInt("id"));
            r.setName(res.getString("name"));
			
		 }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return r;
	}

}
