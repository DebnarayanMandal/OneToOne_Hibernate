package Controller;

import java.util.Scanner;

import Dao.DAO;

public class DeleteById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		dao.deleteById(sc.nextInt());
		sc.close();
	}

}
