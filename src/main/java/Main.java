import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		new GUI();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Dane dane = new Dane();

		dane.setDane1("Przyk³adowe dane1");
		dane.setDane2("Przyk³adowe dane2");

		//entityManager.getTransaction().begin();
		//entityManager.persist(dane);
		//entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}