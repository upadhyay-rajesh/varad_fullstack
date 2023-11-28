package com.varad2boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varad2boot.dao.VaradDAOInterface;
import com.varad2boot.entity.FacebookVarad;

@Service
@Transactional
public class VaradService implements VaradServiceInterface{
	
	@Autowired
	private VaradDAOInterface vd;

	@Override
	public FacebookVarad createProfileService(FacebookVarad f1) {
		return vd.save(f1);
	}

	@Override
	public List<FacebookVarad> viewAllProfileService() {
		return vd.findAll();
	}

	@Override
	public FacebookVarad viewProfileService(String email) {
	Optional<FacebookVarad> rr=	vd.findById(email);
		return rr.get();
	}

	@Override
	public String deleteProfileService(String email) {
		vd.deleteById(email);
		return "profile deleted";
	}

	@Override
	public FacebookVarad editProfileService(FacebookVarad f1) {
		return vd.saveAndFlush(f1);
	}
	

}
