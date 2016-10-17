package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import connectSQL.ConnectServer;
import model.PhongtroModel;
import resources.Constants;

public class PhongtroCtrl {
	private String query;
	private ResultSet rs;
	private CallableStatement stm;
	private ConnectServer conn;

	public PhongtroCtrl() {
		conn = new ConnectServer();
	}

	public ArrayList<PhongtroModel> layTatcaPhongtro() {
		ArrayList<PhongtroModel> listPT = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layTatcaPhongtro()}";
			try {
				stm = conn.getConn().prepareCall(query);
				rs = stm.executeQuery();
				while (rs.next()) {
					PhongtroModel model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSonguoi(rs.getInt("songuoi"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setUserID(rs.getInt("userID"));
					if (rs.getString("hinhanh") == null) {
						model.setHinhanh("");
					} else {
						model.setHinhanh(rs.getString("hinhanh"));
					}
					if (rs.getString("truong") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("truong"));
					}
					if (rs.getString("nganh") == null) {
						model.setNganh("");
					} else {
						model.setNganh(rs.getString("nganh"));
					}
					if (rs.getString("khoa") == null) {
						model.setKhoa("");
					} else {
						model.setKhoa(rs.getString("khoa"));
					}
					if (rs.getString("ghichu") == null) {
						model.setGhichu("");
					} else {
						model.setGhichu(rs.getString("ghichu"));
					}
					listPT.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layTatcaPhongtro");
				e.printStackTrace();
				return listPT;
			}
		}
		conn.closeConnection();
		return listPT;
	}

