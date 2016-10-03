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

	@Path("/{userID}/tatca")
	@GET
	@Produces("application/json")
	public Response layGiaodich(@PathParam("userID") int userID) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<GiaodichModel> model = giaodichCtrl.layGiaodich(userID);
		if (model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
	
	@Path("/{userID_gui}/gui")
	@GET
	@Produces("application/json")
	public Response layGiaodichGui(@PathParam("userID_gui") int userID_gui) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<GiaodichModel> model = giaodichCtrl.layGiaodichGui(userID_gui);
		if (model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{userID_nhan}/nhan")
	@GET
	@Produces("application/json")
	public Response layGiaodichNhan(@PathParam("userID_nhan") int userID_nhan) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<GiaodichModel> model = giaodichCtrl.layGiaodichNhan(userID_nhan);
		if (model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/moi")
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
			return layGiaodichGui(userID_gui);
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
			return layGiaodichGui(userID);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
