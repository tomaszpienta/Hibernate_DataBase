import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Dane implements Serializable{

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "Login")
	private String logIn;
	@Column(name = "Password")
	private String password;

	@OneToOne(mappedBy = "dane")
	private Informations info;

	public Informations getInfo() {
		return info;
	}

	public void setInfo(Informations info) {
		this.info = info;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogIn() {
		return logIn;
	}

	public void setLogIn(String logIn) {
		this.logIn = logIn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
