package com.facebookvarad2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FacebookDAO {
	
	public int createProfile(String name,String password,String email,String address)throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
		PreparedStatement ps=con.prepareStatement("insert into facebookvarad2 values(?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, password);
		ps.setString(3, email);
		ps.setString(4, address);
		int i=ps.executeUpdate(); //to execute insert,delete,update query we will use executeUpdate() method in jdbc and return type will be int
		return i;
	}

}
