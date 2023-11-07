package com.facebookhibernateservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookhibernateservlet.entity.FacebookHibernateEntity;
import com.facebookhibernateservlet.service.FacebookService;
import com.facebookhibernateservlet.service.FacebookServiceInterface;

public class SearchServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vv=request.getParameter("hh");
		
		List<FacebookHibernateEntity> i=null;
		
		if(vv.equals("name")) {
			String name=request.getParameter("nm");
			
			FacebookHibernateEntity fe=new  FacebookHibernateEntity();
			fe.setName(name);
			
			FacebookServiceInterface fs=new FacebookService();
			
			 i=fs.searchProfileService(fe);
		}
		if(vv.equals("Address")) {
			String address=request.getParameter("ad");
			FacebookHibernateEntity fe=new  FacebookHibernateEntity();
			fe.setAddress(address);
			
			FacebookServiceInterface fs=new FacebookService();
			
			 i=fs.searchProfileService(fe);
		}
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










