package fujinet.action.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fujinet.action.model.bean.customer_info;

public class customer_info_DAO {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=customer;"
			+ "integratedSecurity=true";

	public static void PrintList(List<customer_info> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId() + "--" + list.get(i).getName());
		}
	}

	private static List<customer_info> takeListFromResultSet(ResultSet rs) throws SQLException {
		List<customer_info> list = new ArrayList<customer_info>();
		while (rs.next()) {
			customer_info cus_info = new customer_info();
			cus_info.setId(rs.getInt(1));
			cus_info.setName(rs.getString(2));
			cus_info.setSex(rs.getString(3));
			cus_info.setAddress(rs.getString(4));
			cus_info.setBirthday(rs.getString(5));
			list.add(cus_info);

		}
		return list;
	}

	public static List<customer_info> takeCustomer_InfoList() throws SQLException {
		List<customer_info> list = new ArrayList<customer_info>();
		Connection conn = null;
		conn = connect_database.getConnection(DB_URL, connect_database.getUSER_NAME(),
				connect_database.getPASSWORD());
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customer_info");
		list = takeListFromResultSet(rs);
		conn.close();
		return list;
	}

	public static void main(String args[]) throws SQLException {
		List<customer_info> list =takeCustomer_InfoList();
		PrintList(list);
	}
}
