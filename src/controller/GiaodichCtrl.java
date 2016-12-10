package controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectSQL.ConnectServer;
import model.GiaodichModel;
import model.NganhangModel;
import model.PhongtroModel;
import resources.Constants;

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
		if (conn.openConnection("layGiaodich")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layGiaodich(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_nganhangID", nganhangID);
				rs = stm.executeQuery();
				while (rs.next()) {
					GiaodichModel model = new GiaodichModel();
					model.setNganhangID_gui(rs.getString("nganhangID_gui"));
					model.setNganhangID_nhan(rs.getString("nganhangID_nhan"));
					model.setPhongtroID(rs.getInt("phongtroID"));
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
		if (conn.openConnection("layGiaodichGui")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layGiaodichGui(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_nganhangID_gui", nganhangID_gui);
				rs = stm.executeQuery();
				while (rs.next()) {
					GiaodichModel model = new GiaodichModel();
					model.setNganhangID_gui(rs.getString("nganhangID_gui"));
					model.setNganhangID_nhan(rs.getString("nganhangID_nhan"));
					model.setPhongtroID(rs.getInt("phongtroID"));
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
		if (conn.openConnection("layGiaodichNhan")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layGiaodichNhan(?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_nganhangID_nhan", nganhangID_nhan);
				rs = stm.executeQuery();
				while (rs.next()) {
					GiaodichModel model = new GiaodichModel();
					model.setNganhangID_gui(rs.getString("nganhangID_gui"));
					model.setNganhangID_nhan(rs.getString("nganhangID_nhan"));
					model.setPhongtroID(rs.getInt("phongtroID"));
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

	public ArrayList<NganhangModel> thongkeGDGui(int thang, int gioihan) {
		ArrayList<NganhangModel> listModel = new ArrayList<>();
		if (conn.openConnection("thongkeGDGui")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkeGDGui(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_thang", thang);
				stm.setInt("_limit", gioihan);
				rs = stm.executeQuery();
				while (rs.next()) {
					NganhangModel result = new NganhangModel();
					result.setId(rs.getString("id"));
					result.setUsername(rs.getString("username"));
					result.setPassword(rs.getString("password"));
					result.setHoten(rs.getString("hoten"));
					result.setCmnd(rs.getString("cmnd"));
					result.setDiachi(rs.getString("diachi"));
					result.setSodt(rs.getString("sodt"));
					result.setTien(rs.getInt("tien"));
					result.setCounter(rs.getInt("counter"));
					listModel.add(result);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkeGDGui");
				e.printStackTrace();
				return listModel;
			}
		}
		conn.closeConnection();
		return listModel;
	}
	
	public ArrayList<NganhangModel> thongkeGDNhan(int thang, int gioihan) {
		ArrayList<NganhangModel> listModel = new ArrayList<>();
		if (conn.openConnection("thongkeGDNhan")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkeGDNhan(?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setInt("_thang", thang);
				stm.setInt("_limit", gioihan);
				rs = stm.executeQuery();
				while (rs.next()) {
					NganhangModel result = new NganhangModel();
					result.setId(rs.getString("id"));
					result.setUsername(rs.getString("username"));
					result.setPassword(rs.getString("password"));
					result.setHoten(rs.getString("hoten"));
					result.setCmnd(rs.getString("cmnd"));
					result.setDiachi(rs.getString("diachi"));
					result.setSodt(rs.getString("sodt"));
					result.setTien(rs.getInt("tien"));
					result.setCounter(rs.getInt("counter"));
					listModel.add(result);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkeGDNhan");
				e.printStackTrace();
				return listModel;
			}
		}
		conn.closeConnection();
		return listModel;
	}
	
	public ArrayList<PhongtroModel> thongkeGDTheoPT(int thang, int gioihan) {
		ArrayList<PhongtroModel> listModel = new ArrayList<>();
		if (conn.openConnection("thongkeGDTheoPT")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_thongkeGDTheoPT(?,?)}";
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
					model.setWifi(rs.getInt("wifi"));
					model.setChu(rs.getInt("chu"));
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
					listModel.add(model);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_thongkeGDTheoPT");
				e.printStackTrace();
				return listModel;
			}
		}
		conn.closeConnection();
		return listModel;
	}

	public int chuyenTien(GiaodichModel model) {
		int result = -999;
		if (conn.openConnection("chuyenTien")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_chuyenTien(?,?,?,?,?,?)}";
			try {
				stm = conn.getConn().prepareCall(query);
				stm.setString("_id_gui", model.getNganhangID_gui());
				stm.setString("_id_nhan", model.getNganhangID_nhan());
				stm.setString("_ngay", model.getNgay());
				stm.setInt("_tien", model.getTien());
				stm.setInt("_phongtroID", model.getPhongtroID());
				stm.registerOutParameter("_result", java.sql.Types.INTEGER);
				stm.executeUpdate();
				result = stm.getInt("_result");
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_chuyenTien");
				e.printStackTrace();
				return result;
			}
		}
		conn.closeConnection();
		return result;
	}

	public int xoaGiaodich(int nganhangID) {
		int result = -999;
		if (conn.openConnection("xoaGiaodich")) {
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
