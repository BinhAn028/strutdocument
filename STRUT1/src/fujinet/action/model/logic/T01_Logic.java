package fujinet.action.model.logic;

import fujinet.action.model.bean.customer_info;
import fujinet.action.model.dao.T01_DAO;

public class T01_Logic {
	private T01_DAO t01_DAO;

	public T01_Logic() {
		t01_DAO = new T01_DAO();
	}

	public boolean checkLogin(String username, String password) {
		if (username == null) {
			return false;
		}
		if (password == null) {
			return false;
		}
		return t01_DAO.checkLogin(username, password);
	}

	public customer_info takeCustomer_Info(String username) {
		if (username == null) {
			return null;
		} else {
			return t01_DAO.takeCustomer_Info(username);
		}
	}
}
