package services;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import controller.UserCtrl;
import model.UserModel;

@Path("/user")
public class UserService {

	@Path("/tatca")
	@GET
	@Produces("application/json")
	public Response layTatcaUser() {
		UserCtrl userCtrl = new UserCtrl();
		ArrayList<UserModel> model = userCtrl.layTatcaUser();
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{username}")
	@GET
	@Produces("application/json")
	public Response layThongtinUser(@PathParam("username") String username) {
		UserCtrl userCtrl = new UserCtrl();
		UserModel model = userCtrl.layThongtinUser(username);
		if (model != null) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/id/{id}")
	@GET
	@Produces("application/json")
	public Response layThongtinUserID(@PathParam("id") int id) {
		UserCtrl userCtrl = new UserCtrl();
		UserModel model = userCtrl.layThongtinUserID(id);
		if (model != null) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeUserTheoThang/{thangBD}/{thangKT}")
	@GET
	@Produces("application/json")
	public Response thongkeUserTheoThang(@PathParam("thangBD") String thangBD, @PathParam("thangKT") String thangKT) {
		UserCtrl userCtrl = new UserCtrl();
		HashMap<Integer, Integer> model = userCtrl.thongkeUserTheoThang(thangBD, thangKT);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeUserMoiTrenTongso/{thang}")
	@GET
	@Produces("application/json")
	public Response thongkeUserMoiTrenTongso(@PathParam("thang") String thang) {
		UserCtrl userCtrl = new UserCtrl();
		HashMap<String, Integer> model = userCtrl.thongkeUserMoiTrenTongso(thang);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeUserComment/{thang}")
	@GET
	@Produces("application/json")
	public Response thongkeUserComment(@PathParam("thang") int thang, @QueryParam("gioihan") int gioihan) {
		UserCtrl userCtrl = new UserCtrl();
		ArrayList<UserModel> model = userCtrl.thongkeUserComment(thang, gioihan);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeUserKieuLogin/{thang}")
	@GET
	@Produces("application/json")
	public Response thongkeUserKieuLogin(@PathParam("thang") int thang) {
		UserCtrl userCtrl = new UserCtrl();
		HashMap<String, Integer> model = userCtrl.thongkeUserKieuLogin(thang);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/thongkeUserTaoPT/{thang}")
	@GET
	@Produces("application/json")
	public Response thongkeUserTaoPT(@PathParam("thang") int thang, @QueryParam("gioihan") int gioihan) {
		UserCtrl userCtrl = new UserCtrl();
		ArrayList<UserModel> model = userCtrl.thongkeUserTaoPT(thang, gioihan);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
	
	@Path("/thongkeUserTheoDTC/{thang}")
	@GET
	@Produces("application/json")
	public Response thongkeUserTheoDTC(@PathParam("thang") int thang, @QueryParam("gioihan") int gioihan) {
		UserCtrl userCtrl = new UserCtrl();
		ArrayList<UserModel> model = userCtrl.thongkeUserTheoDTC(thang, gioihan);
		if (model != null && model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
	
	@Path("/login/{loai}")
	@POST
	@Produces("application/json")
	public Response login(UserModel model, @PathParam("loai") String loai) {
		UserCtrl userCtrl = new UserCtrl();
		UserModel user = userCtrl.login(model.getUsername(), model.getPassword(), loai);
		if (user != null) {
			return Response.status(200).entity(user).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/moi")
	@POST
	@Produces("application/json")
	public Response themUser(UserModel model) {
		UserCtrl userCtrl = new UserCtrl();
		int result = userCtrl.themUser(model);
		JSONObject obj = new JSONObject();
		if (result == 0) {
			obj.put("result", "Username đã có người sử dụng");
		} else if (result == -2) {
			obj.put("result", "Email đã có người sử dụng");
		} else {
			return layThongtinUser(model.getUsername());
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{username}")
	@PUT
	@Produces("application/json")
	public Response capnhatUser(@PathParam("username") String username, UserModel model) {
		UserCtrl userCtrl = new UserCtrl();
		model.setUsername(username);
		int result = userCtrl.capnhatUser(model);
		JSONObject obj = new JSONObject();
		if (result == -2) {
			obj.put("result", "Email đã có người sử dụng");
		} else if (result != -999) {
			return layThongtinUser(username);
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{username}/password")
	@PUT
	@Produces("application/json")
	public Response capnhatPassword(@PathParam("username") String username, UserModel model) {
		UserCtrl userCtrl = new UserCtrl();
		int result = userCtrl.capnhatPassword(username, model.getPassword());
		if (result != -999 && result != 0) {
			return layThongtinUser(username);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{username}/password")
	@POST
	@Produces("application/json")
	public Response phuchoiPassword(@PathParam("username") String username) {
		UserCtrl userCtrl = new UserCtrl();
		int result = userCtrl.phuchoiPassword(username);
		JSONObject obj = new JSONObject();
		if (result != 0 && result != -999) {
			obj.put("result", "Mật khẩu mới đã được gửi tới email của bạn !");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{username}/dotincay")
	@PUT
	@Produces("application/json")
	public Response capnhatDotincay(@PathParam("username") String username, UserModel model) {
		UserCtrl userCtrl = new UserCtrl();
		int result = userCtrl.capnhatDotincay(username, model.getDotincay());
		if (result != -999 && result != 0) {
			return layThongtinUser(username);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response xoaUser(@PathParam("id") int id) {
		UserCtrl userCtrl = new UserCtrl();
		int result = userCtrl.xoaUser(id);
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
