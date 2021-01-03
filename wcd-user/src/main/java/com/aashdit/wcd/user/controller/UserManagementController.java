package com.aashdit.wcd.user.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aashdit.wcd.user.dto.PasswordDto;
import com.aashdit.wcd.user.dto.UserDto;
import com.aashdit.wcd.user.model.Role;
import com.aashdit.wcd.user.model.User;
import com.aashdit.wcd.user.service.UserService;

@RestController
@RequestMapping("/restapi/user") 
public class UserManagementController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * @author Sujit Mishra
	 * @return roleList
	 * @throws JSONException
	 * @date 2020-07-09
	 * @purpose To get all the roles which is required for signup time. 
	 */
	@GetMapping(value = "/getRoleList", produces = MediaType.APPLICATION_JSON_VALUE) 
	public List<Role> getRoleList() throws JSONException {		
		return userService.findAllRole(); 		
	}
	
	/**
	 * @author Sujit Mishra
	 * @param userDto
	 * @throws Exception
	 * @date 2020-07-10
	 * @purpose To manage signup process. 
	 */
	@PostMapping(value = "/signUpUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> signUpUser(@RequestBody UserDto userDto) throws Exception {		
		JSONObject jsonObject = userService.signUpUser(userDto); 		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 
	} 
	
	/**
	 * @author Sujit Mishra
	 * @return userList
	 * @throws Exception
	 * @date 2020-07-10
	 * @purpose To get all the users in admin login for manage user details purpose. 
	 */
	@GetMapping(value = "/userList", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> userList() throws Exception {		
		return userService.userList(); 
	} 
	
	/**
	 * @author Sujit Mishra
	 * @param userId
	 * @throws Exception
	 * @date 2020-07-10
	 * @purpose To view particular user's details by admin or by user itself for edit profile purpose. 
	 */
	@GetMapping(value = "/viewProfile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> viewProfile(@RequestParam("userId")Long userId) throws Exception {		
		JSONObject jsonObject = userService.viewProfile(userId); 		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 
	} 
	
	/**
	 * @author Sujit Mishra
	 * @param userDto
	 * @param token
	 * @throws Exception
	 * @date 2020-07-10
	 * @purpose To manage edit profile/update profile process. 
	 */
	@PostMapping(value = "/updateProfile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateProfile(@RequestBody UserDto userDto, @RequestHeader(value="Authorization") String token) throws Exception {		
		JSONObject jsonObject = userService.updateProfile(userDto, token); 		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 
	} 
	
	/**
	 * @author Sujit Mishra
	 * @param passwordDto
	 * @param token
	 * @throws Exception
	 * @date 2020-07-10
	 * @purpose To manage change password process by user itself. 
	 */
	@PostMapping(value = "/changePassword", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> changePassword(@RequestBody PasswordDto passwordDto, @RequestHeader(value="Authorization") String token) throws Exception {		
		JSONObject jsonObject = userService.changePassword(passwordDto, token); 		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 
	} 
	
	/**
	 * @author Sujit Mishra
	 * @param userName
	 * @throws Exception
	 * @date 2020-07-10
	 * @purpose To send password reset request by the user in forgot password case. 
	 */
	@PostMapping(value = "/requestForResetPassword", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> requestForResetPassword(@RequestParam("userName")String userName) throws Exception {		
		JSONObject jsonObject = userService.requestForResetPassword(userName); 		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 
	} 
	
	/**
	 * @author Sujit Mishra
	 * @param userName
	 * @param otp
	 * @throws Exception
	 * @date 2020-07-10
	 * @purpose To submit OTP for reset password purpose.  
	 */
	@PostMapping(value = "/submitOtpForResetPassword", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> submitOtpForResetPassword(
			@RequestParam("userName")String userName, @RequestParam("otp")String otp) throws Exception {		
		JSONObject jsonObject = userService.submitOtpForResetPassword(userName, otp); 		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 
	} 
	
	/**
	 * @author Sujit Mishra
	 * @param userName
	 * @param newPassword
	 * @param confirmNewPassword
	 * @throws Exception
	 * @date 2020-07-10
	 * @purpose To manage reset password process by user after correct OTP submission. 
	 */
	@PostMapping(value = "/resetPassword", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> resetPassword(@RequestParam("userName")String userName, 
			@RequestParam("newPassword")String newPassword, @RequestParam("confirmNewPassword")String confirmNewPassword) throws Exception {		
		JSONObject jsonObject = userService.resetPassword(userName, newPassword, confirmNewPassword); 		
		return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK); 
	} 
	
}
	