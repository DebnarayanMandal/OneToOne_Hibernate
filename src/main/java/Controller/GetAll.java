package Controller;

import Dao.DAO;

public class GetAll {
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.readAll();
	}

}
