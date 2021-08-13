import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

public class Main {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {

		entityManagerFactory = Persistence.createEntityManagerFactory("test");
		entityManager = entityManagerFactory.createEntityManager();
		Main m = new Main();

		m.addPerson();

		/*
		 * TypedQuery<Informations> querry = entityManager.
		 * createQuery("select e from Informations e Join e.dane p where p.logIn = ?1",
		 * Informations.class); querry.setParameter(1, "topik"); Informations result =
		 * querry.getSingleResult(); System.out.println(result.getImie());
		 * System.out.println(result.getNazwisko());
		 */

		// List<Informations> person = querry.getResultList();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Informations> query = builder.createQuery(Informations.class);
		Root<Informations> guy = query.from(Informations.class);
		Join<Dane, Informations> join = guy.join("Login");

		// Path<Object> login = guy.get("imie");

		query.select(guy).where(builder.and(builder.equal(join, "topik")));

		TypedQuery<Informations> q = entityManager.createQuery(query);
		List<Informations> person = q.getResultList();

		for (Informations informations : person) {
			System.out.println(informations.getImie());
			System.out.println(informations.getNazwisko());
			System.out.println(informations.getWiek());
			System.out.println();
			System.out.println(informations.getDane().getLogIn());
			System.out.println(informations.getDane().getPassword());

		}

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
		// entityManager.refresh(per1);
	}
}