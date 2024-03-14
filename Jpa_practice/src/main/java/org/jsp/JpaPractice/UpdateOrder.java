package org.jsp.JpaPractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateOrder {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		FoodOrder order = manager.find(FoodOrder.class, 1);
		order.setCost(180);
		order.setFood_items("Paneer Biryani");
		transaction.begin();
		transaction.commit();

	}
}
