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
		if (conn.openConnection("layCommentPhongtro")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layCommentPhongtro(?)}";
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
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layCommentPhongtro");
				e.printStackTrace();
				return listComment;
			}
		}
		conn.closeConnection();
		return listComment;
	}

	public ArrayList<CommentModel> layCommentUser(int userID) {
		ArrayList<CommentModel> listComment = new ArrayList<>();
		if (conn.openConnection("layCommentUser")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layCommentUser(?)}";
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
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layCommentUser");
				e.printStackTrace();
				return listComment;
			}
		}
		conn.closeConnection();
		return listComment;
	}

	public int layLuotThichComment(int id) {
		int result = -999;
		if (conn.openConnection("layLuotThichComment")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layLuotThichComment(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_commentID", id);
				rs = stm.executeQuery();
				if (rs.next()) {
					result = rs.getInt("thich");
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layLuotThichComment");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public ArrayList<Integer> layCommentUserThich(int userID) {
		ArrayList<Integer> listCmtID = new ArrayList<>();
		if (conn.openConnection("layCommentUserThich")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layCommentUserThich(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_userID", userID);
				rs = stm.executeQuery();
				while (rs.next()) {
					listCmtID.add(rs.getInt("commentID"));
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layCommentUserThich");
				e.printStackTrace();
				return listCmtID;
			}
		}
		conn.closeConnection();
		return listCmtID;
	}

	public CommentModel themComment(CommentModel model) {
		CommentModel cmt = null;
		if (conn.openConnection("themComment")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_themComment(?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_noidung", model.getNoidung());
				stm.setString("_ngay", model.getNgay());
				stm.setInt("_userID", model.getUserID());
				stm.setInt("_phongtroID", model.getPhongtroID());
				rs = stm.executeQuery();
				if(rs.next()) {
					cmt = new CommentModel();
					cmt.setId(rs.getInt("id"));
					cmt.setNgay(rs.getString("ngay"));
					cmt.setNoidung(rs.getString("noidung"));
					cmt.setPhongtroID(rs.getInt("phongtroID"));
					cmt.setUserID(rs.getInt("userID"));
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_themComment");
				e.printStackTrace();
				return cmt;
			}
		}
		conn.closeConnection();
		return cmt;
	}

	public int capnhatComment(CommentModel model) {
		int result = -999;
		if (conn.openConnection("capnhatComment")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_capnhatComment(?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", model.getId());
				stm.setString("_noidung", model.getNoidung());
				stm.setString("_ngay", model.getNgay());
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_capnhatComment");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int thichComment(int id, int userID) {
		int result = -999;
		if (conn.openConnection("thichComment")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thichComment(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_commentID", id);
				stm.setInt("_userID", userID);
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thichComment");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaComment(int id) {
		int result = -999;
		if (conn.openConnection("xoaComment")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_xoaComment(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_xoaComment");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int boThichComment(int id, int userID) {
		int result = -999;
		if (conn.openConnection("boThichComment")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_boThichComment(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_commentID", id);
				stm.setInt("_userID", userID);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_boThichComment");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}
}
