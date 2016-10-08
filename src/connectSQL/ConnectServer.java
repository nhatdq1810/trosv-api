package connectSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import resources.Constants;

public class ConnectServer {
	private Connection conn;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public boolean openConnection() {
		conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class com.mysql.jdbc.Driver not found");
			e.printStackTrace();
			return false;
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + Constants.SERVER_SQL, Constants.USERNAME_SQL, Constants.PASSWORD_SQL);
		} catch (SQLException e) {
			System.out.println("Connect failed!");
			e.printStackTrace();
			return false;
		}

		if (conn != null) {
			System.out.println("Connect successfully");
		} else {
			System.out.println("Connect failed");
			return false;
		}

		return true;
	}

	public boolean closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Cannot close connection");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
