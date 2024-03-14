package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductById {
	public static void main(String[] args) {
		System.out.println("Enter the Product_id to fetch details: ");
		int id = new Scanner(System.in).nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select p from Products p where p.id=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, id);

		List<Products> p = q.getResultList();
		if (p.size() > 0) {
			for (Products m : p) {
				System.out.println(m);
			}
		} else {
			System.err.println("No Product found with given ID..!");
		}
	}
}
