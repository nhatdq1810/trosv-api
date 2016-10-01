package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentModel {
	private int id;
	private String noidung;
	private String ngay;
	private int userID;
	private int phongtroID;

	public CommentModel() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ngay = sdf.format(new Date());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getPhongtroID() {
		return phongtroID;
	}

	public void setPhongtroID(int phongtroID) {
		this.phongtroID = phongtroID;
	}
}
