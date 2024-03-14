package org.jsp.HibernateDemo;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the User id to update the info.-");
		int id = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
//		Configuration cfg = new Configuration().configure();
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session s = factory.openSession();
		User e = s.get(User.class, id);//persistent state
		if(e != null) {
			e.setName("Srivalli");
			e.setPhone(9931111111L);
			e.setEmail("Srivalli@pushpa.com");
			e.setPassword("Srivalli@pushpa");
			Transaction t = s.beginTransaction();
			t.commit();
		}
		else{
			System.err.println("Invalid Employee Id..!");
		}
		sc.close();
		
	}
}

