package org.jsp.onetomanyuni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDeptAndEmps {
	public static void main(String[] args) {
		Department d = new Department();
		d.setName("Developer");
		d.setLocation("Btm layout");
		
		Employee e1 = new Employee();
		e1.setName("ABC");
		e1.setDesg("Developer");
		e1.setSalary(45678);
		
		Employee e2 = new Employee();
		e2.setName("XYZ");
		e2.setDesg("Senior Developer");
		e2.setSalary(45678);
		
		Employee e3 = new Employee();
		e3.setName("PQR");
		e3.setDesg("Developer");
		e3.setSalary(45676);
		
		List<Employee> emps = new ArrayList<Employee> ();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		d.setEmps(emps);//Assigning Employee to Department
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		manager.persist(d);
		transaction.begin();
		transaction.commit();
		
		
				
		
	}
}
