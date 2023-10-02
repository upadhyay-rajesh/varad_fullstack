package com.facebookvaradweb.service;

import com.facebookvaradweb.dao.FacebookDAO;
import com.facebookvaradweb.dao.FacebookDAOInterface;
import com.facebookvaradweb.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fbuser) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.createProfileDAO(fbuser);
	}

}
