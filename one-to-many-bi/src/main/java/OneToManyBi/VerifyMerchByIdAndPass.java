package OneToManyBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyMerchByIdAndPass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Merchant's Id and Password to verify ..");
		int id = sc.nextInt();
		String password = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query  q = manager.createQuery("select m from Merchant m where m.id=?1 and m.password=?2");
		q.setParameter(1,id);
		q.setParameter(2, password);
		try {
			Merchant m = (Merchant)q.getSingleResult();
			System.out.println("Verification Sucessfull");
			System.out.println(m);
		}
		catch(NoResultException e) {
			System.err.println("Invalid Id and Password....!");
		}
	}
}
