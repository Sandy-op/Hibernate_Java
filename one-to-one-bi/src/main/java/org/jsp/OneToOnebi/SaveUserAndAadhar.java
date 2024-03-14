package org.jsp.OneToOnebi;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUserAndAadhar {
	public static void main(String[] args) {
		User user = new User();
		user.setName("Sandy");
		user.setPhone(9931122072L);
		
		AadharCard card = new AadharCard ();
		card.setNumber(890504124605L);
		card.setDob(LocalDate.parse("2000-10-13"));
		card.setCity("Hajipur");
		
		
		user.setCard(card);
		card.setUser(user);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		manager.persist(user);
		transaction.begin();
		transaction.commit();
	}
}
