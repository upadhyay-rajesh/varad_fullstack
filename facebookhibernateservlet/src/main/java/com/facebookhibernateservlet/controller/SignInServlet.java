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


public class SignInServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password=request.getParameter("pwd");
		String email=request.getParameter("em");
		
		
		FacebookHibernateEntity fh=new FacebookHibernateEntity();
		
		fh.setPassword(password);
		fh.setEmail(email);
		
		
		FacebookServiceInterface fs=new FacebookService();
		int i=fs.signIn(fh);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
				
				HttpSession ss=request.getSession(true);
				ss.setAttribute("id", email);
				
				out.println("Welcome Mr/Mrs "+email );
				out.println("<br><a href=ViewProfileServlet>View Profile</a>");
				out.println("<br><a href=DeleteProfileServlet>Delete Profile</a>");
				out.println("<br><a href=ViewAllProfileServlet>View All Profile</a>");
				out.println("<br><a href=EditProfileServlet>Edit Profile</a>");
				out.println("<br><a href=SearchProfile.html>Search Profile</a>");
			}
			else {
				out.println("Invalid Id and password <a href=signin.html>Login Again</a>");
			}
			out.println("</body></html>");
	}

}
