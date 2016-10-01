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

import controller.CommentCtrl;
import model.CommentModel;

@Path("/comment")
public class CommentService {

	@Path("/layCommentPhongtro/{phongtroID}")
	@GET
	@Produces("application/json")
	public Response layCommentPhongtro(@PathParam("phongtroID") int phongtroID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		ArrayList<CommentModel> model = commentCtrl.layCommentPhongtro(phongtroID);
		return Response.status(200).entity(model).build();
	}

	@Path("/layCommentUser/{userID}")
	@GET
	@Produces("application/json")
	public Response layCommentUser(@PathParam("userID") int userID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		ArrayList<CommentModel> model = commentCtrl.layCommentUser(userID);
		return Response.status(200).entity(model).build();
	}

	@Path("/them")
	@POST
	@Produces("application/json")
	public Response themComment(@FormParam("noidung") String noidung, @FormParam("ngay") String ngay,
			@FormParam("userID") int userID, @FormParam("phongtroID") int phongtroID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		CommentModel model = new CommentModel();
		model.setNoidung(noidung);
		model.setNgay(ngay);
		model.setUserID(userID);
		model.setPhongtroID(phongtroID);
		int result = commentCtrl.themComment(model);
		if (result != -999) {
			return layCommentPhongtro(phongtroID);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}")
	@PUT
	@Produces("application/json")
	public Response capnhatComment(@PathParam("id") int id, @FormParam("noidung") String noidung,
			@FormParam("ngay") String ngay, @FormParam("phongtroID") int phongtroID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		CommentModel model = new CommentModel();
		model.setId(id);
		model.setNoidung(noidung);
		model.setNgay(ngay);
		int result = commentCtrl.capnhatComment(model);
		if (result != -999) {
			return layCommentPhongtro(phongtroID);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}

	@Path("/{id}/phongtro/{phongtroID}")
	@DELETE
	@Produces("application/json")
	public Response xoaComment(@PathParam("id") int id, @PathParam("phongtroID") int phongtroID) {
		CommentCtrl commentCtrl = new CommentCtrl();
		int result = commentCtrl.xoaComment(id);
		if (result != -999) {
			return layCommentPhongtro(phongtroID);
		}
		JSONObject obj = new JSONObject();
		obj.put("result", "fail");
		String rs = "" + obj;
		return Response.status(200).entity(rs).build();
	}
}
