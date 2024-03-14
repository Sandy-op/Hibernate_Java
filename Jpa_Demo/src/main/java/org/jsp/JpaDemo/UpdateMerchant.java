package org.jsp.JpaDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchant {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Merchant m = manager.find(Merchant.class, 1);
		m.setPassword("Anushka@123");
		m.setPhone(555999183);
		m.setEmail("Virat.Rcb@gmail.com");
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
	}
}
