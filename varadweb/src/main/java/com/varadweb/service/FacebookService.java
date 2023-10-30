package com.varadweb.service;

import com.varadweb.dao.FacebookDAO;
import com.varadweb.dao.FacebookDAOInterface;
import com.varadweb.entity.FacebookEntity;

public class FacebookService implements FacebookServiceInterface {

	public int createProfile(FacebookEntity fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.createProfileDAO(fb);
	}

}
