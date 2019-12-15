package udemy.hibernate.advance.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Manager.class).addAnnotatedClass(Address.class).buildSessionFactory();
		
		try (Session session = sessionFactory.openSession()) {
			
			session.beginTransaction();

			Manager user = new Manager();
			
			Address address = new Address("Kanpur", "Uttar Pradesh", 208001);
			
			user.setAddress(address);
			
			//session.persist(employee);
			session.save(user);
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
