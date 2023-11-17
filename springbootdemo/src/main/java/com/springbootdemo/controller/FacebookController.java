package com.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springbootdemo.entity.VaradFacebookEntity;
import com.springbootdemo.service.FacebookService;
import com.springbootdemo.service.FacebookServiceInterface;

@RestController
public class FacebookController {
	
	@Autowired
	FacebookServiceInterface fs;
	
	//notes : line 20 and 21 together equal to line no 30
	
	//insert query
	@PostMapping("register")
	public VaradFacebookEntity createProfile(@RequestBody VaradFacebookEntity vd) {
		
		
		//FacebookServiceInterface fs=new FacebookService();
		return fs.signUp(vd);
	}
	
	//select query
	@GetMapping("viewall")
	public List<VaradFacebookEntity> viewProfile() {
		return fs.viewAllProfileService();
	}
	
	//delete query
	@DeleteMapping("delete/{abcid}")
	public String deleteProfile(@PathVariable("abcid") String mid) {
		return "profile deleted "+mid;
	}
	
	//update query
	@PutMapping("edit")
	public String editProfile() {
		return "profile edited";
	}

}
