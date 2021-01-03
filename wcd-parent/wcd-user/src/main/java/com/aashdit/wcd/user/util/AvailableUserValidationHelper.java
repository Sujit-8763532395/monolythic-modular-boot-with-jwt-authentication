package com.aashdit.wcd.user.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aashdit.wcd.user.model.Role;
import com.aashdit.wcd.user.model.User;
import com.aashdit.wcd.user.model.UserLocation;
import com.aashdit.wcd.user.repository.UserLocationRepository;
import com.aashdit.wcd.user.repository.UserRepository;

@Component
public class AvailableUserValidationHelper {
	
	private static final Logger logger = LoggerFactory.getLogger(AvailableUserValidationHelper.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserLocationRepository userLocationRepository;
	
	public boolean checkAvailableUser(Role role, Long locationId) {
		
		boolean flag = false;
		List<User> userList = userRepository.findExistingUserByRole(role.getId()); 
		if(userList != null && userList.size() > 0) {
			//For State Level User
			if(role.getRoleName().equals(UserModuleApplicationConstants.admin) || role.getRoleName().equals(UserModuleApplicationConstants.secretary)) {
				flag = true; 
			} 
			//For District Level User
			if(role.getRoleName().equals(UserModuleApplicationConstants.collector) || role.getRoleName().equals(UserModuleApplicationConstants.adm) || 
							role.getRoleName().equals(UserModuleApplicationConstants.dswo) || role.getRoleName().equals(UserModuleApplicationConstants.cdpo)) {
				boolean isDistrictLevelExist = false;
				for(User user:userList) {
					UserLocation userLocation = userLocationRepository.getDistrictLevelUser(locationId, user.getId()); 
					if(userLocation != null) {
						isDistrictLevelExist = true; 
					}
				}
				if(isDistrictLevelExist == true) {
					flag = true;
				}
			}
			//For Subdivision Level User
			if(role.getRoleName().equals(UserModuleApplicationConstants.subCollector)) {
				boolean isSubdivisionLevelExist = false;
				for(User user:userList) {
					UserLocation userLocation = userLocationRepository.getSubdivisionLevelUser(locationId, user.getId()); 
					if(userLocation != null) {
						isSubdivisionLevelExist = true;
					}
				}
				if(isSubdivisionLevelExist == true) {
					flag = true;
				}
			}
			//For Block Level User
			if(role.getRoleName().equals(UserModuleApplicationConstants.bdo) || role.getRoleName().equals(UserModuleApplicationConstants.medicalOfficer)) {
				boolean isBlockLevelExist = false;
				for(User user:userList) {
					UserLocation userLocation = userLocationRepository.getBlockLevelUser(locationId, user.getId()); 
					if(userLocation != null) {
						isBlockLevelExist = true; 
					}
				}
				if(isBlockLevelExist == true) {
					flag = true;
				}
			}
		}
		
		return flag;
	}
	
}
	