package services;

import com.twilio.sdk.Twilio;
import com.twilio.sdk.resource.api.v2010.account.Message;
import com.twilio.sdk.type.PhoneNumber;

import resources.Constants;

public class SMSservice {
	public void send(String msg){
		Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
		Message message = Message.create(Constants.ACCOUNT_SID, new PhoneNumber("+84987413902"),
				new PhoneNumber(Constants.TWILLIO_NUMBER), msg).execute();
	}
	public static void main(String[] args) {
		SMSservice demo = new SMSservice();
		demo.send("demo message");
	}
}
