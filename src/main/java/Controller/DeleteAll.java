package Controller;

import Dao.DAO;

public class DeleteAll {
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.deleteAll();
	}

}
