package swd4ta022.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Lipputyyppi {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tyyppiid;
	private float hinta;
	private String tyyppi_kuvaus;
	
	@ManyToOne
	@JoinColumn(name = "tapahtuma_id")
	private Tapahtuma tapahtuma;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="tyyppi")
	@JsonBackReference
	private List<Lippu> liput;

	public Long getTyyppi_id() {
		return tyyppiid;
	}

	public void setTyyppi_id(Long tyyppiid) {
		this.tyyppiid = tyyppiid;
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

	public Tapahtuma getTapahtuma() {
		return tapahtuma;
	}

	public void setTapahtuma(Tapahtuma tapahtuma) {
		this.tapahtuma = tapahtuma;
	}

	public Lipputyyppi(float hinta, String tyyppi_kuvaus, Tapahtuma tapahtuma) {
		super();
	
		this.hinta = hinta;
		this.tyyppi_kuvaus = tyyppi_kuvaus;
		this.tapahtuma = tapahtuma;
	}

	public Lipputyyppi() {
		super();
	}

	
	
	
	
	
	

}
