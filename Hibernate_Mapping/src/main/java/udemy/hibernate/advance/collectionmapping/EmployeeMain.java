package udemy.hibernate.advance.collectionmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import udemy.hibernate.advance.embeddable.Address;

public class EmployeeMain {
	
	public static void main(String[] args) {
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class).buildSessionFactory();
		
		try (Session session = sessionFactory.openSession()) {
			
			session.beginTransaction();
			
			Employee employee = new Employee(1L, "Arnub");
			
			employee.getProjects().put("abc", "def");
			employee.getProjects().put("ghi", "jkl");
			employee.getProjects().put("mno", "pqr");
			employee.getProjects().put("stu", "vwx");
			employee.getProjects().put("yza", "bcd");
			
			Address address = new Address("Kanpur", "Uttar Pradesh", 208001);
			
			employee.setAddress(address);
			
			//session.persist(employee);
			session.save(employee);
			
			session.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
