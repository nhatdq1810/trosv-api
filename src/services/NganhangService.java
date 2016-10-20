package services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import controller.NganhangCtrl;
import model.NganhangModel;

@Path("/nganhang")
public class NganhangService {

	@Path("/{username}")
	@GET
	@Produces("application/json")
	public Response layThongtinNganhang(@PathParam("username") String username) {
		NganhangCtrl nganhangCtrl = new NganhangCtrl();
		NganhangModel model = nganhangCtrl.layThongtinNganhang(username);
		if (model != null) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/login")
	@POST
	@Produces("application/json")
	public Response login(NganhangModel model) {
		NganhangCtrl nganhangCtrl = new NganhangCtrl();
		NganhangModel nganhang = nganhangCtrl.login(model.getUsername(), model.getPassword());
		if (nganhang != null) {
			return Response.status(200).entity(nganhang).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
