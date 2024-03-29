package org.jsp.HibernateDemo;

import java.util.Scanner;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByPhn {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user's phoneno. to fetch details: ");
		long phone = sc.nextLong();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery("select e from User e where e.phone=:N");
		q.setParameter("N", phone);
		try {
			User e = q.getSingleResult();
			System.out.println("User id: " +e.getId());
			System.out.println("Name: " +e.getName());
			System.out.println("PhoneNo: " +e.getPhone());
			System.out.println("Email id: "+e.getEmail());
			System.out.println("----------------------------------------------------");
		}
		catch(NoResultException e) {
			System.err.println("Invalid user name...");
		}
		sc.close();
	}
}
