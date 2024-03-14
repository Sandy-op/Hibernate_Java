package org.jsp.JpaDemo;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchantByMerge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the merchant's id, name, gst_no, email, phone..");
		Merchant m = new Merchant();
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setGst_number(sc.next());
		m.setEmail(sc.next());
		m.setPhone(sc.nextLong());
		m.setPassword(sc.next());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		m = manager.merge(m);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
	}
}
