package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByCategory {
	public static void main(String[] args) {
		System.out.println("Enter Category to Find product: ");
		String brand = new Scanner(System.in).next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select p from Products p where p.category=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, brand);
		
		List<Products> pro = q.getResultList();
		
		if (pro.size() > 0) {
			for(Products m:pro) {
				System.out.println(m);
			}
		}else {
			System.err.println("No Product present with this category..!");
		}
	}
}
