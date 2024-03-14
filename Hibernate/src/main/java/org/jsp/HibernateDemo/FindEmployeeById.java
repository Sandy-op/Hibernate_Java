package org.jsp.HibernateDemo;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FindEmployeeById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee id to print the info.-");
		int id = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Employee e = s.get(Employee.class, id);
		if(e != null) {
			System.out.println("Employee id: " +e.getId());
			System.out.println("Employee Name: " +e.getName());
			System.out.println("Employee Salary: " +e.getSalary());
			System.out.println("Employee PhoneNo: " +e.getPhone());
			System.out.println("Employee Designation: " +e.getDesg());
		}
		else {
			System.err.println("Invalid Employee Id: ");
		}
		sc.close();
		
	}

}
