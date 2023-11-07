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

public class ViewProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		String email=ss.getAttribute("id").toString();
		
		FacebookHibernateEntity fh=new FacebookHibernateEntity();
		
		fh.setEmail(email);
		
		
		FacebookServiceInterface fs=new FacebookService();
		FacebookHibernateEntity i=fs.viewProfileService(fh);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i!=null) {
								
				out.println("****************  " );
				out.println("<br>Name is "+i.getName());
				out.println("<br>Password is "+i.getPassword());
				out.println("<br>Email is "+i.getEmail());
				out.println("<br>Address is "+i.getAddress());
			}
			else {
				out.println("Invalid Id  ");
			}
			out.println("</body></html>");
	}

}