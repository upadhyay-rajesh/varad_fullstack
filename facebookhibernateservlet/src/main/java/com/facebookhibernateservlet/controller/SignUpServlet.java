package com.facebookhibernateservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookhibernateservlet.entity.FacebookHibernateEntity;
import com.facebookhibernateservlet.service.FacebookService;
import com.facebookhibernateservlet.service.FacebookServiceInterface;

public class SignUpServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("nm");
		String password=request.getParameter("pwd");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		FacebookHibernateEntity fh=new FacebookHibernateEntity();
		fh.setName(name);
		fh.setPassword(password);
		fh.setEmail(email);
		fh.setAddress(address);
		
		FacebookServiceInterface fs=new FacebookService();
		int i=fs.signUp(fh);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
				out.println("Registration Success <a href=signin.html>Sign In Here</a>");
			}
			out.println("</body></html>");
		
	}

}











