package org.jsp.JpaPractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestHCL {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Person p = new Person(); //Transient State
		p.setAge(25);
		p.setName("Acde");
		p.setPhone(999);

		manager.persist(p); //Persistent State
		transaction.begin();
		transaction.commit();

		p.setAge(45);
		p.setName("Tomar");
		p.setPhone(77798);
		transaction.begin();
		transaction.commit();

		p.setAge(35);
		p.setName("Vamika Kohli");
		p.setPhone(7689);
		transaction.begin();
		transaction.commit();

		manager.detach(p);//detached state

		p.setAge(38);
		p.setName("Rajput Sharma");
		p.setPhone(66545);
		transaction.begin();
		transaction.commit();

	}
}
