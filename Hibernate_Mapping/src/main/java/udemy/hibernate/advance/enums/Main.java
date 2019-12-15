package udemy.hibernate.advance.enums;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Payment.class).buildSessionFactory();
		
		try (Session session = sessionFactory.openSession()) {
			
			session.beginTransaction();

			Payment paymentOne = new Payment("XC67BG7S", 5000, PaymentMode.CASH);
			Payment paymentTwo = new Payment("DSE78SVM", 3900, PaymentMode.CREDIT_CARD);

			session.save(paymentOne);
			session.save(paymentTwo);
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
