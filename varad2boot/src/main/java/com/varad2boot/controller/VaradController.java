package com.varad2boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.varad2boot.entity.FacebookVarad;
import com.varad2boot.service.VaradServiceInterface;

@RestController
public class VaradController {
	
	@Autowired
	private VaradServiceInterface vs;
	
	@PostMapping("registerUser")
	public FacebookVarad createProfile(@RequestBody FacebookVarad f1) {
		return vs.createProfileService(f1);
	}
	
	@GetMapping("viewall")
	public List<FacebookVarad> viewallprofile(){
		return vs.viewAllProfileService();
	}
	
	@GetMapping("viewProfile/{id}")
	public FacebookVarad viewProfile(@PathVariable("id") String email) {
		return vs.viewProfileService(email);
	}
	
	@DeleteMapping("deleteProfile/{id}")
	public String deleteProfile(@PathVariable("id") String email) {
		return vs.deleteProfileService(email);
	}
	@PutMapping("editUser/{id}")
	public FacebookVarad editProfile(@RequestBody FacebookVarad f1,@PathVariable("id") String email) {
		f1.setEmail(email);
		return vs.editProfileService(f1);
	}

}
