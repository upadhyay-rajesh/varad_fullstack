package com.springbootdemo.service;

import java.util.List;

import com.springbootdemo.entity.VaradFacebookEntity;

public interface FacebookServiceInterface {

	VaradFacebookEntity signUp(VaradFacebookEntity vd);

	List<VaradFacebookEntity> viewAllProfileService();

}
