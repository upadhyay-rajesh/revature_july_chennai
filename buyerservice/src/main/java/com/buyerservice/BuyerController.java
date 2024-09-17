package com.buyerservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buyerservice.entity.Product;

@RestController
public class BuyerController {
	
	private static Map<String, Product> productRepo = new HashMap<String, Product>();
	   static {
	      Product honey = new Product();
	      honey.setP_id("1");
	      honey.setP_name("Honey");
	      productRepo.put(honey.getP_id(), honey);
	      
	      Product almond = new Product();
	      almond.setP_id("2");
	      almond.setP_name("Almond");
	      productRepo.put(almond.getP_id(), almond);
	   }
	
	@GetMapping("displayAll")
	public List<Product> getAllProduct(){
		List<Product> ll=new ArrayList<Product>();
		
		Product p1=new Product();
		p1.setP_id("1");
		p1.setP_name("Book");
		p1.setP_specification("java");
		
		Product p2=new Product();
		p2.setP_id("2");
		p2.setP_name("Pen");
		p2.setP_specification("writing ");
		
		ll.add(p1);
		ll.add(p2);
		
		return ll;
	}
	
	@DeleteMapping(value = "/products/{id}")
	   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
	      productRepo.remove(id);
	      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	   }
	   
	   @PutMapping(value = "/products/{id}")
	   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
	      productRepo.remove(id);
	      product.setP_id(id);
	      productRepo.put(id, product);
	      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	   }
	   
	   @PostMapping(value = "/products")
	   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
	      productRepo.put(product.getP_id(), product);
	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   }
	   
	   @GetMapping(value = "/products")
	   public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	   }

}
