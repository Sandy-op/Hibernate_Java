package OneToManyBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyMerchByPhnAndPass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Merchant's PhoneNo. and Password to verify ..");
		long phone= sc.nextLong();
		String password = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query  q = manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1,phone);
		q.setParameter(2, password);
		try {
			Merchant m = (Merchant)q.getSingleResult();
			System.out.println("Verification Sucessfull");
			System.out.println(m);
		}
		catch(NoResultException e) {
			System.err.println("Invalid Phone no. and Password....!");
		}
	}
}
