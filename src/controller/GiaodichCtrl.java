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
	
	public ArrayList<GiaodichModel> layGiaodich(int nganhangID) {
		ArrayList<GiaodichModel> listGiaodich = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layGiaodich(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_nganhangID", nganhangID);
				rs = stm.executeQuery();
				while(rs.next()){
					GiaodichModel model = new GiaodichModel();
					model.setNganhangID_gui(rs.getInt("nganhangID_gui"));
					model.setNganhangID_nhan(rs.getInt("nganhangID_nhan"));
					model.setNgay(rs.getString("ngay"));
					model.setTien(rs.getInt("tien"));
					listGiaodich.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layGiaodich");
				e.printStackTrace();
				return listGiaodich;
			}
		}
		conn.closeConnection();
		return listGiaodich;
	}

	public ArrayList<GiaodichModel> layGiaodichGui(int nganhangID_gui) {
		ArrayList<GiaodichModel> listGiaodich = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layGiaodichGui(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_nganhangID_gui", nganhangID_gui);
				rs = stm.executeQuery();
				while(rs.next()){
					GiaodichModel model = new GiaodichModel();
					model.setNganhangID_gui(rs.getInt("nganhangID_gui"));
					model.setNganhangID_nhan(rs.getInt("nganhangID_nhan"));
					model.setNgay(rs.getString("ngay"));
					model.setTien(rs.getInt("tien"));
					listGiaodich.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layGiaodichGui");
				e.printStackTrace();
				return listGiaodich;
			}
		}
		conn.closeConnection();
		return listGiaodich;
	}
	
	public ArrayList<GiaodichModel> layGiaodichNhan(int nganhangID_nhan) {
		ArrayList<GiaodichModel> listGiaodich = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layGiaodichNhan(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_nganhangID_nhan", nganhangID_nhan);
				rs = stm.executeQuery();
				while(rs.next()){
					GiaodichModel model = new GiaodichModel();
					model.setNganhangID_gui(rs.getInt("nganhangID_gui"));
					model.setNganhangID_nhan(rs.getInt("nganhangID_nhan"));
					model.setNgay(rs.getString("ngay"));
					model.setTien(rs.getInt("tien"));
					listGiaodich.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layGiaodichNhan");
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
			query = "{call " + Constants.NAME_SQL + ".mysp_themGiaodich(?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_nganhangID_gui", model.getNganhangID_gui());
				stm.setInt("_nganhangID_nhan", model.getNganhangID_nhan());
				stm.setString("_ngay", model.getNgay());
				stm.setInt("_tien", model.getTien());
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_themGiaodich");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaGiaodich(int nganhangID) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_xoaGiaodich(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_nganhangID", nganhangID);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_xoaGiaodich");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

}
