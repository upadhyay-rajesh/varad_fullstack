package com.facebookvarad2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.facebookvarad2.entity.FacebookUser;

public class FacebookDAO {
	
	public int createProfile(FacebookUser f)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		PreparedStatement ps=con.prepareStatement("insert into facebookvarad2 values(?,?,?,?)");
		ps.setString(1, f.getName());
		ps.setString(2, f.getPassword());
		ps.setString(3, f.getEmail());
		ps.setString(4, f.getAddress());
		int i=ps.executeUpdate(); //to execute insert,delete,update query we will use executeUpdate() method in jdbc and return type will be int
		return i;
	}
	
	public FacebookUser viewProfileDAO(FacebookUser f) throws Exception{
		FacebookUser f1=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		PreparedStatement ps=con.prepareStatement("select * from facebookvarad2 where email=?");
		ps.setString(1, f.getEmail());
		
		ResultSet res= ps.executeQuery();  //to execute select query we will use executeQuery() method in jdbc and return type will be ResultSet
		if(res.next()) {
			f1=new FacebookUser();
			f1.setName(res.getString(1));
			f1.setPassword(res.getString(2));
			f1.setEmail(res.getString(3));
			f1.setAddress(res.getString(4));
		}
		return f1;
	}

}
