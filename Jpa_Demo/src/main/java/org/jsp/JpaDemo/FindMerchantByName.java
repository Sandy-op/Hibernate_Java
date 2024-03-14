package org.jsp.JpaDemo;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByName {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Merchant's Name");
	String name = sc.next();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	Query q = manager.createQuery("select m from Merchant m where m.name=?1");
	q.setParameter(1, name);
	List<Merchant> merchant = q.getResultList();
	if(merchant.size() > 0) {
		for(Merchant m: merchant) {
			System.out.println(m);
			System.out.println("-------------------------------------------");
		}
	}
	else {
		System.err.println("No merchant found with this name....!");
	}
	
	}
}
