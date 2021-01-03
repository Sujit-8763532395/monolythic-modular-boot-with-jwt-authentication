package com.aashdit.wcd.common.util;

import java.net.URLEncoder;
import java.util.ResourceBundle;

import org.jboss.logging.Logger;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class SendSmsUtil {

	private final static Logger logger = Logger.getLogger(SendSmsUtil.class);
		
	public static void sendTransactionalMessage(String mobileno, String msg) {
		
		try{
			ResourceBundle rb = ResourceBundle.getBundle("application");	
			String MSG91_KEY = rb.getString("MSG91.KEY");
			String MSG91_SENDER = rb.getString("MSG91.SENDER");
			String url = "http://59.162.167.52/api/MessageCompose?admin=support@muupaatechnologies.com&user=" + MSG91_KEY + "&senderID=" + MSG91_SENDER + "&state=4&";
			url = url + "receipientno=" + mobileno + "&msgtxt=" + URLEncoder.encode(msg,"UTF-8");
			HttpResponse<String> responseCredSend = Unirest.get(url).asString();		
			if(responseCredSend.getStatusText().equals("OK")){
				if(responseCredSend.getBody().contains("Template not matched")){ 
					logger.info("Template Not Matched");  
				}
				else {
					logger.info("SMS Has Been Sent Successfully"); 
				} 
			}
		} 
		catch(Exception e){
			logger.error("Exception: "+e.getMessage()); 
		}

	}

}
	