package controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GiaodichModel;
import resources.Constants;
import connectSQL.ConnectServer;

public class GiaodichCtrl {
	private String query;
	private ResultSet rs;
	private CallableStatement stm;
	private ConnectServer conn;

	public GiaodichCtrl() {
		conn = new ConnectServer();
	}
	
	public ArrayList<GiaodichModel> layGiaodich(int userID) {
		ArrayList<GiaodichModel> listGiaodich = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_layGiaodich(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_userID", userID);
				rs = stm.executeQuery();
				while(rs.next()){
					GiaodichModel model = new GiaodichModel();
					model.setUserID_gui(rs.getInt("userID_gui"));
					model.setUserID_nhan(rs.getInt("userID_nhan"));
					model.setNgay(rs.getString("ngay"));
					model.setTien(rs.getFloat("tien"));
					listGiaodich.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_layGiaodich");
				e.printStackTrace();
				return listGiaodich;
			}
		}
		conn.closeConnection();
		return listGiaodich;
	}

	public ArrayList<GiaodichModel> layGiaodichGui(int userID_gui) {
		ArrayList<GiaodichModel> listGiaodich = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_layGiaodichGui(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_userID_gui", userID_gui);
				rs = stm.executeQuery();
				while(rs.next()){
					GiaodichModel model = new GiaodichModel();
					model.setUserID_gui(rs.getInt("userID_gui"));
					model.setUserID_nhan(rs.getInt("userID_nhan"));
					model.setNgay(rs.getString("ngay"));
					model.setTien(rs.getFloat("tien"));
					listGiaodich.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_layGiaodichGui");
				e.printStackTrace();
				return listGiaodich;
			}
		}
		conn.closeConnection();
		return listGiaodich;
	}
	
	public ArrayList<GiaodichModel> layGiaodichNhan(int userID_nhan) {
		ArrayList<GiaodichModel> listGiaodich = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_layGiaodichNhan(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_userID_nhan", userID_nhan);
				rs = stm.executeQuery();
				while(rs.next()){
					GiaodichModel model = new GiaodichModel();
					model.setUserID_gui(rs.getInt("userID_gui"));
					model.setUserID_nhan(rs.getInt("userID_nhan"));
					model.setNgay(rs.getString("ngay"));
					model.setTien(rs.getFloat("tien"));
					listGiaodich.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_layGiaodichNhan");
				e.printStackTrace();
				return listGiaodich;
			}
		}
		conn.closeConnection();
		return listGiaodich;
	}

	public int themGiaodich(GiaodichModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_themGiaodich(?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_userID_gui", model.getUserID_gui());
				stm.setInt("_userID_nhan", model.getUserID_nhan());
				stm.setString("_ngay", model.getNgay());
				stm.setFloat("_tien", model.getTien());
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_themGiaodich");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaGiaodich(int userID) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_xoaGiaodich(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_userID", userID);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_xoaGiaodich");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

}
