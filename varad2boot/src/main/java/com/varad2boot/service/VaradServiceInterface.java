package com.varad2boot.service;

import java.util.List;

import com.varad2boot.entity.FacebookVarad;

public interface VaradServiceInterface {

	FacebookVarad createProfileService(FacebookVarad f1);

	List<FacebookVarad> viewAllProfileService();

	FacebookVarad viewProfileService(String email);

	String deleteProfileService(String email);

	FacebookVarad editProfileService(FacebookVarad f1);

}
