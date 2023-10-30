package com.varadweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.varadweb.entity.FacebookEntity;
import com.varadweb.service.FacebookService;
import com.varadweb.service.FacebookServiceInterface;


public class RegisterServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("n");
		String password=request.getParameter("p");
		String email=request.getParameter("e");
		String address=request.getParameter("a");
		
		FacebookEntity fb=new FacebookEntity();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		FacebookServiceInterface fs=new FacebookService();
		int i=fs.createProfile(fb);
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");
		
		if(i>0) {
			out.println("Registration success");
		}
		out.println("</body></html>");
		
	}

}
