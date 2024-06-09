package com.facebookspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facebookspringboot.dao.FacebookDAOInterface;
import com.facebookspringboot.entity.FacebookUser;

@Service
@Transactional
public class FacebookService implements FacebookServiceInterface{
	
	@Autowired
	private FacebookDAOInterface fd;

	@Override
	public FacebookUser createProfileService(FacebookUser f1) {
		fd.save(f1);
		return f1;
	}

}
