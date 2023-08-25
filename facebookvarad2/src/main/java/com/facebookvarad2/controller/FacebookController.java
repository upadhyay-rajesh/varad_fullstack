package com.facebookvarad2.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.facebookvarad2.dao.FacebookDAO;

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
		
		FacebookDAO fd=new FacebookDAO();
		
		int i=fd.createProfile(name, password, email, address);
		
		if(i>0) {
			System.out.println("Hello "+name+" Your password is "+password+" email is "+email+" and address is "+address);
			System.out.println("profile created");
			}
			else {
				System.out.println("could not create profile");
			}
		
	}

	public void viewProfile()throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter email to view profile");
		
		String email=sc.next();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		PreparedStatement ps=con.prepareStatement("select * from facebookvarad2 where email=?");
		ps.setString(1, email);
		
		ResultSet res= ps.executeQuery();  //to execute select query we will use executeQuery() method in jdbc and return type will be ResultSet
		if(res.next()) {
			System.out.println("record found and it is below");
			System.out.println("Name is "+res.getString(1));     //here 1 indicate first column number
			System.out.println("Password is "+res.getString(2));
			System.out.println("Email is "+res.getString(3));
			System.out.println("Address is "+res.getString(4));
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
