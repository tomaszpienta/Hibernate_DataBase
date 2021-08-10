import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {

		entityManagerFactory = Persistence.createEntityManagerFactory("test");
		entityManager = entityManagerFactory.createEntityManager();
		Main m = new Main();

		m.addPerson();
		TypedQuery<Informations> querry = entityManager
				.createQuery("select e from Informations e where e.wiek=22", Informations.class);
		Informations person = querry.getSingleResult();
//		List<Informations> person = querry.getResultList();
//		for (Informations informations : person) {
//			System.out.println(((Informations) person).getImie());
//			System.out.println(((Informations) person).getNazwisko());
//			System.out.println(((Informations) person).getWiek());
//		}
		System.out.println(person.getImie());
		System.out.println(person.getNazwisko());
		System.out.println(person.getWiek());

		entityManager.close();
		entityManagerFactory.close();
	}

	public void addPerson() {
		addPersonCredentials("topik", "password", "Tomasz", "Kopytko", 27);
		addPersonCredentials("myszor", "kotki", "Kacper", "Baraniak", 22);
		addPersonCredentials("mgit", "sprint", "Bart³omiej", "Nowacki", 30);

	}

	public void addPersonCredentials(String login, String password, String imie, String nazwisko, int wiek) {
		Dane person = new Dane();
		person.setLogIn(login);
		person.setPassword(password);

		Informations per1 = new Informations();
		per1.setImie(imie);
		per1.setNazwisko(nazwisko);
		per1.setWiek(wiek);
		per1.setDane(person);

		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.persist(per1);
		entityManager.getTransaction().commit();
	}
}