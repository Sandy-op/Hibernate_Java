package org.jsp.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmp {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		Employee e = new Employee();//Transient state
		
			e.setId(1);
			e.setName("Sandeep Anand");
			e.setDesg("Devops Lead");
			e.setSalary(11100000000L);
			e.setPhone(9931122072L);
			e.setPassword("Sandy@pdp");
//			s.update(e);
			s.saveOrUpdate(e);
			Transaction t = s.beginTransaction();
			t.commit();
		
	}
}

