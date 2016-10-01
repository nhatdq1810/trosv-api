package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhongtroModel {
	private int id;
	private String diachi;
	private float giatien;
	private String ngaydang;
	private int songuoi;
	private float tiencoc;
	private String truong;
	private String nganh;
	private String khoa;
	private int wifi;
	private int chu;
	private String ghichu;
	private int userID;

	public PhongtroModel() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ngaydang = sdf.format(new Date());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public float getGiatien() {
		return giatien;
	}

	public void setGiatien(float giatien) {
		this.giatien = giatien;
	}

	public String getNgaydang() {
		return ngaydang;
	}

	public void setNgaydang(String ngaydang) {
		this.ngaydang = ngaydang;
	}

	public int getSonguoi() {
		return songuoi;
	}

	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}

	public float getTiencoc() {
		return tiencoc;
	}

	public void setTiencoc(float tiencoc) {
		this.tiencoc = tiencoc;
	}

	public String getTruong() {
		return truong;
	}

	public void setTruong(String truong) {
		this.truong = truong;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public int getWifi() {
		return wifi;
	}

	public void setWifi(int wifi) {
		this.wifi = wifi;
	}

	public int getChu() {
		return chu;
	}

	public void setChu(int chu) {
		this.chu = chu;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}
