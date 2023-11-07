package com.facebookhibernateservlet.service;

import java.util.List;

import com.facebookhibernateservlet.dao.FacebookDAO;
import com.facebookhibernateservlet.dao.FacebookDAOInterface;
import com.facebookhibernateservlet.entity.FacebookHibernateEntity;

public class FacebookService implements FacebookServiceInterface {

	public int signUp(FacebookHibernateEntity fh) {
		FacebookDAOInterface fd=new FacebookDAO();
		int i=fd.signUpDAO(fh);
		return i;
	}

	public int signIn(FacebookHibernateEntity fh) {
		FacebookDAOInterface fd=new FacebookDAO();
		int i=fd.signInDAO(fh);
		return i;
	}

	public FacebookHibernateEntity viewProfileService(FacebookHibernateEntity fh) {
		FacebookDAOInterface fd=new FacebookDAO();
		FacebookHibernateEntity i=fd.viewProfileDAO(fh);
		return i;
	}

	public List<FacebookHibernateEntity> viewAllProfileService() {
		FacebookDAOInterface fd=new FacebookDAO();
		List<FacebookHibernateEntity> i=fd.viewAllProfileDAO();
		return i;
	}

	public int editProfileService(FacebookHibernateEntity fh) {
		FacebookDAOInterface fd=new FacebookDAO();
		int i=fd.editProfileDAO(fh);
		return i;
	}

	public int deleteProfileService(FacebookHibernateEntity fe) {
		FacebookDAOInterface fd=new FacebookDAO();
		int i=fd.deleteProfileDAO(fe);
		return i;
	}

	public List<FacebookHibernateEntity> searchProfileService(FacebookHibernateEntity fe) {
		FacebookDAOInterface fd=new FacebookDAO();
		List<FacebookHibernateEntity> i=fd.searchProfileDAO(fe);
		return i;
	}

}
