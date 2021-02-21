package swd4ta022.ticketguru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lippu {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String lippu_id;
	
	@ManyToOne
	@JoinColumn(name = "tyyppi_id")
	private Lipputyyppi tyyppi;
	
	@ManyToOne
	@JoinColumn(name = "myynti_id")
	private Myynti myynti;

	public Lippu() {}
	
	public Lippu(String lippu_id, Lipputyyppi tyyppi, Myynti myynti) {
		super();
		
		this.lippu_id = lippu_id;
		this.tyyppi = tyyppi;
		this.myynti = myynti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLippu_id() {
		return lippu_id;
	}

	public void setLippu_id(String lippu_id) {
		this.lippu_id = lippu_id;
	}

	public Lipputyyppi getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(Lipputyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}

	public Myynti getMyynti() {
		return myynti;
	}

	public void setMyynti(Myynti myynti) {
		this.myynti = myynti;
	}

	@Override
	public String toString() {
		return "Lippu [id=" + id + ", lippu_id=" + lippu_id + "]";
	}
	
	
	
}
