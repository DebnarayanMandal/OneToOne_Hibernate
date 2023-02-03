package Controller;

import java.util.Scanner;

import Dao.DAO;
import Dto.AadherCard;
import Dto.Person;

public class Insert {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person person = new Person();
		person.setName(sc.next());
		person.setGender(sc.next());
		AadherCard aadharCard = new AadherCard();
		aadharCard.setNumber(sc.nextLong());
		aadharCard.setAddress(sc.next());
		sc.close();
		person.setAadharCard(aadharCard);
		DAO dao = new DAO();
		dao.create(person, aadharCard);
	}
}


