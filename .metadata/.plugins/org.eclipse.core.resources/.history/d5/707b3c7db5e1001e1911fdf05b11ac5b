package org.jsp.JpaDemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindName {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createNamedQuery("findName");
		List<String> names = q.getResultList();
		for(String name:names) {
			System.out.println(name);
		}
	
	}
}
