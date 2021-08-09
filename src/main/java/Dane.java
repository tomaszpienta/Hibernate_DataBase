import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dane {

	@Id
	@GeneratedValue
	private Long Id;

	@Column(name = "Dane1")
	private String dane1;
	private String dane2;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDane1() {
		return dane1;
	}

	public void setDane1(String dane1) {
		this.dane1 = dane1;
	}

	public String getDane2() {
		return dane2;
	}

	public void setDane2(String dane2) {
		this.dane2 = dane2;
	}

}
