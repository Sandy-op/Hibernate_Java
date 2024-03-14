package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchByName {
	public static void main(String[] args) {
		System.out.println("Enter Merchant name: ");
		String name = new Scanner(System.in).next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from Merchant m where m.name=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, name);
		
		List<Merchant> mer = q.getResultList();
		
		if (mer.size() > 0) {
			for(Merchant m:mer) {
				System.out.println(m);
			}
		}else {
			System.err.println("No merchant present with this name..!");
		}
	}
}
