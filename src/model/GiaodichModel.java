package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GiaodichModel {
	private int nganhangID_gui;
	private int nganhangID_nhan;
	private String ngay;
	private int tien;

	public GiaodichModel() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ngay = sdf.format(new Date());
	}

	public int getNganhangID_gui() {
		return nganhangID_gui;
	}

	public void setNganhangID_gui(int nganhangID_gui) {
		this.nganhangID_gui = nganhangID_gui;
	}

	public int getNganhangID_nhan() {
		return nganhangID_nhan;
	}

	public void setNganhangID_nhan(int nganhangID_nhan) {
		this.nganhangID_nhan = nganhangID_nhan;
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
