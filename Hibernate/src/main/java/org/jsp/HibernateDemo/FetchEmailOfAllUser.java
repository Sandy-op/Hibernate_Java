package org.jsp.HibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchEmailOfAllUser {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery("select e from User e");
		List<User> user = q.getResultList();
		if(user.size() > 0) {
			for(User e:user) {
			System.out.println("Name: " +e.getName());
			System.out.println("PhoneNo: " +e.getEmail());
			System.out.println("----------------------------------------------------");
		}
		}
		else {
			System.err.println("Cannot find User");
		}
		
		
	}
}
