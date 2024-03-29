package org.jsp.one2one;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;

public class FindCardByNumberAndDob {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PanNo. and Dob to verify ..");
		String number= sc.next();
		LocalDate dob = LocalDate.parse(sc.next());
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q =  manager.createQuery("select c from PanCard c where c.number=?1 and c.dob=?2");
		q.setParameter(1,number);
		q.setParameter(2, dob);
		
		try {
			PanCard card = (PanCard) q.getSingleResult();
			System.out.println(card);
		}
		catch(NoResultException e) {
			System.err.println("Invalid PanCard details");
		}
	}
}
