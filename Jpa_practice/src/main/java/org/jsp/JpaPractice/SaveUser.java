package org.jsp.JpaPractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser {
	public static void main(String[] args) {
		UserId userId = new UserId();
		userId.setEmial("xyz@gmail.com");
		userId.setPhone(9999);
		
		User user = new User();
		user.setName("ABC");
		user.setPassword("Abc123");
		user.setUserId(userId);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		manager.persist(user);
		transaction.begin();
		transaction.commit();
		
	}
}
