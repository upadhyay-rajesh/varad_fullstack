package com.facebookspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.facebookspringboot.entity.FacebookUser;
import com.facebookspringboot.service.FacebookServiceInterface;

@RestController
public class FacebookController {
	
	@Autowired
	private FacebookServiceInterface fs;
	
	
	@GetMapping("all")
	public List<FacebookUser> allUser(){
		return fs.getAllUser();
	}

	@PostMapping("createProfile")
	public FacebookUser createProfile(@RequestBody FacebookUser f1) {
		
		return fs.createProfileService(f1);  
	}
	
	@DeleteMapping("deleteUser/{userid}")
	public String deleteUser(@PathVariable("userid") String userid) {
		return fs.deleteService(userid);
	}
	
	@GetMapping("login/{userid}/{password}")
	public FacebookUser login(@PathVariable("userid") String userid,@PathVariable("password") String password) {
		return fs.loginService(userid,password);
	}
	
	@PostMapping("loginUser")
	public FacebookUser loginUser(@RequestBody FacebookUser fu) {
		return fs.loginuserService(fu);
	}
	
}
