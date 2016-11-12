package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GiaodichModel {
	private String nganhangID_gui;
	private String nganhangID_nhan;
	private int phongtroID;
	private String ngay;
	private int tien;

	public GiaodichModel() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ngay = sdf.format(new Date());
	}

	public String getNganhangID_gui() {
		return nganhangID_gui;
	}

	public void setNganhangID_gui(String nganhangID_gui) {
		this.nganhangID_gui = nganhangID_gui;
	}

	public String getNganhangID_nhan() {
		return nganhangID_nhan;
	}

	public void setNganhangID_nhan(String nganhangID_nhan) {
		this.nganhangID_nhan = nganhangID_nhan;
	}

	public int getPhongtroID() {
		return phongtroID;
	}

	public void setPhongtroID(int phongtroID) {
		this.phongtroID = phongtroID;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public int getTien() {
		return tien;
	}

	public void setTien(int tien) {
		this.tien = tien;
	}

}
