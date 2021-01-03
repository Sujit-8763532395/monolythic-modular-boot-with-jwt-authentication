package com.aashdit.wcd.web.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aashdit.wcd.user.dto.AuthRequest;
import com.aashdit.wcd.user.model.User;
import com.aashdit.wcd.user.service.UserService;
import com.aashdit.wcd.web.security.JwtUtil;

@RestController
@RequestMapping("/restapi/web") 
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@Autowired
    private UserService userService;
	
	/**
	 * @author Sujit Mishra
	 * @param authRequest
	 * @return token
	 * @throws Exception
	 * @date 2020-07-08
	 * @purpose To manage login functionality by user.  
	 */
	@PostMapping("/userLogin")
    public String userLogin(@RequestBody AuthRequest authRequest) throws Exception {
        
		String response = null; 
		try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
            User user = userService.findUserByUserName(authRequest.getUserName()); 
            if(user != null) {
            	if(user.getIsEnabled()) {
	            	if(user.getIsAccountNonLocked()) {
	            		if(user.getIsConfirm()) {
	            			response = jwtUtil.generateToken(authRequest.getUserName()); 
	            			userService.userLogin(user); 
	            		}
	            		else {
	            			response = "You have already loggedin."; 
	            		}
	            	}
	            	else {
	            		response = "Account has been locked, please try after sometimes."; 
	            	}
            	}
            	else {
            		response = "Sorry, this account has been deactivated."; 
            	}
            }
            else {
            	response = "No user found."; 
            }
        } catch (Exception ex) {
            throw new Exception("Invalid username or password.");
        }
		
		return response;
    }
	
	/**
	 * @author Sujit Mishra
	 * @param token
	 * @throws Exception
	 * @date 2020-07-08
	 * @purpose To get the particular user related informations to display those in login screen. 
	 */
	@GetMapping(value = "/getLoggedinUserDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getLoggedinUserDetails(@RequestHeader(value="Authorization") String token) throws Exception {
		JSONObject jsonObject = userService.getLoggedinUserDetails(token); 
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK);  
	}
	
	/**
	 * @author Sujit Mishra
	 * @param token
	 * @throws Exception
	 * @date 2020-07-08
	 * @purpose To manage logout functionality by user.  
	 */
	@PostMapping(value = "/userLogout", produces = MediaType.APPLICATION_JSON_VALUE)
	public String userLogout(@RequestHeader(value="Authorization") String token) throws Exception {
		
		String response = null;
		User user = userService.userLogout(token); 
		if(user != null) {
			response = "User loggedout successfully.";
		}
		else {
			response = "Unable to logout."; 
		}
		
		return response; 
	}
	
}
	