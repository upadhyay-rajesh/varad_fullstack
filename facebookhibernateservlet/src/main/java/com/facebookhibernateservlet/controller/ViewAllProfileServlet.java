package com.facebookhibernateservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookhibernateservlet.entity.FacebookHibernateEntity;
import com.facebookhibernateservlet.service.FacebookService;
import com.facebookhibernateservlet.service.FacebookServiceInterface;


public class ViewAllProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacebookServiceInterface fs=new FacebookService();
		List<FacebookHibernateEntity> i=fs.viewAllProfileService();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i.size()>0) {
				out.println(i.size() +" Record Found and they are below<br>");
				for(FacebookHibernateEntity i1:i) {
					out.println("****************  <br>" );
					out.println("<br>Name is "+i1.getName());
					out.println("<br>Password is "+i1.getPassword());
					out.println("<br>Email is "+i1.getEmail());
					out.println("<br>Address is "+i1.getAddress());
				}
			}
			else {
				out.println("Invalid Id and password <a href=signin.html>Login Again</a>");
			}
			out.println("</body></html>");
	}

}
