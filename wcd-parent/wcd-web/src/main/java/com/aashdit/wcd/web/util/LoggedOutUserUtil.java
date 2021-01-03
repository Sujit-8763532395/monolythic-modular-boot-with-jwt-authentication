package com.aashdit.wcd.web.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aashdit.wcd.user.model.User;
import com.aashdit.wcd.user.repository.UserRepository;

@Component
public class LoggedOutUserUtil {
	
	final static Logger logger = Logger.getLogger(LoggedOutUserUtil.class); 
	
	@Autowired
	private UserRepository userRepository; 
	
	//Will Run In Every 1 Minute
	//@Scheduled(cron="*/1 * * * *") 
	@Scheduled(fixedRate = 60000) 
    public void loggedOutLoggedInUser() {
		try {		
			logger.info("User logout schedular started successfully at " + new Date());	
			List<User> userList = userRepository.getLoggedInUsers();
			if (userList != null && userList.size() > 0) {
				for (User user : userList) {	
					Timestamp currentTimeInTimestamp = new Timestamp(System.currentTimeMillis());
					Timestamp savedTimestamp = user.getLoggedinTime(); 
					Long timeDifferenceInMillis = currentTimeInTimestamp.getTime() - savedTimestamp.getTime();
					Long timeDifferenceInSecond = TimeUnit.MILLISECONDS.toSeconds(timeDifferenceInMillis);
					if (timeDifferenceInSecond > 900) { // 15 Minutes
						user.setIsConfirm(true); 
						user.setLoggedinTime(null); 
 						User userObj = userRepository.save(user);
						logger.info(userObj.getName() + " " + "is loggedout successfully.");
					}
				}
			}
			logger.info("User logout schedular stopped successfully at " + new Date());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
}
	