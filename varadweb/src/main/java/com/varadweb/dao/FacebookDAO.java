package com.varadweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.varadweb.entity.FacebookEntity;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDAO(FacebookEntity fb) {
		int i=0;
		/*try {
			//load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");
			//create query
			PreparedStatement ps=con.prepareStatement("insert into facebooknewvarad values(?,?,?,?)");
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getPassword());
			ps.setString(3, fb.getEmail());
			ps.setString(4, fb.getAddress());
			
			i=ps.executeUpdate();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//configure method will load hibernate.cfg.xml file 
		//buildSessionFactory() method will take all information from hibernate.cfg.xml file and create database connection , table
		//SessionFactory class is singleton and thread safe
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		//to do every work we have to create separate Session object
		Session ss=sf.openSession();
		
		//EntityTransaction will save data permanently inside database otherwise data will be into RAM but will not saved inside database
		//begin() method will start transaction and commit() method will save data into database
		EntityTransaction et=ss.getTransaction();
		et.begin();
		//save method internally use insert query and will insert data into table
			ss.save(fb);
		
		
		et.commit();
		i=1;
		
		return i;
	}

}













