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

public class DeleteProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		String email=ss.getAttribute("id").toString();
		
		FacebookHibernateEntity fe=new  FacebookHibernateEntity();
		fe.setEmail(email);
		
		FacebookServiceInterface fs=new FacebookService();
		
		int i=fs.deleteProfileService(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(i>0) {
			out.println("<p>profile deleted</p>");
		}
			
			out.println("</form>");
		out.println("</body></html>");
	}

}
