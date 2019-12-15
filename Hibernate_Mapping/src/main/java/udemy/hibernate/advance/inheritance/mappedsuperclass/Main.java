package udemy.hibernate.advance.inheritance.mappedsuperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		try(Session session = sessionFactory.openSession() ) {
			session.beginTransaction();
			User user = new User("Ravi", 25, "Perl");
			Instructor instructor = new Instructor("Raman", 30, 25000);
			session.save(user);
			session.save(instructor);
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
