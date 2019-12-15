package udemy.hibernate.advance.collectionmapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="roll_no")
	private int rollNo;
	
	/*@Column(name = "file_name")
	@ElementCollection()
	@CollectionTable(name = "images", joinColumns = @JoinColumn(name = "student_id"))
	private Set<String> images = new HashSet<String>();*/

	@Column(name = "file_name") // column in 'images' table storing image-names
	@ElementCollection
	@OrderColumn
	@CollectionTable(
		name = "images", 
		joinColumns = @JoinColumn(name = "student_id") // column in 'images' table stores primary key of 'Student'
	)
	private List<String> images = new ArrayList<String>();
	
	@Column(name = "file_name")	// column for storing 'value' in map
	@ElementCollection
	@OrderColumn// doesnt work
	@MapKeyColumn(name = "img_desc") // column for storing 'key' in map
	@CollectionTable(name = "photos", joinColumns = @JoinColumn(name = "student_id"))
	private Map<String, String> photos = new HashMap<>();
	
	@Column(name = "result")
	@ElementCollection
	@OrderBy(clause = "result DESC")
	@MapKeyColumn(name = "result_desc")
	@CollectionTable(name = "results", joinColumns = @JoinColumn(name = "student_id"))
	private SortedMap<String, String> result = new TreeMap<>();
	
	@ElementCollection
	@CollectionTable(name = "courses", joinColumns = @JoinColumn(name="student_id"))
	@OrderBy(clause = "course DESC")
	@Column(name="course")
	private Set<String> courses = new LinkedHashSet<>();
	
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

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Set<String> getCourses() {
		return courses;
	}

	public void setCourses(Set<String> courses) {
		this.courses = courses;
	}
	
	/*public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}*/
	
	public Map<String, String> getPhotos() {
		return photos;
	}

	public void setPhotos(Map<String, String> photos) {
		this.photos = photos;
	}

	public SortedMap<String, String> getResult() {
		return result;
	}

	public void setResult(SortedMap<String, String> result) {
		this.result = result;
	}
	
	public Student() {
		//
	}

	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
}
