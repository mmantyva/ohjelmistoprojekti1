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
	private Long id;
	private String lippu_id;
	
	@ManyToOne
	@JoinColumn(name = "tyyppi_id")
	private Lipputyyppi tyyppi_id;
	
	@ManyToOne
	@JoinColumn(name = "myynti_id")
	private Myynti myynti_id;

	public Lippu() {}
	
	public Lippu(Long id, String lippu_id, Lipputyyppi tyyppi_id, Myynti myynti_id) {
		super();
		this.id = id;
		this.lippu_id = lippu_id;
		this.tyyppi_id = tyyppi_id;
		this.myynti_id = myynti_id;
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

	public Lipputyyppi getTyyppi_id() {
		return tyyppi_id;
	}

	public void setTyyppi_id(Lipputyyppi tyyppi_id) {
		this.tyyppi_id = tyyppi_id;
	}

	public Myynti getMyynti_id() {
		return myynti_id;
	}

	public void setMyynti_id(Myynti myynti_id) {
		this.myynti_id = myynti_id;
	}

	@Override
	public String toString() {
		return "Lippu [id=" + id + ", lippu_id=" + lippu_id + "]";
	}
	
	
	
}
