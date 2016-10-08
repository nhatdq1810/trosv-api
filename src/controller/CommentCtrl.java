package controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CommentModel;
import resources.Constants;
import connectSQL.ConnectServer;

public class CommentCtrl {
	private String query;
	private ResultSet rs;
	private CallableStatement stm;
	private ConnectServer conn;

	public CommentCtrl() {
		conn = new ConnectServer();
	}

	public ArrayList<CommentModel> layCommentPhongtro(int phongtroID) {
		ArrayList<CommentModel> listComment = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_layCommentPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_phongtroID", phongtroID);
				rs = stm.executeQuery();
				while (rs.next()) {
					CommentModel cmt = new CommentModel();
					cmt.setId(rs.getInt("id"));
					cmt.setNoidung(rs.getString("noidung"));
					cmt.setNgay(rs.getString("ngay"));
					cmt.setUserID(rs.getInt("userID"));
					cmt.setPhongtroID(phongtroID);
					listComment.add(cmt);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_layCommentPhongtro");
				e.printStackTrace();
				return listComment;
			}
		}
		conn.closeConnection();
		return listComment;
	}

	public ArrayList<CommentModel> layCommentUser(int userID) {
		ArrayList<CommentModel> listComment = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_layCommentUser(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_userID", userID);
				rs = stm.executeQuery();
				while (rs.next()) {
					CommentModel cmt = new CommentModel();
					cmt.setId(rs.getInt("id"));
					cmt.setNoidung(rs.getString("noidung"));
					cmt.setNgay(rs.getString("ngay"));
					cmt.setPhongtroID(rs.getInt("phongtroID"));
					cmt.setUserID(userID);
					listComment.add(cmt);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_layCommentUser");
				e.printStackTrace();
				return listComment;
			}
		}
		conn.closeConnection();
		return listComment;
	}

	public int themComment(CommentModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_themComment(?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_noidung", model.getNoidung());
				stm.setString("_ngay", model.getNgay());
				stm.setInt("_userID", model.getUserID());
				stm.setInt("_phongtroID", model.getPhongtroID());
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_themComment");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int capnhatComment(CommentModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_capnhatComment(?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", model.getId());
				stm.setString("_noidung", model.getNoidung());
				stm.setString("_ngay", model.getNgay());
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_capnhatComment");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaComment(int id) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_xoaComment(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_xoaComment");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

}
