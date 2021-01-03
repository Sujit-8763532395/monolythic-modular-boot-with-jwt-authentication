package com.aashdit.wcd.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi/user") 
public class UserHomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserHomeController.class);
	
	@RequestMapping("/")
	public String home() { 		
		return "Welcome To User Service"; 
	} 
	
}
	