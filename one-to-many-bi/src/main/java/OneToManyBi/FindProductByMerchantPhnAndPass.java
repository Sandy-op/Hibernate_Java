package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantPhnAndPass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Merchant's phone and Password to find product..");
		long phone = sc.nextLong();
		String password = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select m.products from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		
		List<Products> pro = q.getResultList();
		if (pro.size() > 0) {
			for (Products m : pro) {
				System.out.println(m);
			}
		}else {
			System.err.println("No product found with this merchant phone and password..!");
		}

	}
}
