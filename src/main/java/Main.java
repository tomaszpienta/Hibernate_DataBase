import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
//		new GUI();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Dane osoba1 = new Dane();
		Informations osoba2 = new Informations();
		
		
		
		osoba1.setLogIn("topik");
		osoba1.setPassword("koty");
		
		osoba2.setImie("Tomasz");
		osoba2.setNazwisko("Kopytko");
		osoba2.setWiek(27);
		osoba2.setDane(osoba1);
		
		
		//dane.setDane1("Przyk³adowe dane1");
		//dane.setDane2("Przyk³adowe dane2");

		entityManager.getTransaction().begin();
		entityManager.persist(osoba1);
		entityManager.persist(osoba2);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}