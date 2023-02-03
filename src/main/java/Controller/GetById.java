package Controller;

import java.util.Scanner;

import Dao.DAO;

public class GetById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		dao.readById(sc.nextInt());
		sc.close();
	}

}
