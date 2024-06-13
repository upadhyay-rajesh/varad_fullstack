package com.facebookspringboot.service;

import java.util.List;

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

	@Override
	public String deleteService(String userid) {
		fd.deleteById(userid);
		return "deleted";
	}

	@Override
	public FacebookUser loginService(String userid, String password) {
		
		return fd.loginDAO(userid,password);
	}

	@Override
	public List<FacebookUser> getAllUser() {
		// TODO Auto-generated method stub
		return fd.findAll();
	}

	@Override
	public FacebookUser loginuserService(FacebookUser fu) {
		// TODO Auto-generated method stub
		return fd.loginDAO(fu.getEmail(),fu.getPassword());
	}

}
