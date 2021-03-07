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
	private long lippuid;
	
	@ManyToOne
	@JoinColumn(name = "tapahtuma_id")
	private Tapahtuma tapahtuma;
	
	@ManyToOne
	@JoinColumn(name = "tyyppi_id")
	private Lipputyyppi tyyppi;
	
	@ManyToOne
	@JoinColumn(name = "myynti_id")
	private Myynti myynti;

	public Lippu() {}
	
	public Lippu(Tapahtuma tapahtuma, Lipputyyppi tyyppi, Myynti myynti) {
		super();
		this.tapahtuma = tapahtuma;
		this.tyyppi = tyyppi;
		this.myynti = myynti;
	}


	public long getLippuid() {
		return lippuid;
	}

	public void setLippu_id(long lippuid) {
		this.lippuid = lippuid;
	}

	public Tapahtuma getTapahtuma() {
		return tapahtuma;
	}

	public void setTapahtuma(Tapahtuma tapahtuma) {
		this.tapahtuma = tapahtuma;
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
		return "Lippu [id=" + lippuid + "]";
	}
	
	
	
}
