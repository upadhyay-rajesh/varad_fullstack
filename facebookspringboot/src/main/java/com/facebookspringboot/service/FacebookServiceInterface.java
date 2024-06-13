package com.facebookspringboot.service;

import java.util.List;

import com.facebookspringboot.entity.FacebookUser;

public interface FacebookServiceInterface {

	FacebookUser createProfileService(FacebookUser f1);

	String deleteService(String userid);

	FacebookUser loginService(String userid, String password);

	List<FacebookUser> getAllUser();

	FacebookUser loginuserService(FacebookUser fu);

}
