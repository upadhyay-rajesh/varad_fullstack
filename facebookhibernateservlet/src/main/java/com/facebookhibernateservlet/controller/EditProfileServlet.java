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

public class EditProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		String email=ss.getAttribute("id").toString();
		
		FacebookHibernateEntity fe=new  FacebookHibernateEntity();
		fe.setEmail(email);
		
		FacebookServiceInterface fs=new FacebookService();
		
		FacebookHibernateEntity fuser=fs.viewProfileService(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			out.println("<p>Edit Page</p>");
			out.println("<form action=EditServlet1 method=post>");
			out.println("<br>Name <input type=text name=nm value="+fuser.getName()+">");
			out.println("<br>Password <input type=text name=pwd value="+fuser.getPassword()+">");
			out.println("<br>Email<input type=email name=em value="+fuser.getEmail()+" disabled>");
			out.println("<br>Address<input type=text name=ad value="+fuser.getAddress()+">");
			out.println("<input type=submit value=Edit>");
			out.println("</form>");
		out.println("</body></html>");
				
	}

}













