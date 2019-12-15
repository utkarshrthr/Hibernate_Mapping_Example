package udemy.hibernate.advance.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "INSTRUCTOR")
public class Instructor extends Person {

	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Instructor() {
		
	}

	public Instructor(String firstName, int age, int salary) {
		super(firstName, age);
		this.salary = salary;
	}
}
