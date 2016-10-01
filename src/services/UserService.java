package services;

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

import controller.UserCtrl;
import model.UserModel;

@Path("/user")
public class UserService {

	@Path("/{username}")
	@GET
	@Produces("application/json")
	public Response layThongtinUser(@PathParam("username") String username) {
		UserCtrl userCtrl = new UserCtrl();
		UserModel model = userCtrl.layThongtinUser(username);
		return Response.status(200).entity(model).build();
	}

	@Path("/login")
	@POST
	@Produces("application/json")
	public Response login(@FormParam("username") String username, @FormParam("password") String password) {
		UserCtrl userCtrl = new UserCtrl();
		int result = userCtrl.login(username, password);
		if (result != -999) {
			return layThongtinUser(username);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/them")
	@POST
	@Produces("application/json")
	public Response themUser(@FormParam("username") String username, @FormParam("password") String password,
			@FormParam("hoten") String hoten, @FormParam("email") String email) {
		UserCtrl userCtrl = new UserCtrl();
		UserModel model = new UserModel();
		model.setUsername(username);
		model.setPassword(password);
		model.setHoten(hoten);
		model.setEmail(email);
		int result = userCtrl.themUser(model);
		if (result != -999) {
			return layThongtinUser(username);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{username}")
	@PUT
	@Produces("application/json")
	public Response capnhatUser(@PathParam("username") String username, @FormParam("hoten") String hoten,
			@FormParam("diachi") String diachi, @FormParam("sodt") String sodt, @FormParam("email") String email,
			@FormParam("tien") float tien, @FormParam("skype") String skype, @FormParam("facebook") String facebook) {
		UserCtrl userCtrl = new UserCtrl();
		UserModel model = new UserModel();
		model.setUsername(username);
		model.setHoten(hoten);
		model.setDiachi(diachi);
		model.setSodt(sodt);
		model.setEmail(email);
		model.setTien(tien);
		model.setSkype(skype);
		model.setFacebook(facebook);
		int result = userCtrl.capnhatUser(model);
		if (result != -999) {
			return layThongtinUser(username);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{username}")
	@DELETE
	@Produces("application/json")
	public Response xoaUser(@PathParam("username") String username) {
		UserCtrl userCtrl = new UserCtrl();
		int result = userCtrl.xoaUser(username);
		if (result != -999) {
			return layThongtinUser(username);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
