package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.AadherCard;
import Dto.Person;

public class DAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("h");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void create(Person p, AadherCard ad) {
		et.begin();
		em.persist(p);
		em.persist(ad);
		et.commit();
	}

	public void createMul(ArrayList<Person> l) {
		for (Person p : l) {
			et.begin();
			em.persist(p);
			em.persist(p.getAadharCard());
			et.commit();
		}
	}

	public void readById(int n) {
		Person person = em.find(Person.class, n);
		System.err.println(person.getId() + " " + person.getName() + " " + person.getGender());
		AadherCard aadharCard = person.getAadharCard();
		System.err.println(aadharCard.getId() + " " + aadharCard.getNumber() + " " + aadharCard.getAddress());
	}

	public void readMul(int a[]) {
		for (int i : a) {
			Person person = em.find(Person.class, i);
			System.err.println(person.getId() + " " + person.getName() + " " + person.getGender());
			AadherCard aadharCard = person.getAadharCard();
			System.err.println(aadharCard.getId() + " " + aadharCard.getNumber() + " " + aadharCard.getAddress());
		}
	}

	public void readAll() {
		Query q = em.createQuery("select p from Person p");
		List<Person> p1 = q.getResultList();
		for (Person p2 : p1) {
			System.err.println(p2.getId() + " " + p2.getName() + " " + p2.getGender());
			AadherCard aadharCard = p2.getAadharCard();
			System.err.println(aadharCard.getId() + " " + aadharCard.getNumber() + " " + aadharCard.getAddress());
		}
	}

	public void updateId(Person person, AadherCard aadharCard) {
		et.begin();
		em.merge(person);
		em.merge(aadharCard);
		et.commit();
	}

	public void updateMul(ArrayList<Person> l) {
		for (Person person : l) {
			et.begin();
			em.merge(person);
			em.merge(person.getAadharCard());
			et.commit();
		}
	}

	public void deleteById(int n) {
		Person person = em.find(Person.class, n);
		AadherCard aadharCard = person.getAadharCard();
		et.begin();
		em.remove(person);
		em.remove(aadharCard);
		et.commit();
	}

	public void deleteMul(int a[]) {
		for (int i : a) {
			Person person = em.find(Person.class, i);
			AadherCard aadharCard = person.getAadharCard();
			et.begin();
			em.remove(person);
			em.remove(aadharCard);
			et.commit();
		}
	}

	public void deleteAll() {
		Query q1 = em.createQuery("delete from Person");
		Query q2 = em.createQuery("delete from AdharCard");
		et.begin();
		q1.executeUpdate();
		q2.executeUpdate();
		et.commit();
	}


}
