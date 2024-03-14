package org.jsp.HibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteUserById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user id to delete user info.-");
		int id = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		User e = s.get(User.class, id);//persistent state
		if(e != null) {
			s.delete(e);
			Transaction t = s.beginTransaction();
			t.commit();
			System.out.println("User details deleted..");
		}
		else{
			System.err.println("Invalid User Id..!");
		}
		sc.close();
		
	}
}
