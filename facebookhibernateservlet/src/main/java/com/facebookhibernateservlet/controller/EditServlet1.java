package com.facebookhibernateservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookhibernateservlet.entity.FacebookHibernateEntity;
import com.facebookhibernateservlet.service.FacebookService;
import com.facebookhibernateservlet.service.FacebookServiceInterface;

public class EditServlet1 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("nm");
		String password=request.getParameter("pwd");
		HttpSession ss=request.getSession(true);
		String email=ss.getAttribute("id").toString();
		String address=request.getParameter("ad");
		
		FacebookHibernateEntity fh=new FacebookHibernateEntity();
		fh.setName(name);
		fh.setPassword(password);
		fh.setEmail(email);
		fh.setAddress(address);
		
		FacebookServiceInterface fs=new FacebookService();
		int i=fs.editProfileService(fh);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
				out.println("Profile Edited <a href=signin.html>Sign In Here</a>");
			}
			out.println("</body></html>");
	}

}
