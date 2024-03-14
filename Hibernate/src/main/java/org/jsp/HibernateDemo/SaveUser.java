package org.jsp.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {
	public static void main(String[] args) {
		User e = new User();
		e.setName("DemoForDelete");
		e.setPhone(99311L);
		e.setEmail("Demo@gmail.com");
		e.setPassword("Demo@Demo");
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		int id = (Integer) s.save(e);
		
		
		Transaction t = s.beginTransaction();
		t.commit();
		System.out.println("Employee saved with Id: "+id);
		
		
	}
}
