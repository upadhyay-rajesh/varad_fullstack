package com.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootdemo.dao.FacebookDAOInterface;
import com.springbootdemo.entity.VaradFacebookEntity;

@Service
@Transactional
public class FacebookService implements FacebookServiceInterface {
	@Autowired
	FacebookDAOInterface fd;
	
	@Override
	public VaradFacebookEntity signUp(VaradFacebookEntity vd) {
		return fd.save(vd);
	}

	@Override
	public List<VaradFacebookEntity> viewAllProfileService() {
		
		return fd.findAll();
	}

}
