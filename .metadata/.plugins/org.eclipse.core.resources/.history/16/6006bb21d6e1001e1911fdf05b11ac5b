package org.jsp.manytooneuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveQuesAndAns {
	public static void main(String[] args) {
		QuestionData data = new QuestionData();
		data.setPostedBy("Satish");
		data.setQuestion("What is Hibernate ?");

		AnswerData a1 = new AnswerData();
		a1.setAnswredBy("Sandy");
		a1.setAnswer("It is a lightweight framework");
		a1.setQuestion(data);

		AnswerData a2 = new AnswerData();
		a2.setAnswredBy("Pandy");
		a2.setAnswer("It is a Opensource framework");
		a2.setQuestion(data);

		AnswerData a3 = new AnswerData();
		a3.setAnswredBy("Chinu");
		a3.setAnswer("It is an ORM tool");
		a3.setQuestion(data);

		AnswerData a4 = new AnswerData();
		a4.setAnswredBy("Shristi");
		a4.setAnswer("It is used to achive  Object ralational mapping");
		a4.setQuestion(data);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		manager.persist(a1);
		manager.persist(a2);
		manager.persist(a3);
		manager.persist(a4);
		transaction.begin();
		transaction.commit();
	}
}
