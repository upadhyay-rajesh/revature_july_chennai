package com.amazonclientapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;



import org.springframework.stereotype.Controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.amazonclientapp.dto.Customer;
import com.amazonclientapp.dto.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RetailerController {

	@Autowired
	private DiscoveryClient discoveryClient;

	private final String UPLOAD_DIRECTORY = "C:\\Users\\RajeshUpadhyay\\Downloads\\amazonclientapp\\amazonclientapp\\src\\main\\webapp\\uploads";

	@RequestMapping("AddProducts")
	public ModelAndView addCustomer(HttpServletRequest request) {
		// Path where all the images are stored

		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				// Taking all image requests
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				String imageName = null;
				String productName = null;
				String productQuantity = null;
				String productPrice = null;
				String descrip = null;
				String mrpPrice = null;
				String status = null;
				String category = null;

				// SALTCHARS to generate unique code for product
				String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
				StringBuilder salt = new StringBuilder();
				Random rnd = new Random();
				while (salt.length() < 3) { // length of the random string.
					int index = (int) (rnd.nextFloat() * SALTCHARS.length());
					salt.append(SALTCHARS.charAt(index));
				}
				String code = salt.toString();

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						// Getting image name
						imageName = new File(item.getName()).getName();
						// Storing in the specified directory
						item.write(new File(UPLOAD_DIRECTORY + File.separator + imageName));

						// Retriving all information from frontend
						FileItem pName = (FileItem) multiparts.get(0);
						productName = pName.getString();

						FileItem price = (FileItem) multiparts.get(1);
						productPrice = price.getString();

						FileItem description = (FileItem) multiparts.get(2);
						descrip = description.getString();

						FileItem mprice = (FileItem) multiparts.get(3);
						mrpPrice = mprice.getString();

						FileItem fstatus = (FileItem) multiparts.get(4);
						status = fstatus.getString();

						FileItem pcategory = (FileItem) multiparts.get(5);
						category = pcategory.getString();

					}
				}

				try {
					int id = 0;
					String imagePath = UPLOAD_DIRECTORY + imageName;
					Product product = new Product();
					product.setActive(code);
					product.setCode(code);
					product.setDescription(descrip);
					product.setId(id);
					product.setImage(imagePath);
					product.setImage_name(imageName);
					product.setMrp_price(mrpPrice);
					product.setName(productName);
					product.setPrice(productPrice);
					product.setProduct_category(category);

					System.out.println(code + " " + descrip + " " + id + " " + imagePath + " " + imageName + " ");

					// int i=rservice.addProductService(product);
					List<ServiceInstance> instances = discoveryClient.getInstances("RETAILERSERVICE");
					ServiceInstance serviceInstance = instances.get(0);

					String baseUrl = serviceInstance.getUri().toString(); // return http://localhost:8080

					baseUrl = baseUrl + "/users";

					RestTemplate restTemplate = new RestTemplate();
					int i = restTemplate.postForObject(baseUrl, product, Integer.class);

					// If product inserted sucessfully in the database
					if (i > 0) {
						String success = "Product added successfully.";
						// Adding method in session.
						session.setAttribute("message", success);
						// Response send to the admin-add-product.jsp
						mv.setViewName("admin-add-product.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception ex) {
				// If any occur occured
				request.setAttribute("message", "File Upload Failed due to " + ex);
			}
		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}

		return mv;
	}

	@RequestMapping("CustomerLogin")
	public ModelAndView loginCustomer(HttpServletRequest request, @RequestParam("password") String pass,
			@RequestParam("email") String email) {
		
		ModelAndView mv = new ModelAndView();

		Customer cc = new Customer();
		cc.setEmail(email);
		cc.setPassword(pass);

		List<ServiceInstance> instances = discoveryClient.getInstances("RETAILERSERVICE");
		ServiceInstance serviceInstance = instances.get(0);

		String baseUrl = serviceInstance.getUri().toString(); // return http://localhost:8080

		baseUrl = baseUrl + "/customerLogin";

		RestTemplate restTemplate = new RestTemplate();
		Customer i = restTemplate.postForObject(baseUrl, cc, Customer.class);

		// Creating Session
		HttpSession hs = request.getSession();

		if (email != null && pass != null) {
			if (i != null) {
				List<ServiceInstance> instances5 = discoveryClient.getInstances("ADMINSERVICE");
				ServiceInstance serviceInstance5 = instances5.get(0);
				String baseUrl1 = serviceInstance5.getUri().toString(); // return http://localhost:8080

				baseUrl1 = baseUrl1 + "/viewproducts";
				List<Product> allproduct = restTemplate.getForObject(baseUrl1, List.class,1L);
				
				// Storing the login details in session
				hs.setAttribute("id", i.getId());
				hs.setAttribute("name", i.getName());
				// Redirecting response to the index.jsp
				
				List<ServiceInstance> instances1 = discoveryClient.getInstances("RETAILERSERVICE");
				ServiceInstance serviceInstance1 = instances.get(0);
				String baseUrl2 = serviceInstance1.getUri().toString(); // return http://localhost:8080
				baseUrl2 = baseUrl2 + "/totalcountofcartitem/"+i.getId();

				RestTemplate restTemplate2 = new RestTemplate();
				int i1 = restTemplate2.getForObject(baseUrl2, Integer.class, 1L);
				mv.addObject("totalcartitem", i1);
				
				mv.addObject("allproduct", allproduct);
				mv.setViewName("index1.jsp");
			} else {
				// If wrong credentials are entered
				String message = "You have enter wrong credentials";
				hs.setAttribute("credential", message);
				// Redirecting response to the customer-login.jsp
				mv.setViewName("customer-login.jsp");
			}
		} else {
			// If username or password is empty or null
			String message = "User name or Password is null";
			hs.setAttribute("credential", message);
			// Redirecting response to the customer-login.jsp
			mv.setViewName("customer-login.jsp");
		}

		return mv;
	}

	@RequestMapping("totalcountofcartitem")
	public ModelAndView countofcartitem(HttpServletRequest request) {
		
	//	HttpSession session=request.getSession(true);
	//	int i=(int)session.getAttribute("id");
		
		ModelAndView mv = new ModelAndView();
/*
		List<ServiceInstance> instances = discoveryClient.getInstances("RETAILERSERVICE");
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString(); // return http://localhost:8080
		baseUrl = baseUrl + "/totalcountofcartitem/"+i;

		RestTemplate restTemplate = new RestTemplate();
		int i1 = restTemplate.getForObject(baseUrl, Integer.class, 1L);
		mv.addObject("totalcartitem", i1);
*/
		mv.setViewName("customer-login.jsp");

		return mv;
	}
	
	@RequestMapping("totalcountofcartitem1")
	public ModelAndView countofcartitem1(HttpServletRequest request) {
		
		/*HttpSession session=request.getSession(true);
		int i=(int)session.getAttribute("id");
		
		

		List<ServiceInstance> instances = discoveryClient.getInstances("RETAILERSERVICE");
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString(); // return http://localhost:8080
		baseUrl = baseUrl + "/totalcountofcartitem/"+i;

		RestTemplate restTemplate = new RestTemplate();
		int i1 = restTemplate.getForObject(baseUrl, Integer.class, 1L);
		mv.addObject("totalcartitem1", i1);
		*/
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer-register.jsp");

		return mv;
	}
	
	@RequestMapping("index123")
	public ModelAndView indexPage(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		//int i=(int)session.getAttribute("id");
		
		ModelAndView mv = new ModelAndView();
/*
		List<ServiceInstance> instances = discoveryClient.getInstances("RETAILERSERVICE");
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString(); // return http://localhost:8080
		baseUrl = baseUrl + "/totalcountofcartitem/"+i;

		RestTemplate restTemplate = new RestTemplate();
		int i1 = restTemplate.getForObject(baseUrl, Integer.class, 1L);
		mv.addObject("totalcartitem1", i1);
		*/
		List<ServiceInstance> instances1=discoveryClient.getInstances("ADMINSERVICE");
		ServiceInstance serviceInstance1=instances1.get(0);
		
		String baseUrl1=serviceInstance1.getUri().toString(); //return http://localhost:8080
		
		baseUrl1=baseUrl1+"/viewproducts";
		
		RestTemplate restTemplate1=new RestTemplate();

			List user = restTemplate1.getForObject(baseUrl1, List.class, 1L);
		
		
		System.out.println("hello "+user);
		
		mv.addObject("productresult", user);
		
		mv.setViewName("index.jsp");
		
		return mv;
	}
	
	@RequestMapping("allproducts")
	public ModelAndView allProducts(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();

		List<ServiceInstance> instances1=discoveryClient.getInstances("ADMINSERVICE");
		ServiceInstance serviceInstance1=instances1.get(0);
		
		String baseUrl1=serviceInstance1.getUri().toString(); //return http://localhost:8080
		
		baseUrl1=baseUrl1+"/viewproducts";
		
		RestTemplate restTemplate1=new RestTemplate();

			List user = restTemplate1.getForObject(baseUrl1, List.class, 1L);
		
		
		System.out.println("hello "+user);
		
		mv.addObject("productresult", user);
		
		mv.setViewName("products.jsp");
		
		return mv;
	}

}
