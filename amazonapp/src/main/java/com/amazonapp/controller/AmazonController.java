package com.amazonapp.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AmazonController {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("displayall12")
	public ModelAndView displayAllProduct() {

		

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String str = restTemplate.exchange("http://localhost:8080/displayAll", HttpMethod.GET, entity, String.class)
				.getBody();

		System.out.println(str);

		ModelAndView mv = new ModelAndView();
		return mv;
	}
	/*
	 * @GetMapping(value = "/template/products") public String getProductList() {
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<String> entity = new HttpEntity<String>(headers);
	 * 
	 * return restTemplate.exchange( "http://localhost:8080/products",
	 * HttpMethod.GET, entity, String.class).getBody(); }
	 * 
	 * @PostMapping(value = "/template/products") public String
	 * createProducts(@RequestBody Product product) { HttpHeaders headers = new
	 * HttpHeaders(); headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	 * 
	 * return restTemplate.exchange( "http://localhost:8080/products",
	 * HttpMethod.POST, entity, String.class).getBody(); }
	 * 
	 * @PutMapping(value = "/template/products/{id}") public String
	 * updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	 * 
	 * return restTemplate.exchange( "http://localhost:8080/products/"+id,
	 * HttpMethod.PUT, entity, String.class).getBody(); }
	 * 
	 * @DeleteMapping(value = "/template/products/{id}") public String
	 * deleteProduct(@PathVariable("id") String id) { HttpHeaders headers = new
	 * HttpHeaders(); headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<Product> entity = new HttpEntity<Product>(headers);
	 * 
	 * return restTemplate.exchange( "http://localhost:8080/products/"+id,
	 * HttpMethod.DELETE, entity, String.class).getBody(); }
	 */
}
