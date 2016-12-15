package model;

public class ListInfo {
	private PhongtroModel[] listPT;
	private String[] listReason;
	private UserModel[] listUser;

	public PhongtroModel[] getListPT() {
		return listPT;
	}

	public void setListPT(PhongtroModel[] listPT) {
		this.listPT = listPT;
	}

	public String[] getListReason() {
		return listReason;
	}

	public void setListReason(String[] listReason) {
		this.listReason = listReason;
	}

	public UserModel[] getListUser() {
		return listUser;
	}

	public void setListUser(UserModel[] listUser) {
		this.listUser = listUser;
	}

}
