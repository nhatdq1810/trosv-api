package controller;

import com.twilio.sdk.Twilio;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.resource.api.v2010.account.Message;
import com.twilio.sdk.type.PhoneNumber;

import resources.Constants;

public class SMSCtrl {
	public String gui(String sodt, String noidung){
		Message msg = null;
		try {
			Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
			msg = Message.create(Constants.ACCOUNT_SID, new PhoneNumber(sodt),
					new PhoneNumber(Constants.TWILLIO_NUMBER), noidung).execute();
		} catch (ApiException e) {
			System.out.println("Error SMSCtrl gui");
			e.printStackTrace();
			return "error";
		}	
		return msg.getSid();
	}
}
