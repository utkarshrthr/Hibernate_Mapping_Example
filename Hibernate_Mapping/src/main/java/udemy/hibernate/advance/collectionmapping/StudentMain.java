package udemy.hibernate.advance.collectionmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		try(Session session = sessionFactory.openSession() ) {
			session.beginTransaction();
			Student student = new Student("Utkarsh", 123);
			
			student.getImages().add("one.png");
			student.getImages().add("two.png");
			student.getImages().add("three.png");
			student.getImages().add("three.png");
			
			student.getPhotos().put("one", "summer");
			student.getPhotos().put("two", "winter");
			student.getPhotos().put("three", "autumn");
			student.getPhotos().put("four", "spring");
			
			student.getCourses().add("Java");
			student.getCourses().add("Spring");
			student.getCourses().add("Hibernate");
			student.getCourses().add("AngularJS");
			
			student.getResult().put("Java", "A");
			student.getResult().put("Spring", "B");
			student.getResult().put("Hibernate", "B");
			student.getResult().put("AngularJS", "C");
			
			session.save(student);
			
			session.getTransaction().commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
}
