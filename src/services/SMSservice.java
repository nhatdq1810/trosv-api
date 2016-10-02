package services;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import controller.SMSCtrl;

@Path("/sms")
public class SMSservice {

	@Path("/gui")
	@POST
	@Produces("application/json")
	public Response gui(@FormParam("sodt") String sodt, @FormParam("noidung") String noidung) {
		SMSCtrl smsCtrl = new SMSCtrl();
		String sid = smsCtrl.gui(sodt, noidung);
		JSONObject obj = new JSONObject();
		if (sid.equals("error")) {
			obj.put("result", "fail");
		} else {
			obj.put("result", "success");
		}	
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
