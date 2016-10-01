package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GiaodichModel {
	private int userID_gui;
	private int userID_nhan;
	private String ngay;
	private float tien;

	public GiaodichModel() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ngay = sdf.format(new Date());
	}

	public int getUserID_gui() {
		return userID_gui;
	}

	public void setUserID_gui(int userID_gui) {
		this.userID_gui = userID_gui;
	}

	public int getUserID_nhan() {
		return userID_nhan;
	}

	public void setUserID_nhan(int userID_nhan) {
		this.userID_nhan = userID_nhan;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public float getTien() {
		return tien;
	}

	public void setTien(float tien) {
		this.tien = tien;
	}

}
