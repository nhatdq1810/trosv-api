package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.PhongtroModel;
import resources.Constants;
import connectSQL.ConnectServer;

public class PhongtroCtrl {
	private String query;
	private ResultSet rs;
	private CallableStatement stm;
	private ConnectServer conn;

	public PhongtroCtrl() {
		conn = new ConnectServer();
	}

	public PhongtroModel layPhongtro(int id) {
		PhongtroModel model = null;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_layPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				rs = stm.executeQuery();
				if (rs.next()) {
					model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getFloat("giatien"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSonguoi(rs.getInt("songuoi"));
					model.setTiencoc(rs.getFloat("tiencoc"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setUserID(rs.getInt("userID"));
					if (rs.getString("truong") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("truong"));
					}
					if (rs.getString("nganh") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("nganh"));
					}
					if (rs.getString("khoa") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("khoa"));
					}
					if (rs.getString("ghichu") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("ghichu"));
					}
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_layPhongtro");
				e.printStackTrace();
				return model;
			}
		}
		conn.closeConnection();
		return model;
	}

	public ArrayList<PhongtroModel> layPhongtroUser(int userID) {
		ArrayList<PhongtroModel> listPhong = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_layPhongtroUser(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_userID", userID);
				rs = stm.executeQuery();
				while (rs.next()) {
					PhongtroModel model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getFloat("giatien"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSonguoi(rs.getInt("songuoi"));
					model.setTiencoc(rs.getFloat("tiencoc"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setUserID(userID);
					if (rs.getString("truong") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("truong"));
					}
					if (rs.getString("nganh") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("nganh"));
					}
					if (rs.getString("khoa") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("khoa"));
					}
					if (rs.getString("ghichu") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("ghichu"));
					}
					listPhong.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_layPhongtroUser");
				e.printStackTrace();
				return listPhong;
			}
		}
		conn.closeConnection();
		return listPhong;
	}

	public int themPhongtro(PhongtroModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_themPhongtro(?,?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_diachi", model.getDiachi());
				stm.setFloat("_giatien", model.getGiatien());
				stm.setString("_ngaydang", model.getNgaydang());
				stm.setInt("_songuoi", model.getSonguoi());
				stm.setFloat("_tiencoc", model.getTiencoc());
				stm.setString("_truong", model.getTruong());
				stm.setString("_nganh", model.getNganh());
				stm.setString("_khoa", model.getKhoa());
				stm.setInt("_wifi", model.getWifi());
				stm.setInt("_chu", model.getChu());
				stm.setString("_ghichu", model.getGhichu());
				stm.setInt("_userID", model.getUserID());
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_themPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int themHinhanhPhongtro(String tenFile, InputStream fileStream) {
		int result = -999;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd.hh:mm:ss");
		String ngaydang = sdf.format(new Date());
		int lastIndex = tenFile.lastIndexOf(".");
		String fileLocation = "/src/images/" + tenFile.substring(0, lastIndex + 1) + ngaydang
				+ tenFile.substring(lastIndex);
		System.out.println(fileLocation);
		// if (conn.openConnection()) {
		// query = "{call " + Constants.nameSQL +
		// ".mysp_themHinhanhPhongtro(?)}";
		// try {
		// stm = conn.getConn().prepareCall(query);
		// stm.setString("_hinhanh", "");
		// result = stm.executeUpdate();
		// } catch (SQLException e) {
		// System.out.println("Cannot call " + Constants.nameSQL +
		// ".mysp_themHinhanhPhongtro");
		// e.printStackTrace();
		// return result;
		// }
		// }
		// conn.closeConnection();
		return result;
	}

	public int capnhatPhongtro(PhongtroModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_capnhatPhongtro(?,?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", model.getId());
				stm.setString("_diachi", model.getDiachi());
				stm.setFloat("_giatien", model.getGiatien());
				stm.setString("_ngaydang", model.getNgaydang());
				stm.setInt("_songuoi", model.getSonguoi());
				stm.setFloat("_tiencoc", model.getTiencoc());
				stm.setString("_truong", model.getTruong());
				stm.setString("_nganh", model.getNganh());
				stm.setString("_khoa", model.getKhoa());
				stm.setInt("_wifi", model.getWifi());
				stm.setInt("_chu", model.getChu());
				stm.setString("_ghichu", model.getGhichu());
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_capnhatPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaPhongtro(int id) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.nameSQL + ".mysp_xoaPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.nameSQL + ".mysp_xoaPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public static void main(String[] args) {
		PhongtroCtrl ctrl = new PhongtroCtrl();
		InputStream fileStream = new InputStream() {

			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		ctrl.themHinhanhPhongtro("abc.asd.jpeg", fileStream);
	}
}
