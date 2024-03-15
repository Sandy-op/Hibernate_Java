package org.jsp.JpaPractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchUserById {
	public static void main(String[] args) {
		UserId userId = new UserId();
		userId.setEmial("xyz@gmail.com");
		userId.setPhone(9999);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		User user = manager.find(User.class, userId);
		if(user != null) {
			System.out.println(user);
		}
		else {
		System.err.println("Invalid email and phone no...!");
		}
	}
}
