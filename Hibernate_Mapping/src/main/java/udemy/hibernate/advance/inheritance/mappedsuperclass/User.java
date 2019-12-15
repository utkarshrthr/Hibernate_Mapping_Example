package udemy.hibernate.advance.inheritance.mappedsuperclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class User extends Person {
	
	private String course;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public User() {
		
	}

	public User(String firstName, int age, String course) {
		super(firstName, age);
		this.course = course;
	}
}
