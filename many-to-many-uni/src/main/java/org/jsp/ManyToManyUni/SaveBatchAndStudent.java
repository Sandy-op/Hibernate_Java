package org.jsp.ManyToManyUni;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveBatchAndStudent {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("Sunil Chettri");
		s1.setPhone(99999);
		s1.setPerc(97.5);

		Student s2 = new Student();
		s2.setName("Ronaldo");
		s2.setPhone(88888);
		s2.setPerc(90);

		Student s3 = new Student();
		s3.setName("Messi");
		s3.setPhone(77777);
		s3.setPerc(85);

		Batch b1 = new Batch();
		b1.setSubject("Core Java");
		b1.setTrainer("Keshva sir");
		b1.setBatch_code("CJD-A2");

		Batch b2 = new Batch();
		b2.setSubject("Adv. Java");
		b2.setTrainer("Satish sir");
		b2.setBatch_code("ADD-A5");

		Batch b3 = new Batch();
		b3.setSubject("SQl");
		b3.setTrainer("Sarath sir");
		b3.setBatch_code("SQD-A3");

		Batch b4 = new Batch();
		b4.setSubject("SQl");
		b4.setTrainer("Sweta maam");
		b4.setBatch_code("SQD-A4");

		b1.setStudents(Arrays.asList(s1, s2, s3));
		b2.setStudents(Arrays.asList(s1, s2, s3));
		b3.setStudents(Arrays.asList(s1, s2));
		b4.setStudents(Arrays.asList(s2, s3));

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		manager.persist(b4);
		transaction.begin();
		transaction.commit();

	}
}