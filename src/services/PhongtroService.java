package services;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import controller.PhongtroCtrl;
import model.PhongtroModel;

@Path("/phongtro")
public class PhongtroService {

	@Path("/user/{userID}")
	@GET
	@Produces("application/json")
	public Response layPhongtroUser(@PathParam("userID") int userID) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		ArrayList<PhongtroModel> model = phongtroCtrl.layPhongtroUser(userID);
		if (model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response layPhongtro(@PathParam("id") int id) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		PhongtroModel model = phongtroCtrl.layPhongtro(id);
		if (model != null) {
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
	public Response themPhongtro(@FormParam("diachi") String diachi,
			@FormParam("giatien") float giatien, @FormParam("ngaydang") String ngaydang,
			@FormParam("songuoi") int songuoi, @FormParam("tiencoc") float tiencoc, @FormParam("truong") String truong,
			@FormParam("nganh") String nganh, @FormParam("khoa") String khoa, @FormParam("wifi") int wifi,
			@FormParam("chu") int chu, @FormParam("userID") int userID, @FormParam("ghichu") String ghichu) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		PhongtroModel model = new PhongtroModel();
		model.setDiachi(diachi);
		model.setGiatien(giatien);
		model.setNgaydang(ngaydang);
		model.setSonguoi(songuoi);
		model.setTiencoc(tiencoc);
		model.setTruong(truong);
		model.setNganh(nganh);
		model.setKhoa(khoa);
		model.setWifi(wifi);
		model.setChu(chu);
		model.setUserID(userID);
		model.setGhichu(ghichu);
		int result = phongtroCtrl.themPhongtro(model);
		if (result != -999) {
			return layPhongtro(result);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}")
	@PUT
	@Produces("application/json")
	public Response capnhatPhongtro(@PathParam("id") int id, @FormParam("diachi") String diachi,
			@FormParam("giatien") float giatien, @FormParam("ngaydang") String ngaydang,
			@FormParam("songuoi") int songuoi, @FormParam("tiencoc") float tiencoc, @FormParam("truong") String truong,
			@FormParam("nganh") String nganh, @FormParam("khoa") String khoa, @FormParam("wifi") int wifi,
			@FormParam("chu") int chu, @FormParam("userID") int userID, @FormParam("ghichu") String ghichu) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		PhongtroModel model = new PhongtroModel();
		model.setId(id);
		model.setDiachi(diachi);
		model.setGiatien(giatien);
		model.setNgaydang(ngaydang);
		model.setSonguoi(songuoi);
		model.setTiencoc(tiencoc);
		model.setTruong(truong);
		model.setNganh(nganh);
		model.setKhoa(khoa);
		model.setWifi(wifi);
		model.setChu(chu);
		model.setGhichu(ghichu);
		model.setUserID(userID);
		int result = phongtroCtrl.capnhatPhongtro(model);
		if (result != -999) {
			return layPhongtro(id);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}/user/{userID}")
	@DELETE
	@Produces("application/json")
	public Response xoaPhongtroUser(@PathParam("id") int id, @PathParam("userID") int userID) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		int result = phongtroCtrl.xoaPhongtro(id);
		if (result != -999) {
			return layPhongtroUser(userID);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
