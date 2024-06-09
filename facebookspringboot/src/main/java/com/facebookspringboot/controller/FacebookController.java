package com.facebookspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.facebookspringboot.entity.FacebookUser;
import com.facebookspringboot.service.FacebookServiceInterface;

@RestController
public class FacebookController {
	
	@Autowired
	private FacebookServiceInterface fs;

	@PostMapping("createProfile")
	public FacebookUser createProfile(@RequestBody FacebookUser f1) {
		
		return fs.createProfileService(f1);  
	}
}
