package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantIdAndPass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Merchant's id and Password to find product..");
		int id = sc.nextInt();
		String password = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select m.products from Merchant m where m.id=?1 and m.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		
		List<Products> pro = q.getResultList();
		if (pro.size() > 0) {
			for (Products m : pro) {
				System.out.println(m);
			}
		}else {
			System.err.println("No product found with this merchant id. and password..!");
		}

	}
}
