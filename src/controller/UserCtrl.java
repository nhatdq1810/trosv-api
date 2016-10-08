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
			query = "{call " + Constants.NAME_SQL + ".mysp_layThongtinUser(?)}";
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
					result.setEmail(rs.getString("email"));
					result.setDotincay(rs.getInt("dotincay"));
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
					if (rs.getString("skype") == null) {
						result.setSkype("");
					} else {
						result.setSkype(rs.getString("skype"));
					}
					if (rs.getString("facebook") == null) {
						result.setFacebook("");
					} else {
						result.setFacebook(rs.getString("facebook"));
					}
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layThongtinUser");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public UserModel login(String username, String password) {
		UserModel user = null;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_login(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				stm.setString("_password", password);
				rs = stm.executeQuery();
				if(rs.next()){
					user = new UserModel();
					user.setId(rs.getInt("id"));
					user.setUsername(username);
					user.setPassword(rs.getString("password"));
					user.setHoten(rs.getString("hoten"));
					user.setEmail(rs.getString("email"));
					user.setDotincay(rs.getInt("dotincay"));
					if (rs.getString("diachi") == null) {
						user.setDiachi("");
					} else {
						user.setDiachi(rs.getString("diachi"));
					}
					if (rs.getString("sodt") == null) {
						user.setSodt("");
					} else {
						user.setSodt(rs.getString("sodt"));
					}
					if (rs.getString("skype") == null) {
						user.setSkype("");
					} else {
						user.setSkype(rs.getString("skype"));
					}
					if (rs.getString("facebook") == null) {
						user.setFacebook("");
					} else {
						user.setFacebook(rs.getString("facebook"));
					}
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_login");
				e.printStackTrace();
				return user;
			}
		}
		conn.closeConnection();
		return user;
	}

	public int themUser(UserModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_themUser(?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", model.getUsername());
				stm.setString("_password", model.getPassword());
				stm.setString("_hoten", model.getHoten());
				stm.setString("_email", model.getEmail());
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_themUser");
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
			query = "{call " + Constants.NAME_SQL + ".mysp_capnhatUser(?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", model.getUsername());
				stm.setString("_hoten", model.getHoten());
				stm.setString("_diachi", model.getDiachi());
				stm.setString("_sodt", model.getSodt());
				stm.setString("_email", model.getEmail());
				stm.setString("_skype", model.getSkype());
				stm.setString("_facebook", model.getFacebook());
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_capnhatUser");
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

	public int capnhatDotincay(String username, int dotincay) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_capnhatDotincay(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				stm.setInt("_dotincay", dotincay);
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_capnhatDotincay");
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
			query = "{call " + Constants.NAME_SQL + ".mysp_xoaUser(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_xoaUser");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}
}
