package fujinet.action.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect_database {

	public static String getUSER_NAME() {
		return USER_NAME;
	}

	public static String getPASSWORD() {
		return PASSWORD;
	}

	private static String USER_NAME = "sa";
	private static String PASSWORD = "Abc123456";

	public static Connection getConnection(String dbURL, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}

}
