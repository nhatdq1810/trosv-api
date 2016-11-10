package services;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import controller.CommentCtrl;
import model.CommentModel;

@Path("/comment")
public class CommentService {

	@Path("/phongtro/{phongtroID}")
	@GET
	@Produces("application/json")
	public Response layCommentPhongtro(@PathParam("phongtroID") int phongtroID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		ArrayList<CommentModel> model = commentCtrl.layCommentPhongtro(phongtroID);
		if (model.size() > 0) {
			return Response.status(200).entity(model).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/user/{userID}")
	@GET
	@Produces("application/json")
	public Response layCommentUser(@PathParam("userID") int userID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		ArrayList<CommentModel> model = commentCtrl.layCommentUser(userID);
		if (model.size() > 0) {
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
	public Response layLuotThichComment(@PathParam("id") int id) {
		CommentCtrl commentCtrl = new CommentCtrl();
		int result = commentCtrl.layLuotThichComment(id);
		if (result != -999) {
			return Response.status(200).entity(result).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
	
	@Path("/like/user/{userID}")
	@GET
	@Produces("application/json")
	public Response layCommentUserThich(@PathParam("userID") int userID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		ArrayList<Integer> result = commentCtrl.layCommentUserThich(userID);
		if (result.size() > 0) {
			return Response.status(200).entity(result).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
	
	@Path("/moi")
	@POST
	@Produces("application/json")
	public Response themComment(CommentModel model) {
		CommentCtrl commentCtrl = new CommentCtrl();
		CommentModel result = commentCtrl.themComment(model);
		if (result != null) {
			return Response.status(200).entity(result).build();
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}")
	@PUT
	@Produces("application/json")
	public Response capnhatComment(@PathParam("id") int id, CommentModel model) {
		CommentCtrl commentCtrl = new CommentCtrl();
		model.setId(id);
		int result = commentCtrl.capnhatComment(model);
		if (result != -999 && result !=0) {
			return layCommentPhongtro(model.getPhongtroID());
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}/like/user/{userID}")
	@PUT
	@Produces("application/json")
	public Response thichComment(@PathParam("id") int id, @PathParam("userID") int userID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		int result = commentCtrl.thichComment(id, userID);
		JSONObject obj = new JSONObject();
		if (result != -999 && result !=0) {
			obj.put("result", "success");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
	
	@Path("/{id}/phongtro/{phongtroID}")
	@DELETE
	@Produces("application/json")
	public Response xoaComment(@PathParam("id") int id) {
		CommentCtrl commentCtrl = new CommentCtrl();
		int result = commentCtrl.xoaComment(id);
		JSONObject obj = new JSONObject();
		if (result != -999 && result !=0) {
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
	public Response boThichComment(@PathParam("id") int id, @PathParam("userID") int userID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		int result = commentCtrl.boThichComment(id, userID);
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
