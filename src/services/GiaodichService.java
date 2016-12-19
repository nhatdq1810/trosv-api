package services;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import controller.GiaodichCtrl;
import model.GiaodichModel;
import model.NganhangModel;
import model.PhongtroModel;

@Path("/giaodich")
public class GiaodichService {

	@Path("/{nganhangID}/tatca")
	@GET
	@Produces("application/json")
	public Response layGiaodich(@PathParam("nganhangID") int nganhangID) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<GiaodichModel> model = giaodichCtrl.layGiaodich(nganhangID);
		if (model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{nganhangID_gui}/gui")
	@GET
	@Produces("application/json")
	public Response layGiaodichGui(@PathParam("nganhangID_gui") int nganhangID_gui) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<GiaodichModel> model = giaodichCtrl.layGiaodichGui(nganhangID_gui);
		if (model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{nganhangID_nhan}/nhan")
	@GET
	@Produces("application/json")
	public Response layGiaodichNhan(@PathParam("nganhangID_nhan") int nganhangID_nhan) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<GiaodichModel> model = giaodichCtrl.layGiaodichNhan(nganhangID_nhan);
		if (model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeGDGui/thang/{thang}")
	@GET
	@Produces("application/json")
	public Response thongkeGDGui(@PathParam("thang") int thang, @QueryParam("gioihan") int gioihan) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<NganhangModel> model = giaodichCtrl.thongkeGDGui(thang, gioihan);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeGDNhan/thang/{thang}")
	@GET
	@Produces("application/json")
	public Response thongkeGDNhan(@PathParam("thang") int thang, @QueryParam("gioihan") int gioihan) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<NganhangModel> model = giaodichCtrl.thongkeGDNhan(thang, gioihan);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeGDTheoPT/thang/{thang}")
	@GET
	@Produces("application/json")
	public Response thongkeGDTheoPT(@PathParam("thang") int thang, @QueryParam("gioihan") int gioihan) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		ArrayList<PhongtroModel> model = giaodichCtrl.thongkeGDTheoPT(thang, gioihan);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeSoGD/{thangBD}/{thangKT}")
	@GET
	@Produces("application/json")
	public Response thongkeSoGD(@PathParam("thangBD") int thangBD, @PathParam("thangKT") int thangKT) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		HashMap<Integer, Integer> model = giaodichCtrl.thongkeSoGD(thangBD, thangKT);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeGDTheoLoaiGDMoiThang/thang/{thang}")
	@GET
	@Produces("application/json")
	public Response thongkeGDTheoLoaiGDMoiThang(@PathParam("thang") int thang) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		HashMap<String, Integer> model = giaodichCtrl.thongkeGDTheoLoaiGDMoiThang(thang);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/phongtro/chuyenTien")
	@POST
	@Produces("application/json")
	public Response chuyenTien(GiaodichModel model) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		int result = giaodichCtrl.chuyenTien(model);
		JSONObject obj = new JSONObject();
		if (result != -999 && result != 0) {
			obj.put("result", "success");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{nganhangID}")
	@DELETE
	@Produces("application/json")
	public Response xoaGiaodich(@PathParam("nganhangID") int nganhangID) {
		GiaodichCtrl giaodichCtrl = new GiaodichCtrl();
		int result = giaodichCtrl.xoaGiaodich(nganhangID);
		JSONObject obj = new JSONObject();
		if (result != -999 && result != 0) {
			obj.put("result", "success");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
