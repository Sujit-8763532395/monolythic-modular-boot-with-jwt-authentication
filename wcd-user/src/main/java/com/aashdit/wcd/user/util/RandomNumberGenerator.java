package com.aashdit.wcd.user.util;

import java.security.SecureRandom;

public class RandomNumberGenerator {
	 
	public static String otpGenertor()
	{
		SecureRandom random= new SecureRandom();
		int num=random.nextInt(100000);
		String formatted=String.format("%06d", num);
		return formatted; 
	} 

}	
	