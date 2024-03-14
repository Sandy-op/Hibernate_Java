package org.jsp.HibernateDemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByPhoneNoAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PhoneNo. and Password to verify");
		long phone = sc.nextLong();
		String password = sc.next();
		
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Query<Employee> q = s.createQuery("select e from Employee e where e.phone = ?1 and e.password =:ps");
		q.setParameter(1, phone);
		q.setParameter("ps",password);
		
		try {
			Employee e = q.getSingleResult();
			System.out.println("Verification Sucess");
			System.out.println("Employee id: " +e.getId());
			System.out.println("Employee Name: " +e.getName());
			System.out.println("Employee Salary: " +e.getSalary());
			System.out.println("Employee PhoneNo: " +e.getPhone());
			System.out.println("Employee Designation: " +e.getDesg());
			System.out.println("----------------------------------------------------");
		}
		catch(NoResultException e) {
			System.err.println("Invalid PhoneNo. and Password");
		}
		sc.close();
	}
}
