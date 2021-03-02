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
	@JoinColumn(name = "tyyppi_id")
	private Lipputyyppi tyyppi;
	
	@ManyToOne
	@JoinColumn(name = "myynti_id")
	private Myynti myynti;

	public Lippu() {}
	
	public Lippu(Lipputyyppi tyyppi, Myynti myynti) {
		super();
		
		
		this.tyyppi = tyyppi;
		this.myynti = myynti;
	}

	public Long getlippuId() {
		return lippuid;
	}

	public void setId(Long lippuid) {
		this.lippuid = lippuid;
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
