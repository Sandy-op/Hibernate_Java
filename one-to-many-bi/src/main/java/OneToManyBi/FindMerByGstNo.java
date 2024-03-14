package OneToManyBi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerByGstNo {
	public static void main(String[] args) {
		System.out.println("Enter Merchant's gst_no.: ");
		String gstno = new Scanner(System.in).next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from Merchant m where m.gst_number=?1";
		Query q = manager.createQuery(jpql);
		q.setParameter(1, gstno);
		
		List<Merchant> mer = q.getResultList();
		
		if (mer.size() > 0) {
			for(Merchant m:mer) {
				System.out.println(m);
			}
		}else {
			System.err.println("No merchant present with this gst_number..!");
		}
	}
}
