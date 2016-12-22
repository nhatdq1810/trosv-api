package services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import controller.TienichCtrl;
import model.TienichModel;

@Path("/tienich")
public class TienichService {
	
	@Path("/tatca")
	@GET
	@Produces("application/json")
	public Response layTatcaTienich() {
		TienichCtrl tienichCtrl = new TienichCtrl();
		ArrayList<TienichModel> model = tienichCtrl.layTatcaTienich();
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
