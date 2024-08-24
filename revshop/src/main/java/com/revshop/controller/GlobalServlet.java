package com.revshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revshop.entity.Buyer;
import com.revshop.service.GlobalServiceInterface;
import com.revshop.utility.RevShopServiceFactory;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taskType = request.getParameter("taskType");

		if (taskType.equals("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("pass");

			Buyer user = new Buyer();
			user.setEmail(email);
			user.setPassword(password);

			GlobalServiceInterface gService = RevShopServiceFactory.createObject("global");
			Buyer b = gService.signinService(user);
			if(b!=null) {
				
				HttpSession session=request.getSession(true);
				session.setAttribute("email", email);
						
				
			if (b.getUserType().equals("admin")) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/adminHomepage.jsp");
				rd.forward(request, response);
			}
			if (b.getUserType().equals("retailer")) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/retailerHomepage.jsp");
				rd.forward(request, response);
			}
			if (b.getUserType().equals("buyer")) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/buyerHomepage.jsp");
				rd.forward(request, response);
			}
			}
			else {
				
			}
		}
		if (taskType.equals("validateEmail")) {
			
			String str="Valid Email";
			
			String email=request.getParameter("email");
			Buyer b=new Buyer();
			b.setEmail(email);
			
			GlobalServiceInterface gService = RevShopServiceFactory.createObject("global");
			boolean b1 = gService.validateEmailService(b);
			
			if(b1) {
				str="Email Already Register with This website";
			}
			request.setAttribute("result", str);
			System.out.println(str);
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/emailresult.jsp");
			rd.forward(request, response);
		}
	}

}














