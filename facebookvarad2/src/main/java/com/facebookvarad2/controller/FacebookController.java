package com.facebookvarad2.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.facebookvarad2.dao.FacebookDAO;
import com.facebookvarad2.entity.FacebookUser;

public class FacebookController {

	public void createProfile()throws Exception {
		Scanner sc=new Scanner(System.in); //Scanner class is used to take input from console
		
		System.out.println("Please enter your name");
		String name=sc.next();    //reading string from console using next() method
		
		System.out.println("enter password");
		String password=sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter address");
		String address=sc.next();
		
		FacebookUser fuser=new FacebookUser();
		fuser.setName(name);
		fuser.setPassword(password);
		fuser.setEmail(email);
		fuser.setAddress(address);
		
		FacebookDAO fd=new FacebookDAO();
		
		int i=fd.createProfile(fuser);
		
		if(i>0) {
			System.out.println("Hello "+name+" Your password is "+password+" email is "+email+" and address is "+address);
			System.out.println("profile created");
			}
			else {
				System.out.println("could not create profile");
			}
		
	}
//
	public void viewProfile()throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter email to view profile");
		
		String email=sc.next();
		FacebookUser fuser=new FacebookUser();
		fuser.setEmail(email);
		
		FacebookDAO fd=new FacebookDAO();
		FacebookUser f=fd.viewProfileDAO(fuser);
		
		
		
		if(f!=null) {
			System.out.println("record found and it is below");
			System.out.println("Name is "+f.getName());     //here 1 indicate first column number
			System.out.println("Password is "+f.getPassword());
			System.out.println("Email is "+f.getEmail());
			System.out.println("Address is "+f.getAddress());
		}
		else {
			System.out.println("email not found in database");
		}
		
	}

	public void editProfile() {
		// TODO Auto-generated method stub
		
	}

	public void viewAllProfile() {
		// TODO Auto-generated method stub
		
	}

	public void deleteProfile() {
		// TODO Auto-generated method stub
		
	}

	public void searchProfile() {
		// TODO Auto-generated method stub
		
	}

}
