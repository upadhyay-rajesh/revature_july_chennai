package com.amazonapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	//@Autowired
	//RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("displayall12")
	public ModelAndView displayAllProduct() {
		
		List<ServiceInstance> instances=discoveryClient.getInstances("BUYERSERVICE");
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl=serviceInstance.getUri().toString(); //return http://localhost:8080
		
		baseUrl=baseUrl+"/displayAll";
		
		

		RestTemplate restTemplate=new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String str = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class)
				.getBody();

		System.out.println(str);
		
		String str1=restTemplate.getForObject(
				baseUrl,
	            String.class);
		System.out.println(str1);

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
