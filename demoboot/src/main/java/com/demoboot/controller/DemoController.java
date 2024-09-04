package com.demoboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demoboot.entity.Customer;
import com.demoboot.service.DemoServiceInterface;

@Controller
public class DemoController {
	
	@Autowired
	private DemoServiceInterface dservice;
	
	@RequestMapping("register")
	public ModelAndView createProfile(@RequestParam("name") String name,@RequestParam("pass") String password,@RequestParam("em") String email,@RequestParam("ad") String address) {
		
		Customer c=new Customer();
		c.setAddress(address);
		c.setEmail(email);
		c.setPassword(password);
		c.setName(name);
		
		int i=dservice.createProfile(c);
		
		String result="Registration Fail";
		
		if(i>0) {
			result="Registration Success";
		}
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("registrationresult", result);
		mv.setViewName("registerresult.jsp");
		return mv;
	}
	
	@RequestMapping("login")
	public ModelAndView loginProfile(HttpServletRequest request, @RequestParam("pass") String password,@RequestParam("em") String email) {
		
		Customer c=new Customer();
		
		c.setEmail(email);
		c.setPassword(password);
			
		int i=dservice.loginProfile(c);
		
		String result="Login Fail";
		
		if(i>0) {
			HttpSession hs=request.getSession(true);
			hs.setAttribute("empid", email);
			result="Welcome "+email;
		}
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("registrationresult", result);
		mv.setViewName("loginresult.jsp");
		return mv;
	}
	
	@RequestMapping("displayAll")
	public ModelAndView displayAll() {
		
		List<Customer> ll= dservice.viewAllProfile();
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("empList", ll);
		mv.setViewName("displayall.jsp");
		return mv;
	}
	@RequestMapping("deleteProfile")
	public ModelAndView deleteAll() {
		ModelAndView mv=new ModelAndView();
		return mv;
	}
	@RequestMapping("editProfile")
	public ModelAndView editAll() {
		ModelAndView mv=new ModelAndView();
		return mv;
	}
	@RequestMapping("viewProfile")
	public ModelAndView viewAll() {
		ModelAndView mv=new ModelAndView();
		return mv;
	}

}








