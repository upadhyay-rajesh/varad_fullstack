package com.facebookvarad2.dao;

import java.util.ArrayList;

import com.facebookvarad2.entity.FacebookUser;

public interface FacebookDAOInterface {
	public int createProfile(FacebookUser f)throws Exception;
	public FacebookUser viewProfileDAO(FacebookUser f) throws Exception;
	public ArrayList<FacebookUser> viewAllProfileDAO()throws Exception;
	
	public int deleteProfileDAO(FacebookUser fu)throws Exception;

	public void searchProfileDAO(FacebookUser fu)throws Exception;
}
