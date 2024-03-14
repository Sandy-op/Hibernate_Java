package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMercId {
	public static void main(String[] args) {
		System.out.println("Enter the Merchant_id to find Product: ");
		int id = new Scanner(System.in).nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select m.products from Merchant m where m.id=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, id);

		List<Products> pro = q.getResultList();
		if (pro.size() > 0) {
			for (Products m : pro) {
				System.out.println(m);
			}
		} else {
			System.err.println("No Product found in entered Merchant_id..!");
		}
	}

}
