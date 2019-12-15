package udemy.hibernate.advance.inheritance.mappedsuperclass;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	private String firstName;
	
	private int age;
	
	public Person() {
	
	}

	public Person(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
