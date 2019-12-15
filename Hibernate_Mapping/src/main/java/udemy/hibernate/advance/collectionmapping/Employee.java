package udemy.hibernate.advance.collectionmapping;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.SortComparator;

import udemy.hibernate.advance.embeddable.Address;
import udemy.hibernate.advance.utils.CustomComparator;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	private String name;
	
	@ElementCollection
	@CollectionTable(name = "projects", joinColumns = @JoinColumn(name="employee_id"))
	@MapKeyColumn(name = "project_name")
	@Column(name = "project_desc")
	@SortComparator(CustomComparator.class)
	private SortedMap<String, String> projects = new TreeMap<>();

	@Embedded // @Embedded is optional here because Address.class is marked with @Embeddable and hibernate automatically infer it
	private Address address;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SortedMap<String, String> getProjects() {
		return projects;
	}

	public void setProjects(SortedMap<String, String> projects) {
		this.projects = projects;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Employee(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Employee() {
		
	}
}
