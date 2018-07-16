package fujinet.action.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fujinet.action.model.bean.customer_info;

public class T01_DAO {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=customer;"
			+ "integratedSecurity=true";
	private Connection conn = null;
	private Statement stm = null;

	public T01_DAO() {
		conn = connect_database.getConnection(DB_URL, connect_database.getUSER_NAME(), connect_database.getPASSWORD());
		try {
			stm = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkLogin(String username, String password) {
		try {
			ResultSet rs = stm.executeQuery(
					"select * from customer_info where username = '" + username + "' , password ='" + password + "'");
			while (rs.next()) {
				if (username.equals(rs.getString(6)) && password.equals(rs.getString(7))) {
					rs.close();
					return true;
				}
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public customer_info takeCustomer_Info(String username) {
		customer_info Customer_info = null;
		try {
			ResultSet rs = stm.executeQuery("select * from customer_info where username = '" + username + "'");
			if (rs.next()) {
				Customer_info = new customer_info();
				Customer_info.setId(rs.getInt(1));
				Customer_info.setName(rs.getString(2));
				Customer_info.setSex(rs.getString(3));
				Customer_info.setAddress(rs.getString(4));
				Customer_info.setBirthday(rs.getString(5));
				Customer_info.setUsername(rs.getString(6));
				Customer_info.setPassword(rs.getString(7));
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Customer_info;
	}

}
