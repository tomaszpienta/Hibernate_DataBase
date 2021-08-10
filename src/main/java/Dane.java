import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dane {

	@Id
	@GeneratedValue
	private Long Id;

	@Column(name = "Login")
	private String logIn;
	@Column(name = "Password")
	private String password;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
