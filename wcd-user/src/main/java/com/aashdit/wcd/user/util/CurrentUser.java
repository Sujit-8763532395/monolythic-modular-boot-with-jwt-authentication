package com.aashdit.wcd.user.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aashdit.wcd.user.model.User;
import com.aashdit.wcd.user.repository.UserRepository;

@Component
public class CurrentUser {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getCurrentUser(String token) {
		String currentUserName = TokenParser.getUserName(token); 
		return userRepository.findByUserName(currentUserName);  
	}
	
}
	