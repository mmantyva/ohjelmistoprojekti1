package swd4ta022.ticketguru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lipputyyppi {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tyyppi_id;
	private float hinta;
	private String tyyppi_kuvaus;
	
	@ManyToOne
	@JoinColumn(name = "tapahtuma_id")
	private Tapahtuma tapahtuma_id;

	public Long getTyyppi_id() {
		return tyyppi_id;
	}

	public void setTyyppi_id(Long tyyppi_id) {
		this.tyyppi_id = tyyppi_id;
	}

	public float getHinta() {
		return hinta;
	}

	public void setHinta(float hinta) {
		this.hinta = hinta;
	}

	public String getTyyppi_kuvaus() {
		return tyyppi_kuvaus;
	}

	public void setTyyppi_kuvaus(String tyyppi_kuvaus) {
		this.tyyppi_kuvaus = tyyppi_kuvaus;
	}

	public Tapahtuma getTapahtuma_id() {
		return tapahtuma_id;
	}

	public void setTapahtuma_id(Tapahtuma tapahtuma_id) {
		this.tapahtuma_id = tapahtuma_id;
	}

	public Lipputyyppi(Long tyyppi_id, float hinta, String tyyppi_kuvaus, Tapahtuma tapahtuma_id) {
		super();
		this.tyyppi_id = tyyppi_id;
		this.hinta = hinta;
		this.tyyppi_kuvaus = tyyppi_kuvaus;
		this.tapahtuma_id = tapahtuma_id;
	}

	public Lipputyyppi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
