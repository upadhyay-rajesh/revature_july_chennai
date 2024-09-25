package com.buyerservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.buyerservice.entity.ShopingCart;



@Repository
public interface ShopingCartDAOInterface extends JpaRepository<ShopingCart, Integer>{
	@Query(nativeQuery = true,
            value = "select tp.image_name,tp.name,tc.quantity,tc.mrp_price,tc.discount_price,tc.total_price,tc.product_id from tblproduct tp,tblCart tc where tp.id=tc.product_id and tc.customer_id=:cid")
    public List<Object> findTotalProductDAO(@Param("cid") int cid);
	
	@Query(nativeQuery = true,
            value = "delete from tblcart s where s.customer_id=:cid")
    public void deleteFromCartDAO(@Param("cid") int cid);
	
	@Query(nativeQuery = true,
            value = "from tblcart s where s.customer_id=:cid and s.product_id=:pid")
    public List<ShopingCart> updateCartDAO(@Param("cid") int cid,@Param("pid") int pid);
	
	
}
