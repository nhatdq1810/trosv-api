package services;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import controller.GiaodichCtrl;
import model.GiaodichModel;

@Path("/giaodich")
public class GiaodichService {
	
	@Path("/{userID}")
	@GET
	@Produces("application/json")
	public Response layGiaodich(@PathParam("userID") int userID) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<GiaodichModel> model = giaodichCtrl.layGiaodich(userID);
		return Response.status(200).entity(model).build();
	}

	@Path("/them")
	@POST
	@Produces("application/json")
	public Response themGiaodich(@FormParam("ngay") String ngay, @FormParam("tien") float tien,
			@FormParam("userID_gui") int userID_gui, @FormParam("userID_nhan") int userID_nhan) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		GiaodichModel model = new GiaodichModel();
		model.setNgay(ngay);
		model.setTien(tien);
		model.setUserID_gui(userID_gui);
		model.setUserID_nhan(userID_nhan);
		int result = giaodichCtrl.themGiaodich(model);
		if (result != -999) {
			return layGiaodich(userID_gui);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{userID}")
	@DELETE
	@Produces("application/json")
	public Response xoaGiaodich(@PathParam("userID") int userID) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		int result = giaodichCtrl.xoaGiaodich(userID);
		if (result != -999) {
			return layGiaodich(userID);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
