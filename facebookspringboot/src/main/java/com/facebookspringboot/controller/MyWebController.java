package com.facebookspringboot.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyWebController {
	
	
	@RequestMapping(value="createProfile.htm" , produces = MediaType.APPLICATION_JSON)
	public ModelAndView createProfile(@RequestParam("name") String name) {
		
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("myvariable", "Hello Spring");
		mv.setViewName("result.jsp");
		
		return mv;
	}

}
