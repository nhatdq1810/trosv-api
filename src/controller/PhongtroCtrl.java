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
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;

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

	public ArrayList<PhongtroModel> layTatcaPhongtro(int duyet) {
		ArrayList<PhongtroModel> listPhong = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layTatcaPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_duyet", duyet);
				rs = stm.executeQuery();
				while (rs.next()) {
					PhongtroModel model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setLoaiPhong(rs.getInt("loaiPhong"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setGiatienTheoNguoi(rs.getInt("giatienTheoNguoi"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSophong(rs.getInt("sophong"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setTiencocTheoNguoi(rs.getInt("tiencocTheoNguoi"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setDuyet(rs.getInt("duyet"));
					model.setAn(rs.getInt("an"));
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
					if (rs.getString("nganhangID") == null) {
						model.setNganhangID("");
					} else {
						model.setNganhangID(rs.getString("nganhangID"));
					}
					listPhong.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layTatcaPhongtro");
				e.printStackTrace();
				return listPhong;
			}
		}
		conn.closeConnection();
		return listPhong;
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
					model.setId(id);
					model.setLoaiPhong(rs.getInt("loaiPhong"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setGiatienTheoNguoi(rs.getInt("giatienTheoNguoi"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSophong(rs.getInt("sophong"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setTiencocTheoNguoi(rs.getInt("tiencocTheoNguoi"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setDuyet(rs.getInt("duyet"));
					model.setAn(rs.getInt("an"));
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
					if (rs.getString("nganhangID") == null) {
						model.setNganhangID("");
					} else {
						model.setNganhangID(rs.getString("nganhangID"));
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
					model.setLoaiPhong(rs.getInt("loaiPhong"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setGiatienTheoNguoi(rs.getInt("giatienTheoNguoi"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSophong(rs.getInt("sophong"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setTiencocTheoNguoi(rs.getInt("tiencocTheoNguoi"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setDuyet(rs.getInt("duyet"));
					model.setAn(rs.getInt("an"));
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
					if (rs.getString("nganhangID") == null) {
						model.setNganhangID("");
					} else {
						model.setNganhangID(rs.getString("nganhangID"));
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
					model.setLoaiPhong(rs.getInt("loaiPhong"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setGiatienTheoNguoi(rs.getInt("giatienTheoNguoi"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSophong(rs.getInt("sophong"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setTiencocTheoNguoi(rs.getInt("tiencocTheoNguoi"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setDuyet(rs.getInt("duyet"));
					model.setAn(rs.getInt("an"));
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
					if (rs.getString("nganhangID") == null) {
						model.setNganhangID("");
					} else {
						model.setNganhangID(rs.getString("nganhangID"));
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
					model.setLoaiPhong(rs.getInt("loaiPhong"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setGiatienTheoNguoi(rs.getInt("giatienTheoNguoi"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSophong(rs.getInt("sophong"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setTiencocTheoNguoi(rs.getInt("tiencocTheoNguoi"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setDuyet(rs.getInt("duyet"));
					model.setAn(rs.getInt("an"));
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
					if (rs.getString("nganhangID") == null) {
						model.setNganhangID("");
					} else {
						model.setNganhangID(rs.getString("nganhangID"));
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

	public int layLuotThichPhongtro(int id) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layLuotThichPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_phongtroID", id);
				rs = stm.executeQuery();
				if (rs.next()) {
					result = rs.getInt("thich");
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layLuotThichPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int kiemtraUserThichPhongtro(int id, int userID) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_kiemtraUserThichPhongtro(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_phongtroID", id);
				stm.setInt("_userID", userID);
				rs = stm.executeQuery();
				if (rs.next()) {
					result = rs.getInt("_result");
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_kiemtraUserThichPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public ArrayList<PhongtroModel> layDulieuTimkiemPhongtro() {
		ArrayList<PhongtroModel> listPT = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layDulieuTimkiemPhongtro()}";
			try {
				stm = conn.getConn().prepareCall(query);
				rs = stm.executeQuery();
				while (rs.next()) {
					PhongtroModel model = new PhongtroModel();
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
					listPT.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layDulieuTimkiemPhongtro");
				e.printStackTrace();
				return listPT;
			}
		}
		conn.closeConnection();
		return listPT;
	}

	public ArrayList<PhongtroModel> timkiemPhongtro(int loaiPhong, int giatien_min, int giatien_max,
			int giatienTheoNguoi_min, int giatienTheoNguoi_max, int dientich_min, int dientich_max, String truong,
			String nganh, String khoa, String gioitinh, int wifi, int chu, int gioihan, String diachi) {
		ArrayList<PhongtroModel> listPhong = new ArrayList<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_timkiemPhongtro(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_loaiPhong", loaiPhong);
				stm.setInt("_giatien_min", giatien_min);
				stm.setInt("_giatien_max", giatien_max);
				stm.setInt("_giatienTheoNguoi_min", giatienTheoNguoi_min);
				stm.setInt("_giatienTheoNguoi_max", giatienTheoNguoi_max);
				stm.setInt("_dientich_min", dientich_min);
				stm.setInt("_dientich_max", dientich_max);
				stm.setString("_truong", truong);
				stm.setString("_nganh", nganh);
				stm.setString("_khoa", khoa);
				stm.setString("_gioitinh", gioitinh);
				stm.setInt("_wifi", wifi);
				stm.setInt("_chu", chu);
				stm.setInt("_gioihan", gioihan);
				stm.setString("_diachi", diachi);
				rs = stm.executeQuery();
				while (rs.next()) {
					PhongtroModel model = new PhongtroModel();
					model.setId(rs.getInt("id"));
					model.setLoaiPhong(rs.getInt("loaiPhong"));
					model.setDiachi(rs.getString("diachi"));
					model.setGiatien(rs.getInt("giatien"));
					model.setGiatienTheoNguoi(rs.getInt("giatienTheoNguoi"));
					model.setNgaydang(rs.getString("ngaydang"));
					model.setSophong(rs.getInt("sophong"));
					model.setTiencoc(rs.getInt("tiencoc"));
					model.setTiencocTheoNguoi(rs.getInt("tiencocTheoNguoi"));
					model.setDientich(rs.getFloat("dientich"));
					model.setGioitinh(rs.getString("gioitinh"));
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
					model.setDuyet(rs.getInt("duyet"));
					model.setAn(rs.getInt("an"));
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
					if (rs.getString("nganhangID") == null) {
						model.setNganhangID("");
					} else {
						model.setNganhangID(rs.getString("nganhangID"));
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

	public HashMap<Integer, Integer> thongkePTTheoThang(String thangBD, String thangKT) {
		HashMap<Integer, Integer> list = new HashMap<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkePTTheoThang(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_thangBD", thangBD);
				stm.setString("_thangKT", thangKT);
				rs = stm.executeQuery();
				while (rs.next()) {
					list.put(rs.getInt("thangDK"), rs.getInt("countPT"));
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkePTTheoThang");
				e.printStackTrace();
				return list;
			}
		}
		conn.closeConnection();
		return list;
	}

	public HashMap<String, Integer> thongkePTMoiTrenTongso(String thang) {
		HashMap<String, Integer> list = new HashMap<>();
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkePTMoiTrenTongso(?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_thang", thang);
				stm.registerOutParameter("_slPTMoi", Types.INTEGER);
				stm.registerOutParameter("_slPTCu", Types.INTEGER);
				stm.executeQuery();
				list.put("new", stm.getInt("_slPTMoi"));
				list.put("old", stm.getInt("_slPTCu"));
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkePTMoiTrenTongso");
				e.printStackTrace();
				return list;
			}
		}
		conn.closeConnection();
		return list;
	}

	public int themPhongtro(PhongtroModel model) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_themPhongtro(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_loaiPhong", model.getLoaiPhong());
				stm.setString("_diachi", model.getDiachi());
				stm.setInt("_giatien", model.getGiatien());
				stm.setInt("_giatienTheoNguoi", model.getGiatienTheoNguoi());
				stm.setString("_ngaydang", model.getNgaydang());
				stm.setInt("_sophong", model.getSophong());
				stm.setInt("_tiencoc", model.getTiencoc());
				stm.setInt("_tiencocTheoNguoi", model.getTiencocTheoNguoi());
				stm.setFloat("_dientich", model.getDientich());
				stm.setString("_hinhanh", model.getHinhanh());
				stm.setString("_gioitinh", model.getGioitinh());
				stm.setString("_truong", model.getTruong());
				stm.setString("_nganh", model.getNganh());
				stm.setString("_khoa", model.getKhoa());
				stm.setInt("_wifi", model.getWifi());
				stm.setInt("_chu", model.getChu());
				stm.setString("_ghichu", model.getGhichu());
				stm.setInt("_userID", model.getUserID());
				stm.setString("_nganhangID", model.getNganhangID());
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
		if (success) {
			PhongtroModel pt = layPhongtro(id);
			if (!pt.getHinhanh().equals("") && pt.getHinhanh() != null) {
				String deletehash = pt.getHinhanh().split("-")[1];
				xoaHinhanhPhongtro(id, deletehash);
			}
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
			query = "{call " + Constants.NAME_SQL + ".mysp_capnhatPhongtro(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", model.getId());
				stm.setInt("_loaiPhong", model.getLoaiPhong());
				stm.setString("_diachi", model.getDiachi());
				stm.setInt("_giatien", model.getGiatien());
				stm.setInt("_giatienTheoNguoi", model.getGiatienTheoNguoi());
				stm.setString("_ngaydang", model.getNgaydang());
				stm.setInt("_sophong", model.getSophong());
				stm.setInt("_tiencoc", model.getTiencoc());
				stm.setInt("_tiencocTheoNguoi", model.getTiencocTheoNguoi());
				stm.setFloat("_dientich", model.getDientich());
				stm.setString("_gioitinh", model.getGioitinh());
				stm.setString("_truong", model.getTruong());
				stm.setString("_nganh", model.getNganh());
				stm.setString("_khoa", model.getKhoa());
				stm.setInt("_wifi", model.getWifi());
				stm.setInt("_chu", model.getChu());
				stm.setString("_ghichu", model.getGhichu());
				stm.setString("_nganhangID", model.getNganhangID());
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

	public int thichPhongtro(int id, int userID) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thichPhongtro(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_phongtroID", id);
				stm.setInt("_userID", userID);
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thichPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xetduyetPT(int[] listID, int duyet) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_xetduyetPT(?,?)}";
			for (int i = 0; i < listID.length; i++) {
				try {
					stm = conn.getConn().prepareCall(query);
					stm.setInt("_phongtroID", listID[i]);
					stm.setInt("_duyet", duyet);
					result = stm.executeUpdate();

				} catch (SQLException e) {
					System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_xetduyetPT");
					e.printStackTrace();
					return result;
				}
			}
		}
		conn.closeConnection();
		return result;
	}

	public int anPT(int id, int an) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_anPT(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_phongtroID", id);
				stm.setInt("_an", an);
				result = stm.executeUpdate();

			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_anPT");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaPhongtro(int id) {
		int result = -999;
		PhongtroModel pt = layPhongtro(id);
		if (!pt.getHinhanh().equals("")) {
			String deletehash = pt.getHinhanh().split("-")[1];
			xoaHinhanhPhongtro(id, deletehash);
		}
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_xoaPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_id", id);
				stm.executeUpdate();
				result = 1;
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
			con.setRequestProperty("Authorization", Constants.IMG_CLIENTID);
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

	public int boThichPhongtro(int id, int userID) {
		int result = -999;
		if (conn.openConnection()) {
			query = "{call " + Constants.NAME_SQL + ".mysp_boThichPhongtro(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_phongtroID", id);
				stm.setInt("_userID", userID);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_boThichPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}
}