package controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Random;

import connectSQL.ConnectServer;
import model.UserModel;
import resources.Constants;

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

	public UserModel layThongtinUserID(int id) {
		UserModel result = null;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layThongtinUserID(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				rs = stm.executeQuery();
				if (rs.next()) {
					result = new UserModel();
					result.setId(id);
					result.setUsername(rs.getString("username"));
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
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layThongtinUserID");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public HashMap<Integer, Integer> thongkeUserTheoThang(String thangBD, String thangKT) {
		HashMap<Integer, Integer> list = new HashMap<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkeUserTheoThang(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_thangBD", thangBD);
				stm.setString("_thangKT", thangKT);
				rs = stm.executeQuery();
				while (rs.next()) {
					list.put(rs.getInt("thangDK"), rs.getInt("countUser"));
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkeUserTheoThang");
				e.printStackTrace();
				return list;
			}
		}
		conn.closeConnection();
		return list;
	}

	public HashMap<String, Integer> thongkeUserMoiTrenTongso(String thang) {
		HashMap<String, Integer> list = new HashMap<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkeUserMoiTrenTongso(?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_thang", thang);
				stm.registerOutParameter("_slUserMoi", Types.INTEGER);
				stm.registerOutParameter("_slUserCu", Types.INTEGER);
				stm.executeQuery();
				list.put("new", stm.getInt("_slUserMoi"));
				list.put("old", stm.getInt("_slUserCu"));
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkeUserMoiTrenTongso");
				e.printStackTrace();
				return list;
			}
		}
		conn.closeConnection();
		return list;
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
				if (rs.next()) {
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
			query = "{call " + Constants.NAME_SQL + ".mysp_themUser(?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", model.getUsername());
				stm.setString("_password", model.getPassword());
				stm.setString("_hoten", model.getHoten());
				stm.setString("_email", model.getEmail());
				stm.setString("_facebook", model.getFacebook());
				stm.registerOutParameter("_result", Types.INTEGER);
				stm.executeUpdate();
				result = stm.getInt("_result");
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
				stm.registerOutParameter("_result", Types.INTEGER);
				stm.executeUpdate();
				result = stm.getInt("_result");

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

	public int phuchoiPassword(String username) {
		int result = -999;
		String email = "";
		String newPassword = "";
		String noidung = "";
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_phuchoiPassword(?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_username", username);
				stm.registerOutParameter("_result", Types.INTEGER);
				stm.registerOutParameter("_email", Types.VARCHAR);
				stm.registerOutParameter("_username_out", Types.VARCHAR);
				stm.executeUpdate();
				result = stm.getInt("_result");
				username = stm.getString("_username_out");
				email = stm.getString("_email");
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_phuchoiPassword");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		if (result != -999 && result != 0) {
			StringBuilder strBuilder = new StringBuilder();
			Random r = new Random();
			int[] usedIndex = new int[15];
			while (strBuilder.length() < 14) {
				int index = (int) (r.nextFloat() * Constants.RESET_PASSWORD.length());
				if (usedIndex[index] != 1) {
					usedIndex[index] = 1;
					strBuilder.append(Constants.RESET_PASSWORD.charAt(index));
				}
			}
			newPassword = strBuilder.toString();
			noidung = "Chào <strong>" + username + "</strong>," + "<p>Mật khẩu mới của bạn</p>" + "<p><strong> "
					+ newPassword
					+ "</strong></p><p> Đăng nhập vào <a href=\"http://localhost:4200/home\">troSV</a> và thay đổi mật khẩu lại ngay bây giờ"
					+ "</p><p> <a href=\"http://localhost:4200/home\">troSV</a> chân thành cám ơn !</p>";
			EmailCtrl emailCtrl = new EmailCtrl();
			emailCtrl.sendEmail(email, noidung);
			result = capnhatPassword(username, newPassword);
		}
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
