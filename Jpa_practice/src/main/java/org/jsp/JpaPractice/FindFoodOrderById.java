package org.jsp.JpaPractice;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindFoodOrderById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Order id to get info...");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		FoodOrder f = manager.find(FoodOrder.class, id);
		if(f != null) {
			System.out.println(f);
		}
		else {
			System.out.println("you havae entered an invalid order id ");
		}
	}
}