package controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserModel;
import resources.Constants;
import connectSQL.ConnectServer;

public class UserCtrl {
	private String query;
	private ResultSet rs;
	private CallableStatement stm;
	private ConnectServer conn;

	public UserCtrl() {
		conn = new ConnectServer();
	}

	public UserModel layThongtinUser(String username) {
		UserModel result = null;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_layThongtinUser(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				rs = stm.executeQuery();
				if (rs.next()) {
					result = new UserModel();
					result.setId(rs.getInt("id"));
					result.setUsername(username);
					result.setPassword(rs.getString("password"));
					result.setHoten(rs.getString("hoten"));
					result.setDiachi(rs.getString("diachi"));
					result.setSodt(rs.getString("sodt"));
					result.setEmail(rs.getString("email"));
					result.setTien(rs.getFloat("tien"));
					result.setSkype(rs.getString("skype"));
					result.setFacebook(rs.getString("facebook"));
					result.setDotincay(rs.getInt("dotincay"));
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_layThongtinUser");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int login(String username, String password) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_login(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				stm.setString("_password", password);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_login");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int themUser(UserModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_themUser(?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", model.getUsername());
				stm.setString("_password", model.getPassword());
				stm.setString("_hoten", model.getHoten());
				stm.setString("_email", model.getEmail());
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_themUser");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int capnhatUser(UserModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_capnhatUser(?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", model.getUsername());
				stm.setString("_hoten", model.getHoten());
				stm.setString("_diachi", model.getDiachi());
				stm.setString("_sodt", model.getSodt());
				stm.setString("_email", model.getEmail());
				stm.setFloat("_tien", model.getTien());
				stm.setString("_skype", model.getSkype());
				stm.setString("_facebook", model.getFacebook());
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_capnhatUser");
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
			query = "{call " + Constants.nameSQL + ".mysp_capnhatPassword(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				stm.setString("_password", password);
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_capnhatPassword");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int capnhatDotincay(String username, int dotincay) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_capnhatDotincay(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				stm.setInt("_dotincay", dotincay);
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_capnhatDotincay");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaUser(String username) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_xoaUser(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_xoaUser");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}
}
