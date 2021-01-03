package com.aashdit.wcd.user.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.common.repository.BlockRepository;
import com.aashdit.wcd.common.repository.DistrictRepository;
import com.aashdit.wcd.common.repository.SubdivisionRepository;
import com.aashdit.wcd.common.util.EmailMobileNumberValidation;
import com.aashdit.wcd.common.util.SendSmsUtil;
import com.aashdit.wcd.user.dto.PasswordDto;
import com.aashdit.wcd.user.dto.UserDto;
import com.aashdit.wcd.user.model.Role;
import com.aashdit.wcd.user.model.User;
import com.aashdit.wcd.user.model.UserLocation;
import com.aashdit.wcd.user.model.UserRole;
import com.aashdit.wcd.user.repository.RoleRepository;
import com.aashdit.wcd.user.repository.UserLocationRepository;
import com.aashdit.wcd.user.repository.UserRepository;
import com.aashdit.wcd.user.repository.UserRoleRepository;
import com.aashdit.wcd.user.util.AvailableUserValidationHelper;
import com.aashdit.wcd.user.util.RandomNumberGenerator;
import com.aashdit.wcd.user.util.TokenParser;
import com.aashdit.wcd.user.util.UserModuleApplicationConstants;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private UserRoleRepository userRoleRepository; 
	
	@Autowired
	private RoleRepository roleRepository; 
	
	@Autowired
	private AvailableUserValidationHelper availableUserValidationHelper;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserLocationRepository userLocationRepository; 
	
	@Autowired
	private DistrictRepository districtRepository; 
	
	@Autowired
	private SubdivisionRepository subdivisionRepository; 
	
	@Autowired
	private BlockRepository blockRepository; 
	
	@Override
	public User findUserByUserName(String username) {
		return userRepository.findByUserName(username); 
	}

	@Override
	public UserRole getPrimaryRoleByUserId(Long userId) {
		return userRoleRepository.getPrimaryRoleByUserId(userId); 
	}

	@Override
	public JSONObject getLoggedinUserDetails(String token) {
		
		JSONObject jsonObject = new JSONObject(); 
		
		try
		{
			String userName=TokenParser.getUserName(token); 
			User user = userRepository.findByUserName(userName); 
			if(user != null) {  	 
				jsonObject.put("userName", userName); 
				jsonObject.put("name", user.getName()); 
				jsonObject.put("email", user.getEmail()); 
				jsonObject.put("mobile", user.getMobile()); 
				jsonObject.put("address", user.getAddress()); 
				UserRole userRole = userRoleRepository.getPrimaryRoleByUserId(user.getId());  
		        if(userRole != null) {
		        	jsonObject.put("roleCode", userRole.getRole().getRoleName()); 
		        	jsonObject.put("roleName", userRole.getRole().getRoleName()); 
		        }
			} 
			else { 
				jsonObject.put("errorMessage", "No User Found"); 
			} 
		} 
		catch (Exception e) {
			try {
				jsonObject.put("errorMessage", "Something Went Wrong, Please Try After Sometimes.");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			logger.error("Error Message: "+e.toString());   
		}
		
		return jsonObject; 
	}

	@Override
	public void userLogin(User user) {
		user.setIsConfirm(false); 
		Timestamp currentTimeInTimestamp = new Timestamp(System.currentTimeMillis());
		user.setLoggedinTime(currentTimeInTimestamp);
		userRepository.save(user); 
	}

	@Override
	public User userLogout(String token) {
		
		User finalUser = null;
		try
		{
			String userName=TokenParser.getUserName(token); 
			User user = userRepository.findByUserName(userName); 
			if(user != null) {  	 
				user.setIsConfirm(true); 
				user.setLoggedinTime(null); 
				finalUser = userRepository.save(user); 
			} 
		} 
		catch (Exception e) {
			e.printStackTrace();
			logger.error("Error Message: "+e.toString());   
		}
		
		return finalUser;
	}

	@Override
	public List<Role> findAllRole() {
		return roleRepository.findAll(); 
	}

	@Override
	public JSONObject signUpUser(UserDto userDto) {
		
		JSONObject jsonObject = new JSONObject(); 
		String output = validateSignupParameters(userDto);
		if(output.equals("true")) {
			try
			{
				User existingUser = userRepository.findByUserName(userDto.getUserName()); 
				if(existingUser != null) {
					jsonObject.put("errorMessage", "This username is already exist, please try with different one.");
				}
				else {
					boolean validEmailId = true; 
					if(userDto.getEmail() != null) {
						validEmailId = EmailMobileNumberValidation.isValidEmailAddress(userDto.getEmail()); 
					} 
					boolean validMobileNumber = EmailMobileNumberValidation.isValidMobileNumber(userDto.getMobile()); 
					if(validEmailId == true && validMobileNumber == true) {
						Role role = roleRepository.findById(userDto.getRoleId()).get();
						boolean checkAvailableUser = false;
						if(role.getRoleName().equals(UserModuleApplicationConstants.publicUser)) {
							checkAvailableUser = false; 
						}
						else {
							checkAvailableUser = availableUserValidationHelper.checkAvailableUser(role, userDto.getLocationId()); 							
						}
						if(checkAvailableUser == false) {
							User user = new User(); 
							user.setUserName(userDto.getUserName()); 
							user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword())); 
							user.setName(userDto.getName());
							user.setAddress(userDto.getAddress());
							user.setMobile(userDto.getMobile()); 
							user.setEmail(userDto.getEmail());  
							user.setIsAccountNonLocked(true); 
							user.setIsEnabled(true); 
							user.setIsConfirm(true); 
							//user.setCreatedBy(createdBy);
							user.setCreatedDate(new Date()); 
							User result = userRepository.save(user); 
							if(result != null) {
								jsonObject.put("successMessage", "User details has been saved successfully."); 
								//Update User-Role Table
								UserRole userRole = new UserRole();
								userRole.setUser(result);
								userRole.setRole(role); 
								userRole.setIs_primary(true); 
								userRoleRepository.save(userRole); 
								//Update User-Location Table
								UserLocation userLocation = new UserLocation();
								userLocation.setUser(result);
								//For District Level User
								if(role.getRoleName().equals(UserModuleApplicationConstants.collector) || role.getRoleName().equals(UserModuleApplicationConstants.adm) || 
												role.getRoleName().equals(UserModuleApplicationConstants.dswo) || role.getRoleName().equals(UserModuleApplicationConstants.cdpo)) {
									userLocation.setDistrict(districtRepository.findById(userDto.getLocationId()).get());  
								}
								//For Subdivision Level User
								if(role.getRoleName().equals(UserModuleApplicationConstants.subCollector)) {
									userLocation.setSubdivision(subdivisionRepository.findById(userDto.getLocationId()).get());
								}
								//For Block Level User
								if(role.getRoleName().equals(UserModuleApplicationConstants.bdo) || role.getRoleName().equals(UserModuleApplicationConstants.medicalOfficer)) {
									userLocation.setBlock(blockRepository.findById(userDto.getLocationId()).get()); 
								}
								userLocationRepository.save(userLocation); 
							}
							else {
								jsonObject.put("failureMessage", "Unable to save user details."); 
							}
						}
						else {
							jsonObject.put("errorMessage", "User having same role is already exist for the same demography."); 
						}
					} 
					else {
						if(validMobileNumber == true && validEmailId == false) {
							jsonObject.put("errorMessage", "Please provide valid email id."); 
						}
						if(validMobileNumber == false && validEmailId == true) {
							jsonObject.put("errorMessage", "Please provide valid mobile number."); 
						}
						if(validMobileNumber == false && validEmailId == false) {
							jsonObject.put("errorMessage", "Please provide valid mobile number and email id."); 
						}
					} 
				}
			} 
			catch (Exception e) {
				try {
					jsonObject.put("errorMessage", "Something Went Wrong, Please Try After Sometimes.");
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				logger.error("Error Message: "+e.toString());   
			}
		}
		else {
			jsonObject.put("errorMessage", output);
		}
		
		return jsonObject; 
	}
	
	private String validateSignupParameters(UserDto userDto) {  
		 
		String validationMessage = null;
		if(userDto.getName()==null) {
			validationMessage = "Please provide full name.";
		}else if(userDto.getUserName()==null) {
			validationMessage = "Please provide username.";
		}else if(userDto.getPassword()==null) {
			validationMessage = "Please provide password.";
		}else if(userDto.getConfirmPassword()==null) {
			validationMessage = "Please provide confirm password.";
		}else if(!(userDto.getConfirmPassword().equals(userDto.getPassword()))) { 
			validationMessage = "Password did not match.";
		}else if(userDto.getMobile()==null) {
			validationMessage = "Please provide mobile number.";
		}else if(userDto.getRoleId()==null || userDto.getRoleId()==0l) {
			validationMessage = "Please select role.";
		}else if(userDto.getRoleId()!=null && userDto.getRoleId()!=0l) {
			Role role = roleRepository.findById(userDto.getRoleId()).get(); 
			if(role.getRoleName().equals(UserModuleApplicationConstants.collector) || role.getRoleName().equals(UserModuleApplicationConstants.adm) || 
							role.getRoleName().equals(UserModuleApplicationConstants.dswo) || role.getRoleName().equals(UserModuleApplicationConstants.cdpo) ||
							role.getRoleName().equals(UserModuleApplicationConstants.subCollector) || role.getRoleName().equals(UserModuleApplicationConstants.bdo) || 
							role.getRoleName().equals(UserModuleApplicationConstants.medicalOfficer)) {
				if(userDto.getLocationId() == null) {
					validationMessage = "Please provide location related information."; 
				}
			}
		}else {
			validationMessage = "true";
		}
		
		return validationMessage;
	}

	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}

	@Override
	public JSONObject viewProfile(Long userId) {
		
		JSONObject jsonObject = new JSONObject(); 
		
		try
		{
			User user = userRepository.findById(userId).get(); 
			if(user != null) {  	 
				jsonObject.put("name", user.getName()); 
				jsonObject.put("email", user.getEmail()); 
				jsonObject.put("mobile", user.getMobile()); 
				jsonObject.put("address", user.getAddress()); 
			} 
			else { 
				jsonObject.put("errorMessage", "No Data Found"); 
			} 
		} 
		catch (Exception e) {
			try {
				jsonObject.put("errorMessage", "Something Went Wrong, Please Try After Sometimes.");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			logger.error("Error Message: "+e.toString());   
		}
		
		return jsonObject; 
	}

	@Override
	public JSONObject updateProfile(UserDto userDto, String token) {
		
		JSONObject jsonObject = new JSONObject(); 
		String output = validateUpdateProfileParameters(userDto);
		String loggedinUserName = TokenParser.getUserName(token); 
		if(output.equals("true")) {
			try
			{
				boolean validEmailId = true; 
				if(userDto.getEmail() != null) {
					validEmailId = EmailMobileNumberValidation.isValidEmailAddress(userDto.getEmail()); 
				} 
				boolean validMobileNumber = EmailMobileNumberValidation.isValidMobileNumber(userDto.getMobile()); 
				if(validEmailId == true && validMobileNumber == true) {
					User user = userRepository.findById(userDto.getUserId()).get(); 
					if(user == null) {
						jsonObject.put("errorMessage", "No Data Found"); 
					}
					else {
						user.setMobile(userDto.getMobile());
						user.setEmail(userDto.getEmail());
						user.setAddress(userDto.getAddress());
						user.setName(userDto.getName());
						user.setUpdatedBy(loggedinUserName);  
						user.setUpdatedDate(new Date()); 
						User result = userRepository.save(user); 
						if(result != null) {
							jsonObject.put("successMessage", "User details updated successfully."); 
						} 
						else {
							jsonObject.put("failureMessage", "Unable to update user details."); 
						} 
					} 
				} 
				else {
					if(validMobileNumber == true && validEmailId == false) {
						jsonObject.put("errorMessage", "Please provide valid email id."); 
					}
					if(validMobileNumber == false && validEmailId == true) {
						jsonObject.put("errorMessage", "Please provide valid mobile number."); 
					}
					if(validMobileNumber == false && validEmailId == false) {
						jsonObject.put("errorMessage", "Please provide valid mobile number and email id."); 
					}
				} 
			}
			catch (Exception e) {
				try {
					jsonObject.put("errorMessage", "Something Went Wrong, Please Try After Sometimes.");
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				logger.error("Error Message: "+e.toString());   
			}
		}
		else {
			jsonObject.put("errorMessage", output);
		}
		
		return jsonObject; 
	}
	
	private String validateUpdateProfileParameters(UserDto userDto) {  
		 
		String validationMessage = null;
		if(userDto.getName()==null) {
			validationMessage = "Please provide full name.";
		}else if(userDto.getMobile()==null) {
			validationMessage = "Please provide mobile number.";
		}else {
			validationMessage = "true";
		}
		
		return validationMessage;
	}

	@Override
	public JSONObject changePassword(PasswordDto passwordDto, String token) {
		
		JSONObject jsonObject = new JSONObject(); 
		String output = validateChangePasswordParameters(passwordDto); 
		String loggedinUserName = TokenParser.getUserName(token); 
		if(output.equals("true")) {
			try
			{	 
				User existingUser = userRepository.findByUserName(loggedinUserName);  
				if(existingUser == null) {
					jsonObject.put("errorMessage", "No User Found"); 
				}
				else {	
					if(bCryptPasswordEncoder.matches(passwordDto.getOldPassword(), existingUser.getPassword())) {
						if(passwordDto.getNewPassword().equals(passwordDto.getConfirmNewPassword())) {
							existingUser.setPassword(bCryptPasswordEncoder.encode(passwordDto.getNewPassword())); 
							existingUser.setUpdatedDate(new Date());  
							existingUser.setUpdatedBy(loggedinUserName); 
							User result = userRepository.save(existingUser); 
							if(result != null) { 
								jsonObject.put("successMessage", "Password updated successfully.");  
							} 
							else { 
								jsonObject.put("failureMessage", "Unable to update password.");  
							}	
						}
						else {
							jsonObject.put("errorMessage", "New password did not match with confirm new password, please try again."); 
						}
					}
					else {
						jsonObject.put("errorMessage", "Old password did not match."); 
					}
				}			
			}
			catch (Exception e) {
				try {
					jsonObject.put("errorMessage", "Something Went Wrong, Please Try After Sometimes.");
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				logger.error("Error Message: "+e.toString());   
			}
		}
		else {
			jsonObject.put("errorMessage", output);
		}
		
		return jsonObject; 
	}
	
	public String validateChangePasswordParameters(PasswordDto passwordDto) {
		
		String validationMessage = null;
		
		if (passwordDto.getOldPassword() == null) {
			validationMessage = "Please provide old password."; 
		} 
		else if (passwordDto.getNewPassword() == null) {
			validationMessage = "Please provide new password."; 
		} 
		else if (passwordDto.getConfirmNewPassword() == null) {
			validationMessage = "Please provide confirm new password.";  
		} 
		else {
			validationMessage = "Valid Data"; 
		}
		
		return validationMessage;
	}

	@Override
	public JSONObject requestForResetPassword(String userName) {
		
		JSONObject jsonObject = new JSONObject(); 
		
		try
		{
			User user = userRepository.findByUserName(userName); 
			if(user != null) {  	 
				String otp = RandomNumberGenerator.otpGenertor(); 
				user.setResetPasswordOtp(otp); 
				Timestamp currentTimeInTimestamp = new Timestamp(System.currentTimeMillis());
				user.setResetPasswordTime(currentTimeInTimestamp);  
				User result = userRepository.save(user); 
				if(result != null) {
					jsonObject.put("successMessage", "OTP has been sent to the your registered mobile number."); 
					String purpose = "password reset";
					String sms = "Hi "+result.getName()+", Your Application under "+purpose+" has been applied successfully and is pending for the OTP verification, use "+otp+" as your one time password on "+new Date()+" ."; //This is incorrect pattern but as per the existing SMS template. 
					SendSmsUtil.sendTransactionalMessage(result.getMobile(), sms); 
				}
				else {
					jsonObject.put("failureMessage", "Unable to send OTP, please try after sometimes."); 
				}
			} 
			else { 
				jsonObject.put("errorMessage", "No User Found"); 
			} 
			jsonObject.put("userName", userName);
		} 
		catch (Exception e) {
			try {
				jsonObject.put("errorMessage", "Something Went Wrong, Please Try After Sometimes.");
				jsonObject.put("userName", userName);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			logger.error("Error Message: "+e.toString());   
		}
		
		return jsonObject; 
	}

	@Override
	public JSONObject submitOtpForResetPassword(String userName, String otp) {
		
		JSONObject jsonObject = new JSONObject(); 
		
		try
		{
			User user = userRepository.findByUserName(userName); 
			if(user != null) {  	 
				String savedOtp = user.getResetPasswordOtp().trim();
				if(savedOtp.equals(otp)) {
					Timestamp currentTimeInTimestamp = new Timestamp(System.currentTimeMillis());
					Timestamp savedTimestamp = user.getResetPasswordTime(); 
					Long timeDifferenceInMillis = currentTimeInTimestamp.getTime() - savedTimestamp.getTime();
					Long timeDifferenceInSecond = TimeUnit.MILLISECONDS.toSeconds(timeDifferenceInMillis);
					logger.info("Time Difference For OTP Validity Checking: "+timeDifferenceInSecond);
					if(timeDifferenceInSecond < 120) { //120 Seconds=>OTP Validity
						//Please Reset Password 
					}
					else {
						jsonObject.put("errorMessage", "OTP validity has been expired, please try again."); 
					}
				}
				else {
					jsonObject.put("errorMessage", "OTP did not match, please provide correct one."); 
				}
			} 
			else { 
				jsonObject.put("errorMessage", "No User Found"); 
			} 
			jsonObject.put("userName", userName); 
		} 
		catch (Exception e) {
			try {
				jsonObject.put("errorMessage", "Something Went Wrong, Please Try After Sometimes.");
				jsonObject.put("userName", userName); 
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			logger.error("Error Message: "+e.toString());   
		}
		
		return jsonObject; 
	}

	@Override
	public JSONObject resetPassword(String userName, String newPassword, String confirmNewPassword) {
		
		JSONObject jsonObject = new JSONObject(); 
		
		try
		{
			User user = userRepository.findByUserName(userName); 
			if(user != null) {  	 
				if(newPassword.equals(confirmNewPassword)) { 
					user.setPassword(bCryptPasswordEncoder.encode(newPassword)); 
					user.setResetPasswordOtp(null);
					user.setResetPasswordTime(null); 
					User result = userRepository.save(user); 
					if(result != null) { 
						jsonObject.put("successMessage", "Password has been updated successfully."); 
					} 
					else { 
						jsonObject.put("failureMessage", "Unable to update password."); 
					}	
				}
				else {
					jsonObject.put("errorMessage", "New password did not match with confirm new password, please try again."); 
				} 			
			} 
			else { 
				jsonObject.put("errorMessage", "No User Found"); 
			} 
			jsonObject.put("userName", userName); 
		} 
		catch (Exception e) {
			try {
				jsonObject.put("errorMessage", "Something Went Wrong, Please Try After Sometimes.");
				jsonObject.put("userName", userName); 
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			logger.error("Error Message: "+e.toString());   
		}
		
		return jsonObject; 
	}
	
}
	