package org.jsp.JpaDemo;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.hibernate.query.Query;

public class VerifyMerchant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Merchant's PhoneNo. and Password to verify ..");
		long phone= sc.nextLong();
		String password = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q =  (Query) manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1,phone);
		q.setParameter(2, password);
		try {
			Merchant m = (Merchant)q.getSingleResult();
			System.out.println("Verification Sucessful");
			System.out.println(m);
		}
		catch(NoResultException e) {
			System.err.println("Invalid Phone no. and Password....!");
		}
		
		
	}
}
