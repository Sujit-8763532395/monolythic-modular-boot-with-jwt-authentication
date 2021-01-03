package com.aashdit.wcd.common.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.jboss.logging.Logger;

public class EmailMobileNumberValidation {
	
    private static final Logger logger = Logger.getLogger(EmailMobileNumberValidation.class);

	public static boolean isValidEmailAddress(String emailAddress) {
		
		boolean result = true;
		try {
		    InternetAddress emailAddr = new InternetAddress(emailAddress); 
		    emailAddr.validate();
		} catch (AddressException ex) {
		    result = false;
		}
		logger.debug("Email Address Validation Result: "+result); //In Case Of Invalid: false, In Case Of Valid: true. 
		
		return result; 
	}
	
	public static boolean isValidMobileNumber(String mobileNumber) {
		
		boolean result = true;
		int mobileNumberLength = mobileNumber.length(); 
		if(mobileNumberLength == 10){
			result = true;
		}
		else{
			result = false;
		}
		logger.debug("Mobile Number Validation Result: "+result); //In Case Of Invalid: false, In Case Of Valid: true. 
		
		return result; 
	}
	
}
	