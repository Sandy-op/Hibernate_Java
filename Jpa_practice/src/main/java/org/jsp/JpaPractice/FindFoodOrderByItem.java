package org.jsp.JpaPractice;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindFoodOrderByItem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter food_item to find food order ..");
		String item= sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q =  manager.createQuery("select f from FoodOrder f where f.food_item=?1");
		q.setParameter(1,item);
		
		try {
			FoodOrder food = (FoodOrder) q.getSingleResult();
			System.out.println(food);
		}
		catch(NoResultException e) {
			System.err.println("Invalid Food item details");
		}
	}
}
