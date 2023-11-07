package com.facebookhibernateservlet.dao;

import java.util.List;

import com.facebookhibernateservlet.entity.FacebookHibernateEntity;

public interface FacebookDAOInterface {

	int signUpDAO(FacebookHibernateEntity fh);

	int signInDAO(FacebookHibernateEntity fh);

	FacebookHibernateEntity viewProfileDAO(FacebookHibernateEntity fh);

	List<FacebookHibernateEntity> viewAllProfileDAO();

	int editProfileDAO(FacebookHibernateEntity fh);

	int deleteProfileDAO(FacebookHibernateEntity fe);

	List<FacebookHibernateEntity> searchProfileDAO(FacebookHibernateEntity fe);

}
