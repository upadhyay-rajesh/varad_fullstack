package com.facebookspringboot.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.facebookspringboot.entity.FacebookUser;
import com.facebookspringboot.exception.UserNotFoundException;
import com.facebookspringboot.service.FacebookServiceInterface;

@RestController
public class FacebookController {
	
	Logger log=Logger.getLogger("FacebookController");
	
	@Autowired
	private FacebookServiceInterface fs;
	
	
	@GetMapping("all")
	public List<FacebookUser> allUser(){
		log.info("enters inside allUser method at "+LocalTime.now());
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
	public FacebookUser login(@PathVariable("userid") String userid,@PathVariable("password") String password)throws UserNotFoundException {
		FacebookUser fuser=fs.loginService(userid,password);
		if(fuser==null) {
			throw new UserNotFoundException("user with usename "+userid+"  not found");
		}
		else {
		return  fuser;
		}
		
	}
	
	@PostMapping("loginUser")
	public @ResponseBody FacebookUser loginUser(@RequestBody FacebookUser fu) throws UserNotFoundException{
		FacebookUser fuser=fs.loginuserService(fu);
		
		if(fuser==null) {
			throw new UserNotFoundException("user with usename "+fu.getEmail()+"  not found");
		}
		else {
		return  fuser;
		}
	}
	
	
	
	
}











