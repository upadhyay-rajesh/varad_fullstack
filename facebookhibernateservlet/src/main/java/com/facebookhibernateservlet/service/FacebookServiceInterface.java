package com.facebookhibernateservlet.service;

import java.util.List;

import com.facebookhibernateservlet.entity.FacebookHibernateEntity;

public interface FacebookServiceInterface {

	int signUp(FacebookHibernateEntity fh);

	int signIn(FacebookHibernateEntity fh);

	FacebookHibernateEntity viewProfileService(FacebookHibernateEntity fh);

	List<FacebookHibernateEntity> viewAllProfileService();

	int editProfileService(FacebookHibernateEntity fh);

	int deleteProfileService(FacebookHibernateEntity fe);

	List<FacebookHibernateEntity> searchProfileService(FacebookHibernateEntity fe);

}
