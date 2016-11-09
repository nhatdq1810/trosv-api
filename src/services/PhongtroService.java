package services;

import java.io.InputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.sun.jersey.multipart.FormDataParam;

import controller.PhongtroCtrl;
import model.PhongtroModel;

@Path("/phongtro")
public class PhongtroService {

	@Path("/tatca")
	@GET
	@Produces("application/json")
	public Response layTatcaPhongtro() {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		ArrayList<PhongtroModel> listPT = phongtroCtrl.layTatcaPhongtro();
		if (listPT.size() > 0) {
			return Response.status(200).entity(listPT).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

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

	@Path("/moi")
	@GET
	@Produces("application/json")
	public Response layPhongtroMoi(@QueryParam("gioihan") int gioihan) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		ArrayList<PhongtroModel> model = phongtroCtrl.layPhongtroMoi(gioihan);
		if (model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/hot")
	@GET
	@Produces("application/json")
	public Response layPhongtroHot(@QueryParam("gioihan") int gioihan) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		ArrayList<PhongtroModel> model = phongtroCtrl.layPhongtroHot(gioihan);
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

	@Path("/{id}/like")
	@GET
	@Produces("application/json")
	public Response layLuotThichPhongtro(@PathParam("id") int id) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		int result = phongtroCtrl.layLuotThichPhongtro(id);
		if (result != -999) {
			return Response.status(200).entity(result).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}/like/user/{userID}")
	@GET
	@Produces("application/json")
	public Response kiemtraUserThichPhongtro(@PathParam("id") int id, @PathParam("userID") int userID) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		int result = phongtroCtrl.kiemtraUserThichPhongtro(id, userID);
		JSONObject obj = new JSONObject();
		if (result != -999 && result != 0) {
			obj.put("result", "success");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/timkiem")
	@GET
	@Produces("application/json")
	public Response timkiemPhongtro(@QueryParam("giatien_min") int giatien_min,
			@QueryParam("giatien_max") int giatien_max, @QueryParam("tiencoc_min") int tiencoc_min,
			@QueryParam("tiencoc_max") int tiencoc_max, @QueryParam("dientich_min") int dientich_min,
			@QueryParam("dientich_max") int dientich_max, @QueryParam("truong") String truong,
			@QueryParam("nganh") String nganh, @QueryParam("khoa") String khoa, @QueryParam("gioitinh") String gioitinh,
			@QueryParam("wifi") int wifi, @QueryParam("chu") int chu, @QueryParam("gioihan") int gioihan) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		ArrayList<PhongtroModel> listPT = phongtroCtrl.timkiemPhongtro(giatien_min, giatien_max, tiencoc_min,
				tiencoc_max, dientich_min, dientich_max, truong, nganh, khoa, gioitinh, wifi, chu, gioihan);
		if (listPT.size() > 0) {
			return Response.status(200).entity(listPT).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/moi")
	@POST
	@Produces("application/json")
	public Response themPhongtro(PhongtroModel model) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		int result = phongtroCtrl.themPhongtro(model);
		if (result != -999 && result != 0) {
			return layPhongtro(result);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/hinhanh")
	@POST
	@Produces("application/json")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response themHinhanhPhongtro(@DefaultValue("true") @FormDataParam("enabled") boolean enabled,
			@FormDataParam("file") InputStream fileStream, @FormDataParam("id") int id) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		int result = phongtroCtrl.capnhatHinhanhPhongtro(id, fileStream);
		JSONObject obj = new JSONObject();
		if (result != -999 && result != 0) {
			obj.put("result", "success");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}")
	@PUT
	@Produces("application/json")
	public Response capnhatPhongtro(@PathParam("id") int id, PhongtroModel model) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		model.setId(id);
		int result = phongtroCtrl.capnhatPhongtro(model);
		if (result != -999 && result != 0) {
			return layPhongtro(id);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}/like/user/{userID}")
	@PUT
	@Produces("application/json")
	public Response thichPhongtro(@PathParam("id") int id, @PathParam("userID") int userID) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		int result = phongtroCtrl.thichPhongtro(id, userID);
		JSONObject obj = new JSONObject();
		if (result != -999 && result != 0) {
			obj.put("result", "success");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}/user/{userID}")
	@DELETE
	@Produces("application/json")
	public Response xoaPhongtro(@PathParam("id") int id, @PathParam("userID") int userID) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		int result = phongtroCtrl.xoaPhongtro(id);
		JSONObject obj = new JSONObject();
		if (result != -999 && result != 0) {
			layPhongtroUser(userID);
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}/hinhanh/{deletehash}")
	@DELETE
	@Produces("application/json")
	public Response xoaHinhanhPhongtro(@PathParam("id") int id, @PathParam("deletehash") String deletehash) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		int result = phongtroCtrl.xoaHinhanhPhongtro(id, deletehash);
		JSONObject obj = new JSONObject();
		if (result != -999 && result != 0) {
			obj.put("result", "success");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}/like/user/{userID}")
	@DELETE
	@Produces("application/json")
	public Response boThichPhongtro(@PathParam("id") int id, @PathParam("userID") int userID) {
		PhongtroCtrl phongtroCtrl = new PhongtroCtrl();
		int result = phongtroCtrl.boThichPhongtro(id, userID);
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
