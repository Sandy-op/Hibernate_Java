package org.jsp.HibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindAllEmployees {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> q = s.createQuery("select e from Employee e");
		List<Employee> emps = q.getResultList();
		if(emps.size() > 0) {
			for(Employee e:emps) {
			System.out.println("Employee id: " +e.getId());
			System.out.println("Employee Name: " +e.getName());
			System.out.println("Employee Salary: " +e.getSalary());
			System.out.println("Employee PhoneNo: " +e.getPhone());
			System.out.println("Employee Designation: " +e.getDesg());
			System.out.println("----------------------------------------------------");
		}
		}
		else {
			System.err.println("Cannot find Employee");
		}
		
		
	}
}