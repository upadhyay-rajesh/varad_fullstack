package com.facebookhibernateservlet.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.facebookhibernateservlet.entity.FacebookHibernateEntity;

public class FacebookDAO implements FacebookDAOInterface {

	public int signUpDAO(FacebookHibernateEntity fh) {
		int i=0;
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		EntityTransaction et=ss.getTransaction();
		et.begin();
			ss.save(fh);
		et.commit();
		i=1;
		return i;
	}

	public int signInDAO(FacebookHibernateEntity fh) {
		int i=0;
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.facebookhibernateservlet.entity.FacebookHibernateEntity f where f.email=:e and f.password=:p");
		q.setParameter("e", fh.getEmail());
		q.setParameter("p", fh.getPassword());
		
		FacebookHibernateEntity dd=(FacebookHibernateEntity)q.getSingleResult();
		if(dd!=null) {
		i=1;
		}
		return i;
	}

	public FacebookHibernateEntity viewProfileDAO(FacebookHibernateEntity fh) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		FacebookHibernateEntity dd1=ss.load(FacebookHibernateEntity.class, fh.getEmail());
		
		//Query q=ss.createQuery("from com.facebookhibernateservlet.entity.FacebookHibernateEntity f where f.email=:e ");
	//	q.setParameter("e", fh.getEmail());
				
		//FacebookHibernateEntity dd=(FacebookHibernateEntity)q.getSingleResult();
		return dd1;
	}

	public List<FacebookHibernateEntity> viewAllProfileDAO() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.facebookhibernateservlet.entity.FacebookHibernateEntity f");
			
		return q.getResultList();
	}

	public int editProfileDAO(FacebookHibernateEntity fh) {
		int i=0;
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("update com.facebookhibernateservlet.entity.FacebookHibernateEntity f set f.name=:nm, f.password=:pwd, f.address=:address where f.email=:e ");
		q.setParameter("nm", fh.getName());
		q.setParameter("pwd", fh.getPassword());
		q.setParameter("address", fh.getAddress());
		q.setParameter("e", fh.getEmail());
				
		EntityTransaction et=ss.getTransaction();
		et.begin();
		i=q.executeUpdate();
		et.commit();
		
		return i;
	}

	public int deleteProfileDAO(FacebookHibernateEntity fe) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("delete from com.facebookhibernateservlet.entity.FacebookHibernateEntity f where f.email=:e");
		q.setParameter("e", fe.getEmail());
		EntityTransaction et=ss.getTransaction();
		et.begin();
		int i=q.executeUpdate();
		et.commit();
		return i;
	}

	public List<FacebookHibernateEntity> searchProfileDAO(FacebookHibernateEntity fe) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Query q=null;
		if(fe.getName()!=null) {
				 q=ss.createQuery("from com.facebookhibernateservlet.entity.FacebookHibernateEntity f where f.name=:nm");
				q.setParameter("nm", fe.getName());
		}
		if(fe.getAddress()!=null) {
			 q=ss.createQuery("from com.facebookhibernateservlet.entity.FacebookHibernateEntity f where f.address=:ad");
			q.setParameter("ad", fe.getAddress());
	}
			
		return q.getResultList();
	}

}
