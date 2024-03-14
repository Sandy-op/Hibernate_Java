package org.jsp.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class SaveEmployee {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("Alok Mall");
		e.setDesg("Data Analyst");
		e.setPhone(1111111111L);
		e.setSalary(2500000);
		e.setPassword("Alok@123");
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		int id = (Integer) s.save(e);
		
		
		Transaction t = s.beginTransaction();
		t.commit();
		System.out.println("Employee saved with Id: "+id);
		
		
	}

}
