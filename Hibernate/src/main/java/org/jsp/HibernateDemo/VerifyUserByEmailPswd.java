package org.jsp.HibernateDemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyUserByEmailPswd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email and password for verification");
		String email = sc.next();
		String password = sc.next();
		
		Session s = new Configuration().configure().buildSessionFactory().openSession();
	
		Query<User> q = s.createQuery("select e from User e where e.email=?1 and e.password =:ps");
		q.setParameter(1, email);
		q.setParameter("ps",password);
		
		try {
			User e = q.getSingleResult();
			System.out.println("Verification using email Sucess");
			System.out.println("User id: " +e.getId());
			System.out.println("Name: " +e.getName());
			System.out.println("PhoneNo: " +e.getPhone());
			System.out.println("Email id: "+e.getEmail());
			System.out.println("----------------------------------------------------");
		}
		catch(NoResultException e) {
			System.err.println("Invalid PhoneNo. and Password");
		}
		sc.close();
	}
}
