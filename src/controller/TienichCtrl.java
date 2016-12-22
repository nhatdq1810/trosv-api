package controller;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectSQL.ConnectServer;
import model.TienichModel;
import resources.Constants;

public class TienichCtrl {

	private String query;
	private ResultSet rs;
	private CallableStatement stm;
	private ConnectServer conn;

	public TienichCtrl() {
		conn = new ConnectServer();
	}

	public ArrayList<TienichModel> layTatcaTienich() {
		ArrayList<TienichModel> listTienich = new ArrayList<>();
		if (conn.openConnection("layTatcaTienich")) {
			query = "{call " + Constants.NAME_SQL + ".mysp_layTatcaTienich()}";
			try {
				stm = conn.getConn().prepareCall(query);
				rs = stm.executeQuery();
				while (rs.next()) {
					TienichModel result = new TienichModel();
					result.setId(rs.getInt("id"));
					result.setTen(rs.getString("ten"));
					listTienich.add(result);
				}
			} catch (SQLException e) {
				System.out.println("Cannot call " + Constants.NAME_SQL + ".mysp_layTatcaTienich");
				e.printStackTrace();
				return listTienich;
			}
		}
		conn.closeConnection();
		return listTienich;
	}
}
