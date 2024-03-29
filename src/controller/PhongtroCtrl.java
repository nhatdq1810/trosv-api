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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import connectSQL.ConnectServer;
import model.PhongtroModel;
import model.TienichModel;
import model.UserModel;
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
		if (conn.openConnection("layTatcaPhongtro")) {
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

					model.setTienich(layTienichPhongtro(model.getId()));
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
		if (conn.openConnection("layPhongtro")) {
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

					model.setTienich(layTienichPhongtro(id));
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
		if (conn.openConnection("layPhongtroUser")) {
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

					model.setTienich(layTienichPhongtro(model.getId()));
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
		if (conn.openConnection("layPhongtroMoi")) {
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

					model.setTienich(layTienichPhongtro(model.getId()));
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
		if (conn.openConnection("layPhongtroHot")) {
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

					model.setTienich(layTienichPhongtro(model.getId()));
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
		if (conn.openConnection("layLuotThichPhongtro")) {
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
		if (conn.openConnection("kiemtraUserThichPhongtro")) {
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
		if (conn.openConnection("layDulieuTimkiemPhongtro")) {
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

	public ArrayList<TienichModel> layTienichPhongtro(int phongtroID) {
		ArrayList<TienichModel> listTienich = new ArrayList<>();
		if (conn.openConnection("layDulieuTimkiemPhongtro")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layTienichPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_phongtroID", phongtroID);
				ResultSet rs1 = stm.executeQuery();
				while (rs1.next()) {
					TienichModel model = new TienichModel();
					model.setId(rs1.getInt("id"));
					model.setTen(rs1.getString("ten"));
					listTienich.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layTienichPhongtro");
				e.printStackTrace();
				return listTienich;
			}
		}
		return listTienich;
	}

	public ArrayList<PhongtroModel> timkiemPhongtro(int loaiPhong, int giatien_min, int giatien_max,
			int giatienTheoNguoi_min, int giatienTheoNguoi_max, int dientich_min, int dientich_max, String truong,
			String nganh, String khoa, String gioitinh, int gioihan, String diachi) {
		ArrayList<PhongtroModel> listPhong = new ArrayList<>();
		if (conn.openConnection("timkiemPhongtro")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_timkiemPhongtro(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
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

					model.setTienich(layTienichPhongtro(model.getId()));
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
		if (conn.openConnection("thongkePTTheoThang")) {
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
		if (conn.openConnection("thongkePTMoiTrenTongso")) {
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

	public HashMap<String, Integer> thongkePTTheoDiachi(String loai, int thang, int gioihan) {
		HashMap<String, Integer> list = new HashMap<>();
		if (conn.openConnection("thongkePTTheoDiachi")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkePTTheoDiachi(?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				if (loai.equals("đường")) {
					stm.setInt("_loai", 1);
				}
				if (loai.equals("phường")) {
					stm.setInt("_loai", 2);
				}
				if (loai.equals("quận")) {
					stm.setInt("_loai", 3);
				}
				if (loai.equals("tp")) {
					stm.setInt("_loai", 4);
				}
				stm.setInt("_thang", thang);
				stm.setInt("_limit", gioihan);
				rs = stm.executeQuery();
				while (rs.next()) {
					list.put(rs.getString("value"), rs.getInt("counter"));
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkePTTheoDiachi");
				e.printStackTrace();
				return list;
			}
		}
		conn.closeConnection();
		return list;
	}

	public HashMap<String, Integer> thongkePTTheoInput(String column, int thang, int gioihan) {
		HashMap<String, Integer> list = new HashMap<>();
		if (conn.openConnection("thongkePTTheoInput")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkePTTheoInput(?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_column", column);
				stm.setInt("_thang", thang);
				stm.setInt("_limit", gioihan);
				rs = stm.executeQuery();
				while (rs.next()) {
					list.put(rs.getString(column), rs.getInt("counter"));
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkePTTheoInput");
				e.printStackTrace();
				return list;
			}
		}
		conn.closeConnection();
		return list;
	}

	public HashMap<Integer, Integer> thongkePTTheoTienVaDientich(String column, int thang, int gioihan) {
		HashMap<Integer, Integer> list = new HashMap<>();
		if (conn.openConnection("thongkePTTheoTienVaDientich")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkePTTheoTienVaDientich(?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_column", column);
				stm.setInt("_thang", thang);
				stm.setInt("_limit", gioihan);
				rs = stm.executeQuery();
				while (rs.next()) {
					list.put(rs.getInt(column), rs.getInt("counter"));
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkePTTheoTienVaDientich");
				e.printStackTrace();
				return list;
			}
		}
		conn.closeConnection();
		return list;
	}

	public ArrayList<PhongtroModel> thongkePTTheoLike(int thang, int gioihan) {
		ArrayList<PhongtroModel> list = new ArrayList<>();
		if (conn.openConnection("thongkePTTheoLike")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkePTTheoLike(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_thang", thang);
				stm.setInt("_limit", gioihan);
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

					model.setDuyet(rs.getInt("duyet"));
					model.setAn(rs.getInt("an"));
					model.setUserID(rs.getInt("userID"));
					model.setCounter(rs.getInt("counter"));

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
					list.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkePTTheoLike");
				e.printStackTrace();
				return list;
			}
		}
		conn.closeConnection();
		return list;
	}

	public ArrayList<PhongtroModel> thongkePTTheoComment(int thang, int gioihan) {
		ArrayList<PhongtroModel> list = new ArrayList<>();
		if (conn.openConnection("thongkePTTheoComment")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkePTTheoComment(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_thang", thang);
				stm.setInt("_limit", gioihan);
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
					model.setDuyet(rs.getInt("duyet"));
					model.setAn(rs.getInt("an"));
					model.setUserID(rs.getInt("userID"));
					model.setCounter(rs.getInt("counter"));

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
					list.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkePTTheoComment");
				e.printStackTrace();
				return list;
			}
		}
		conn.closeConnection();
		return list;
	}

	public int themPhongtro(PhongtroModel model) {
		int result = -999;
		if (conn.openConnection("themPhongtro")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_themPhongtro(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
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
				stm.setString("_ghichu", model.getGhichu());
				stm.setInt("_userID", model.getUserID());
				stm.setString("_nganhangID", model.getNganhangID());
				stm.registerOutParameter("_id", java.sql.Types.INTEGER);
				stm.executeUpdate();
				result = stm.getInt("_id");
				
				for (int i = 0; i < model.getTienich().size(); i++) {
					themTienichPhongtro(model.getTienich().get(i).getId(), result);
				}
				
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_themPhongtro");
				e.printStackTrace();
				return 0;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int themTienichPhongtro(int tienichID, int phongtroID) {
		int result = -999;
		if (conn.openConnection("themTienichPhongtro")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_themTienichPhongtro(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_tienichID", tienichID);
				stm.setInt("_phongtroID", phongtroID);
				result = stm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_themTienichPhongtro");
				e.printStackTrace();
				return 0;
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
		if (conn.openConnection("capnhatHinhanhPhongtro") && success) {

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
		if (conn.openConnection("capnhatPhongtro")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_capnhatPhongtro(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
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
				stm.setString("_ghichu", model.getGhichu());
				stm.setString("_nganhangID", model.getNganhangID());
				stm.executeUpdate();
				
				result = xoaTienichPhongtro(model.getId());
				if (result != -999) {
					for (int i = 0; i < model.getTienich().size(); i++) {
						themTienichPhongtro(model.getTienich().get(i).getId(), model.getId());
					}
					result = 1;
				}
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
		if (conn.openConnection("thichPhongtro")) {
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

	public int xetduyetPT(PhongtroModel[] listPT, String[] listReason, int duyet) {
		int result = -999;
		if (conn.openConnection("xetduyetPT")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_xetduyetPT(?,?)}";
			for (int i = 0; i < listPT.length; i++) {
				try {
					stm = conn.getConn().prepareCall(query);
					stm.setInt("_phongtroID", listPT[i].getId());
					stm.setInt("_duyet", duyet);
					result = stm.executeUpdate();
					if (result != 0 && duyet == -1) {
						String subject = "";
						String noidung = "";
						String reason = Character.toUpperCase(listReason[listPT[i].getId()].charAt(0))
								+ listReason[listPT[i].getId()].substring(1);
						DecimalFormat formatter = new DecimalFormat("###,###");
						UserCtrl userCtrl = new UserCtrl();
						UserModel user = userCtrl.layThongtinUserID(listPT[i].getUserID());
						subject = "không duyệt phòng trọ";
						noidung = "Chào <strong>" + user.getUsername() + "</strong>," + "<p>Phòng trọ của bạn</p>"
								+ "<ul><li>Địa chỉ: <strong>" + listPT[i].getDiachi()
								+ "</strong></li><li>Diện tích: <strong>" + listPT[i].getDientich()
								+ " m<sup>2</sup></strong></li><li>Giá thuê nguyên phòng: <strong>"
								+ formatter.format(listPT[i].getGiatien())
								+ " VNĐ</strong></li><li>Giá thuê từng người: <strong>"
								+ formatter.format(listPT[i].getGiatienTheoNguoi())
								+ " VNĐ</strong></li></ul><p>Đã không được duyệt vì lý do: <strong style='color:red;'>"
								+ reason
								+ "</strong></p><p><a href=\"http://localhost:4200/home\">troSV</a> chân thành cám ơn !</p>";
						EmailCtrl emailCtrl = new EmailCtrl();
						String userEmail = user.getEmail();
						if (user.getEmail().indexOf("gg-") > -1 || user.getEmail().indexOf("fb-") > -1) {
							userEmail = user.getEmail().substring(3, user.getEmail().length());
						}
						emailCtrl.sendEmail(userEmail, subject, noidung);
					} else {
						if (result == 0) {
							break;
						}
					}
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
		if (conn.openConnection("anPT")) {
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
		if (conn.openConnection("xoaPhongtro")) {
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

	public int adminXoaPhongtro(PhongtroModel[] listPT, String[] listReason) {
		int result = -999;
		for (int i = 0; i < listPT.length; i++) {
			result = xoaPhongtro(listPT[i].getId());
			if (result != -999) {
				String subject = "";
				String noidung = "";
				String reason = Character.toUpperCase(listReason[listPT[i].getId()].charAt(0))
						+ listReason[listPT[i].getId()].substring(1);
				DecimalFormat formatter = new DecimalFormat("###,###");
				UserCtrl userCtrl = new UserCtrl();
				UserModel user = userCtrl.layThongtinUserID(listPT[i].getUserID());
				subject = "xóa phòng trọ";
				noidung = "Chào <strong>" + user.getUsername() + "</strong>," + "<p>Phòng trọ của bạn</p>"
						+ "<ul><li>Địa chỉ: <strong>" + listPT[i].getDiachi() + "</strong></li><li>Diện tích: <strong>"
						+ listPT[i].getDientich() + " m<sup>2</sup></strong></li><li>Giá thuê nguyên phòng: <strong>"
						+ formatter.format(listPT[i].getGiatien())
						+ " VNĐ</strong></li><li>Giá thuê từng người: <strong>"
						+ formatter.format(listPT[i].getGiatienTheoNguoi())
						+ " VNĐ</strong></li></ul><p>Đã bị xóa vì lý do: <strong style='color:red;'>" + reason
						+ "</strong></p><p><a href=\"http://localhost:4200/home\">troSV</a> chân thành cám ơn !</p>";
				EmailCtrl emailCtrl = new EmailCtrl();
				String userEmail = user.getEmail();
				if (user.getEmail().indexOf("gg-") > -1 || user.getEmail().indexOf("fb-") > -1) {
					userEmail = user.getEmail().substring(3, user.getEmail().length());
				}
				emailCtrl.sendEmail(userEmail, subject, noidung);
			} else {
				break;
			}
		}
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

		if (conn.openConnection("xoaHinhanhPhongtro") && responseCode == 200) {
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
	
	public int xoaTienichPhongtro(int phongtroID) {
		int result = -999;
		if (conn.openConnection("xoaTienichPhongtro")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_xoaTienichPhongtro(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_phongtroID", phongtroID);
				stm.executeUpdate();
				result = 1;
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_xoaTienichPhongtro");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int boThichPhongtro(int id, int userID) {
		int result = -999;
		if (conn.openConnection("boThichPhongtro")) {
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