	public PhongtroModel layPhongtro(int id) {
		PhongtroModel model = null;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				rs = stm.executeQuery();
				if (rs.next()) {
					model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSonguoi(rs.getInt("songuoi"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setUserID(rs.getInt("userID"));
					if (rs.getString("hinhanh") == null) {
						model.setHinhanh("");
					} else {
						model.setHinhanh(rs.getString("hinhanh"));
					}
					if (rs.getString("truong") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("truong"));
					}
					if (rs.getString("nganh") == null) {
						model.setNganh("");
					} else {
						model.setNganh(rs.getString("nganh"));
					}
					if (rs.getString("khoa") == null) {
						model.setKhoa("");
					} else {
						model.setKhoa(rs.getString("khoa"));
					}
					if (rs.getString("ghichu") == null) {
						model.setGhichu("");
					} else {
						model.setGhichu(rs.getString("ghichu"));
					}
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layPhongtro");
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
			query = "{call " + Constants.NAME_SQL + ".mysp_layPhongtroUser(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_userID", userID);
				rs = stm.executeQuery();
				while (rs.next()) {
					PhongtroModel model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSonguoi(rs.getInt("songuoi"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setUserID(userID);
					if (rs.getString("hinhanh") == null) {
						model.setHinhanh("");
					} else {
						model.setHinhanh(rs.getString("hinhanh"));
					}
					if (rs.getString("truong") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("truong"));
					}
					if (rs.getString("nganh") == null) {
						model.setNganh("");
					} else {
						model.setNganh(rs.getString("nganh"));
					}
					if (rs.getString("khoa") == null) {
						model.setKhoa("");
					} else {
						model.setKhoa(rs.getString("khoa"));
					}
					if (rs.getString("ghichu") == null) {
						model.setGhichu("");
					} else {
						model.setGhichu(rs.getString("ghichu"));
					}
					listPhong.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layPhongtroUser");
				e.printStackTrace();
				return listPhong;
			}
		}
		conn.closeConnection();
		return listPhong;
	}

	public ArrayList<PhongtroModel> layPhongtroMoi(int gioihan) {
		ArrayList<PhongtroModel> listPT = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layPhongtroMoi(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_gioihan", gioihan);
				rs = stm.executeQuery();
				while (rs.next()) {
					PhongtroModel model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSonguoi(rs.getInt("songuoi"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setUserID(rs.getInt("userID"));
					if (rs.getString("hinhanh") == null) {
						model.setHinhanh("");
					} else {
						model.setHinhanh(rs.getString("hinhanh"));
					}
					if (rs.getString("truong") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("truong"));
					}
					if (rs.getString("nganh") == null) {
						model.setNganh("");
					} else {
						model.setNganh(rs.getString("nganh"));
					}
					if (rs.getString("khoa") == null) {
						model.setKhoa("");
					} else {
						model.setKhoa(rs.getString("khoa"));
					}
					if (rs.getString("ghichu") == null) {
						model.setGhichu("");
					} else {
						model.setGhichu(rs.getString("ghichu"));
					}
					listPT.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layPhongtroMoi");
				e.printStackTrace();
				return listPT;
			}
		}
		conn.closeConnection();
		return listPT;
	}

	public ArrayList<PhongtroModel> layPhongtroHot(int gioihan) {
		ArrayList<PhongtroModel> listPT = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layPhongtroHot(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_gioihan", gioihan);
				rs = stm.executeQuery();
				while (rs.next()) {
					PhongtroModel model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSonguoi(rs.getInt("songuoi"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setUserID(rs.getInt("userID"));
					if (rs.getString("hinhanh") == null) {
						model.setHinhanh("");
					} else {
						model.setHinhanh(rs.getString("hinhanh"));
					}
					if (rs.getString("truong") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("truong"));
					}
					if (rs.getString("nganh") == null) {
						model.setNganh("");
					} else {
						model.setNganh(rs.getString("nganh"));
					}
					if (rs.getString("khoa") == null) {
						model.setKhoa("");
					} else {
						model.setKhoa(rs.getString("khoa"));
					}
					if (rs.getString("ghichu") == null) {
						model.setGhichu("");
					} else {
						model.setGhichu(rs.getString("ghichu"));
					}
					listPT.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layPhongtroHot");
				e.printStackTrace();
				return listPT;
			}
		}
		conn.closeConnection();
		return listPT;
	}

	public ArrayList<PhongtroModel> timkiemPhongtro(int giatien_min, int giatien_max, String truong, String nganh,
			String gioitinh) {
		ArrayList<PhongtroModel> listPhong = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_timkiemPhongtro(?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_giatien_min", giatien_min);
				stm.setInt("_giatien_max", giatien_max);
				stm.setString("_truong", truong);
				stm.setString("_nganh", nganh);
				stm.setString("_gioitinh", gioitinh);
				rs = stm.executeQuery();
				while (rs.next()) {
					PhongtroModel model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSonguoi(rs.getInt("songuoi"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setUserID(rs.getInt("userID"));
					if (rs.getString("hinhanh") == null) {
						model.setHinhanh("");
					} else {
						model.setHinhanh(rs.getString("hinhanh"));
					}
					if (rs.getString("truong") == null) {
						model.setTruong("");
					} else {
						model.setTruong(rs.getString("truong"));
					}
					if (rs.getString("nganh") == null) {
						model.setNganh("");
					} else {
						model.setNganh(rs.getString("nganh"));
					}
					if (rs.getString("khoa") == null) {
						model.setKhoa("");
					} else {
						model.setKhoa(rs.getString("khoa"));
					}
					if (rs.getString("ghichu") == null) {
						model.setGhichu("");
					} else {
						model.setGhichu(rs.getString("ghichu"));
					}
					listPhong.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_timkiemPhongtro");
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
			query = "{call " + Constants.NAME_SQL + ".mysp_themPhongtro(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_diachi", model.getDiachi());
				stm.setInt("_giatien", model.getGiatien());
				stm.setString("_ngaydang", model.getNgaydang());
				stm.setInt("_songuoi", model.getSonguoi());
				stm.setInt("_tiencoc", model.getTiencoc());
				stm.setFloat("_dientich", model.getDientich());
				stm.setString("_gioitinh", model.getGioitinh());
				stm.setString("_truong", model.getTruong());
				stm.setString("_nganh", model.getNganh());
				stm.setString("_khoa", model.getKhoa());
				stm.setInt("_wifi", model.getWifi());
				stm.setInt("_chu", model.getChu());
				stm.setString("_ghichu", model.getGhichu());
				stm.setInt("_userID", model.getUserID());
				stm.registerOutParameter("_id", java.sql.Types.INTEGER);
				stm.executeUpdate();
				result = stm.getInt("_id");
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_themPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int capnhatHinhanhPhongtro(int id, InputStream fileStream) {
		int result = -999;
		boolean success = false;
		String url = Constants.IMG_URL + "upload";
		URL obj;
		HttpsURLConnection con;
		String hinhanh = "";
		try {
			obj = new URL(url);
			con = (HttpsURLConnection) obj.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", Constants.IMG_CLIENTID);
			con.setRequestProperty("Content-Type", "application/octet-stream");

			byte[] bytes = new byte[1024];
			int read = 0;

			con.setDoOutput(true);
			OutputStream wr = con.getOutputStream();
			while ((read = fileStream.read(bytes)) != -1) {
				wr.write(bytes, 0, read);
			}
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject respJSON = new JSONObject(response.toString());
			success = respJSON.getBoolean("success");
			if (success) {
				JSONObject resp = new JSONObject(respJSON.get("data").toString());
				hinhanh = resp.get("link") + "-" + resp.get("deletehash");
			}

		} catch (IOException e) {
			System.out.println("Error capnhatHinhanhPhongtro");
			e.printStackTrace();
			return result;
		}

		if (conn.openConnection() && success) {
			query = "{call " + Constants.NAME_SQL + ".mysp_capnhatHinhanhPhongtro(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				stm.setString("_hinhanh", hinhanh);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_capnhatHinhanhPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;

	}

	public int capnhatPhongtro(PhongtroModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_capnhatPhongtro(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", model.getId());
				stm.setString("_diachi", model.getDiachi());
				stm.setInt("_giatien", model.getGiatien());
				stm.setString("_ngaydang", model.getNgaydang());
				stm.setInt("_songuoi", model.getSonguoi());
				stm.setInt("_tiencoc", model.getTiencoc());
				stm.setFloat("_dientich", model.getDientich());
				stm.setString("_gioitinh", model.getGioitinh());
				stm.setString("_truong", model.getTruong());
				stm.setString("_nganh", model.getNganh());
				stm.setString("_khoa", model.getKhoa());
				stm.setInt("_wifi", model.getWifi());
				stm.setInt("_chu", model.getChu());
				stm.setString("_ghichu", model.getGhichu());
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_capnhatPhongtro");
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
			query = "{call " + Constants.NAME_SQL + ".mysp_xoaPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_xoaPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaHinhanhPhongtro(int id, String deletehash) {
		int result = -999;
		int responseCode = -999;
		String url = Constants.IMG_URL + "image/" + deletehash;
		URL obj;
		HttpsURLConnection con;
		try {
			obj = new URL(url);
			con = (HttpsURLConnection) obj.openConnection();

			con.setRequestMethod("DELETE");
			con.setRequestProperty("Authorization", "Client-ID f9ea705cdc1e4c9");
			con.setDoOutput(true);
			con.connect();

			responseCode = con.getResponseCode();

		} catch (IOException e) {
			System.out.println("Error xoaHinhanhPhongtro");
			e.printStackTrace();
			return result;
		}

		if (conn.openConnection() && responseCode == 200) {
			query = "{call " + Constants.NAME_SQL + ".mysp_xoaHinhanhPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_xoaHinhanhPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}
}
