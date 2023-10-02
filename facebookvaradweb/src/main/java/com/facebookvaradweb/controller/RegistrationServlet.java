package com.facebookvaradweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookvaradweb.entity.FacebookUser;
import com.facebookvaradweb.service.FacebookService;
import com.facebookvaradweb.service.FacebookServiceInterface;

public class RegistrationServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		FacebookUser fbuser=new FacebookUser();
		fbuser.setName(name);
		fbuser.setPassword(password);
		fbuser.setEmail(email);
		fbuser.setAddress(address);
		
		FacebookServiceInterface fs=new FacebookService();
		
		int i=fs.createProfileService(fbuser);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
				out.println("Registration successful");
			}
			//out.println("Name is "+name);
			//out.println("<br> Password is "+password);
		//	out.println("<br>Email is "+email);
		//	out.println("<br>Address is "+address);
		out.println("</body></html>");
	}

}
