package org.jsp.one2one;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndPanCard {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Person p = new Person();
		p.setName("Bahubali");
		p.setPhone(9931122072L);
		
		PanCard card = new PanCard();
		card.setNumber("CXHPA2718P");
		card.setDob(LocalDate.parse("1974-08-15"));
		card.setPincode(560076);
		
		
		p.setCard(card); //Assigning PanCard to person
		
		manager.persist(p);
		manager.persist(card);
		transaction.begin();
		transaction.commit();
	}
}
