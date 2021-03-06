package udemy.hibernate.advance.inheritance.mappedsuperclass;

import javax.persistence.Entity;

import udemy.hibernate.advance.inheritance.tableperclass.Person;

@Entity
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
