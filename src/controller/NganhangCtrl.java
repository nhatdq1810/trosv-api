package controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectSQL.ConnectServer;
import model.NganhangModel;
import resources.Constants;

public class NganhangCtrl {
	private String query;
	private ResultSet rs;
	private CallableStatement stm;
	private ConnectServer conn;

	public NganhangCtrl() {
		conn = new ConnectServer();
	}

	public NganhangModel layThongtinNganhang(String username) {
		NganhangModel result = null;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layThongtinNganhang(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				rs = stm.executeQuery();
				if (rs.next()) {
					result = new NganhangModel();
					result.setId(rs.getInt("id"));
					result.setUsername(username);
					result.setPassword(rs.getString("password"));
					result.setHoten(rs.getString("hoten"));
					result.setCmnd(rs.getString("cmnd"));
					if (rs.getString("diachi") == null) {
						result.setDiachi("");
					} else {
						result.setDiachi(rs.getString("diachi"));
					}
					if (rs.getString("sodt") == null) {
						result.setSodt("");
					} else {
						result.setSodt(rs.getString("sodt"));
					}
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layThongtinNganhang");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public NganhangModel login(String username, String password) {
		NganhangModel nganhang = null;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_nghLogin(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				stm.setString("_password", password);
				rs = stm.executeQuery();
				if (rs.next()) {
					nganhang = new NganhangModel();
					nganhang.setId(rs.getInt("id"));
					nganhang.setUsername(username);
					nganhang.setPassword(password);
					nganhang.setHoten(rs.getString("hoten"));
					nganhang.setCmnd(rs.getString("cmnd"));
					nganhang.setDiachi(rs.getString("diachi"));
					nganhang.setSodt(rs.getString("sodt"));
					nganhang.setTien(rs.getInt("tien"));
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_nghLogin");
				e.printStackTrace();
				return nganhang;
			}
		}
		conn.closeConnection();
		return nganhang;
	}

	public int themNganhang(NganhangModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_themNganhang(?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", model.getUsername());
				stm.setString("_password", model.getPassword());
				stm.setString("_hoten", model.getHoten());
				stm.setString("_cmnd", model.getCmnd());
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_themNganhang");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int capnhatNganhang(NganhangModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_capnhatNganhang(?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", model.getUsername());
				stm.setString("_hoten", model.getHoten());
				stm.setString("_diachi", model.getDiachi());
				stm.setString("_sodt", model.getSodt());
				stm.setString("_cmnd", model.getCmnd());
				stm.setFloat("_tien", model.getTien());
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_capnhatNganhang");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int capnhatPassword(String username, String password) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_capnhatPassword(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				stm.setString("_password", password);
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_capnhatPassword");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaNganhang(String username) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_xoaNganhang(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_xoaNganhang");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}
}
