package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantById {
	public static void main(String[] args) {
		System.out.println("Enter the merchant_id to fetch details: ");
		int id = new Scanner(System.in).nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from Merchant m where m.id=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, id);

		List<Merchant> mer = q.getResultList();
		if (mer.size() > 0) {
			for (Merchant m : mer) {
				System.out.println(m);
			}
		} else {
			System.err.println("No Merchant found with given ID..!");
		}
	}
}
