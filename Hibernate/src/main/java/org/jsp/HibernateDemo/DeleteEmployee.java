package org.jsp.HibernateDemo;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee id to delete the info.-");
		int id = sc.nextInt();
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		Employee e = s.get(Employee.class, id);//persistent state
		if(e != null) {
			s.delete(e);
			Transaction t = s.beginTransaction();
			t.commit();
		}
		else{
			System.err.println("Invalid Employee Id..!");
		}
		sc.close();
		
	}
}
