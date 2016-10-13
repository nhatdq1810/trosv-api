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

	@Path("/moi")
	@POST
	@Produces("application/json")
	public Response themComment(CommentModel model) {
		CommentCtrl commentCtrl = new CommentCtrl();
		int result = commentCtrl.themComment(model);
		if (result != -999) {
			return layCommentPhongtro(model.getPhongtroID());
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
		if (result != -999) {
			return layCommentPhongtro(model.getPhongtroID());
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
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
		if (result != -999) {
			obj.put("result", "success");
		} else {
			obj.put("result", "fail");
		}
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
