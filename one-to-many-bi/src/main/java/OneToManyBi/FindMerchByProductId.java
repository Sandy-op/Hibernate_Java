package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchByProductId {
	public static void main(String[] args) {
		System.out.println("Enter the Product_id to find Merchant: ");
		int id = new Scanner(System.in).nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select p.merchant from Products p where p.id=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, id);

		List<Merchant> merchant = q.getResultList();
		if (merchant.size() > 0) {
			for (Merchant m : merchant) {
				System.out.println(m);
			}
		} else {
			System.err.println("No Merchant found in entered product_id..!");
		}
	}
}
