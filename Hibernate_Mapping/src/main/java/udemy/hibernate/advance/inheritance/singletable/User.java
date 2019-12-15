package udemy.hibernate.advance.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "USER")
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
