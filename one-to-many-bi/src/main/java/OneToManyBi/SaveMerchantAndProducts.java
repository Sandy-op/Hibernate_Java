package OneToManyBi;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchantAndProducts {
	public static void main(String[] args) {
		Merchant m = new Merchant();
		m.setGst_number("ABCD123");
		m.setName("Sandy");
		m.setPhone(993112);
		m.setPassword("Abc@123");

		Products p = new Products();
		p.setBrand("Samsung");
		p.setName("Smartphone");
		p.setCategory("Electronics");
		p.setDescription("6Gb RAM");
		p.setCost(13500);
		p.setMerchant(m);

		Products p1 = new Products();
		p1.setBrand("HP");
		p1.setName("Laptop");
		p1.setCategory("Electronics");
		p1.setDescription("8Gb RAM");
		p1.setCost(135000);
		p1.setMerchant(m);

		m.setProducts(Arrays.asList(p, p1));

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		manager.persist(m);
		transaction.begin();
		transaction.commit();

	}

}