package services;

import javax.ws.rs.DELETE;
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

	@Path("/login")
	@POST
	@Produces("application/json")
	public Response login(UserModel model) {
		UserCtrl userCtrl = new UserCtrl();
		UserModel user = userCtrl.login(model.getUsername(), model.getPassword());
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
		if (result != -999 && result !=0) {
			return layThongtinUser(model.getUsername());
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
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
		if (result != -999 && result !=0) {
			return layThongtinUser(username);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{username}/password")
	@PUT
	@Produces("application/json")
	public Response capnhatPassword(@PathParam("username") String username, UserModel model) {
		UserCtrl userCtrl = new UserCtrl();
		int result = userCtrl.capnhatPassword(username, model.getPassword());
		if (result != -999 && result !=0) {
			return layThongtinUser(username);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{username}/dotincay")
	@PUT
	@Produces("application/json")
	public Response capnhatDotincay(@PathParam("username") String username, UserModel model) {
		UserCtrl userCtrl = new UserCtrl();
		int result = userCtrl.capnhatDotincay(username, model.getDotincay());
		if (result != -999 && result !=0) {
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
		JSONObject obj = new JSONObject();
		if (result != -999 && result !=0) {
			obj.put("result", "success");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
