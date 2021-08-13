import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Informations implements Serializable{
	@Id
	@GeneratedValue
	private long id;

	@Column(name = "Name")
	private String firstName;
	@Column(name = "Surrname")
	private String lastName;
	@Column(name = "Age")
	private int age;

	@OneToOne
	@JoinColumn(name = "Login", referencedColumnName = "Login")
	private Dane data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dane getData() {
		return data;
	}

	public void setData(Dane data) {
		this.data = data;
	}

}
