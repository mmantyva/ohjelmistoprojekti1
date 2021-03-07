package swd4ta022.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Lipputyyppi {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tyyppiid;
	private double hinta;
	private String kuvaus;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="tyyppi")
	@JsonBackReference
	private List<Lippu> liput;

	public Long getTyyppiid() {
		return tyyppiid;
	}

	public void setTyyppiid(Long tyyppiid) {
		this.tyyppiid = tyyppiid;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public Lipputyyppi(double hinta, String kuvaus) {
		super();
	
		this.hinta = hinta;
		this.kuvaus = kuvaus;
	}

	public Lipputyyppi() {
		super();
	}

	
	

}
