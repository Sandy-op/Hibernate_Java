package org.jsp.HibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindUserById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the User id to print the info.-");
		int id = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		User e = s.get(User.class, id);
		if(e != null) {
			System.out.println("User id: " +e.getId());
			System.out.println("Name: " +e.getName());
			System.out.println("PhoneNo: " +e.getPhone());
			System.out.println("Email: " +e.getEmail());
			
		}
		else {
			System.err.println("Invalid User Id: ");
		}
		sc.close();
		
	}
}
