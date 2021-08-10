import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Informations {
	@Id
	@GeneratedValue
	private long Id;

	@Column(name = "Imie")
	private String imie;
	@Column(name = "Nazwisko")
	private String nazwisko;
	@Column(name = "Wiek")
	private int wiek;

	@OneToOne
	@JoinColumn(name = "Login", referencedColumnName = "Login")
	private Dane dane;

	public Dane getDane() {
		return dane;
	}

	public void setDane(Dane dane) {
		this.dane = dane;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

}
