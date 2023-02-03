package Controller;
import java.util.Scanner;

import Dao.DAO;
import Dto.AadherCard;
import Dto.Person;

public class Update {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person person = new Person();
		person.setId(sc.nextInt());
		person.setName(sc.next());
		person.setGender(sc.next());
		AadherCard aadharCard = new AadherCard();
		aadharCard.setId(sc.nextInt());
		aadharCard.setNumber(sc.nextLong());
		aadharCard.setAddress(sc.next());
		person.setAadharCard(aadharCard);
		sc.close();
		DAO dao = new DAO();
		dao.updateId(person, aadharCard);
	}

}
