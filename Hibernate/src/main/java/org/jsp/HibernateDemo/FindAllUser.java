package org.jsp.HibernateDemo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindAllUser {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery("select e from User e");
		List<User> emps = q.getResultList();
		if(emps.size() > 0) {
			for(User e:emps) {
			System.out.println("Employee id: " +e.getId());
			System.out.println("Employee Name: " +e.getName());
			System.out.println("Employee PhoneNo: " +e.getPhone());
			System.out.println("Employee Designation: " +e.getEmail());
			System.out.println("----------------------------------------------------");
		}
		}
		else {
			System.err.println("Cannot find User");
		}
		
		
	}
}
