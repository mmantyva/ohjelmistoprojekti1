package swd4ta022.ticketguru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Tapahtuma {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long tapahtuma_id;
	private String tnimi, tapahtuma_aika, esiintyja, tapahtuma_kuvaus;
	private int kapasiteetti;
	
	@ManyToOne
	@JoinColumn(name="paikka_id")
	private Paikka paikka;
	
	public Tapahtuma() {
		super();
	}

	public long getTapahtuma_id() {
		return tapahtuma_id;
	}

	public void setTapahtuma_id(long tapahtuma_id) {
		this.tapahtuma_id = tapahtuma_id;
	}

	public String getTapahtuma_nimi() {
		return tnimi;
	}

	public void setTapahtuma_nimi(String tnimi) {
		this.tnimi = tnimi;
	}

	public String getTapahtuma_aika() {
		return tapahtuma_aika;
	}

	public void setTapahtuma_aika(String tapahtuma_aika) {
		this.tapahtuma_aika = tapahtuma_aika;
	}

	public String getEsiintyja() {
		return esiintyja;
	}

	public void setEsiintyja(String esiintyja) {
		this.esiintyja = esiintyja;
	}

	public String getTapahtuma_kuvaus() {
		return tapahtuma_kuvaus;
	}

	public void setTapahtuma_kuvaus(String tapahtuma_kuvaus) {
		this.tapahtuma_kuvaus = tapahtuma_kuvaus;
	}

	public int getKapasiteetti() {
		return kapasiteetti;
	}

	public void setKapasiteetti(int kapasiteetti) {
		this.kapasiteetti = kapasiteetti;
	}

	public Paikka getPaikka() {
		return paikka;
	}

	public void setPaikka(Paikka paikka) {
		this.paikka = paikka;
	}

	public Tapahtuma(String tnimi, String tapahtuma_aika, String esiintyja,
			String tapahtuma_kuvaus, int kapasiteetti, Paikka paikka) {
		super();
		
		this.tnimi = tnimi;
		this.tapahtuma_aika = tapahtuma_aika;
		this.esiintyja = esiintyja;
		this.tapahtuma_kuvaus = tapahtuma_kuvaus;
		this.kapasiteetti = kapasiteetti;
		this.paikka = paikka;
	}

	@Override
	public String toString() {
		return "Tapahtuma [tapahtuma_id=" + tapahtuma_id + ", tapahtuma_nimi=" + tnimi + ", tapahtuma_aika="
				+ tapahtuma_aika + ", esiintyja=" + esiintyja + ", tapahtuma_kuvaus=" + tapahtuma_kuvaus
				+ ", kapasiteetti=" + kapasiteetti + ", paikka_id=" + paikka + "]";
	}

	

	
}
	
	
	
	