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
		  .createQuery("select e from Informations e Join e.dane p where p.logIn = ?1",
		  Informations.class); querry.setParameter(1, "topik"); Informations result =
		  querry.getSingleResult(); System.out.println(result.getFirstName());
		  System.out.println(result.getLastName());
		 

			/*
			 * // List<Informations> person = querry.getResultList();
			 * 
			 * CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			 * 
			 * CriteriaQuery<Informations> query = builder.createQuery(Informations.class);
			 * Root<Informations> guy = query.from(Informations.class); Root<Dane> login =
			 * query.from(Dane.class);
			 * 
			 * // javax.persistence.criteria.Predicate equal =
			 * builder.equal(guy.get("imie"), login.get("logIn"));
			 * 
			 * // query.multiselect(guy.get("imie")).where(equal,
			 * builder.equal(login.get("logIn"), guy.get("imie")));
			 * 
			 * TypedQuery<Informations> q = entityManager.createQuery(query);
			 * List<Informations> person = q.getResultList();
			 * 
			 * for (Informations informations : person) {
			 * System.out.println(informations.getImie());
			 * System.out.println(informations.getNazwisko());
			 * System.out.println(informations.getWiek()); System.out.println();
			 * System.out.println(informations.getDane().getLogIn());
			 * System.out.println(informations.getDane().getPassword()); }
			 * 
			 * Work out how to implement JPQL into Criteria API (same querry)
			 */

		entityManager.close();
		entityManagerFactory.close();
	}

	public void addPerson() {
		addPersonCredentials("topik", "password", "Tomasz", "Kopytko", 27);
		addPersonCredentials("myszor", "kotki", "Kacper", "Baraniak", 22);
		addPersonCredentials("mgit", "sprint", "Bart³omiej", "Nowacki", 30);

	}

	public void addPersonCredentials(String login, String password, String name, String surrname, int age) {
		Dane person = new Dane();
		person.setLogIn(login);
		person.setPassword(password);

		Informations per1 = new Informations();
		per1.setFirstName(name);
		per1.setLastName(surrname);
		per1.setAge(age);
		per1.setData(person);

		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.persist(per1);
		entityManager.getTransaction().commit();
		// entityManager.refresh(per1);
	}
}