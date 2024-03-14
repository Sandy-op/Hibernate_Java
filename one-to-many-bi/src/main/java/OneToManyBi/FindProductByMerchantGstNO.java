package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantGstNO {
	public static void main(String[] args) {
		System.out.println("Enter Merchant's gst_no to find product..");
		String gstno = new Scanner(System.in).next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select m.products from Merchant m where m.gst_number=?1");
		q.setParameter(1, gstno);
		
		List<Products> pro = q.getResultList();
		if (pro.size() > 0) {
			for (Products m : pro) {
				System.out.println(m);
			}
		}else {
			System.err.println("No product found with this merchant's gst_no...!");
		}

	}
}
