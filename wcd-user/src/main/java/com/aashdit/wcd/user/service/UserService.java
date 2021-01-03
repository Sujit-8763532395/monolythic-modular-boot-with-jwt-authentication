package com.aashdit.wcd.user.service;

import java.util.List;

import org.json.JSONObject;

import com.aashdit.wcd.user.dto.PasswordDto;
import com.aashdit.wcd.user.dto.UserDto;
import com.aashdit.wcd.user.model.Role;
import com.aashdit.wcd.user.model.User;
import com.aashdit.wcd.user.model.UserRole;

public interface UserService {

	User findUserByUserName(String username);

	UserRole getPrimaryRoleByUserId(Long userId);

	JSONObject getLoggedinUserDetails(String token);

	void userLogin(User user);

	User userLogout(String token);

	List<Role> findAllRole();

	JSONObject signUpUser(UserDto userDto);

	List<User> userList();

	JSONObject viewProfile(Long userId);

	JSONObject updateProfile(UserDto userDto, String token);

	JSONObject changePassword(PasswordDto passwordDto, String token);

	JSONObject requestForResetPassword(String userName);

	JSONObject submitOtpForResetPassword(String userName, String otp);

	JSONObject resetPassword(String userName, String newPassword, String confirmNewPassword);            
	
}
	