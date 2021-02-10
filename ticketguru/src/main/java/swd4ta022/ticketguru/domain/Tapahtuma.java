package swd4ta022.ticketguru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tapahtuma {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nimi, aika, paikka, kaupunki, kuvaus;
	
	public Tapahtuma() {
		super();
	}

	public Tapahtuma(long id, String nimi, String aika, String paikka, String kaupunki, String kuvaus) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.aika = aika;
		this.paikka = paikka;
		this.kaupunki = kaupunki;
		this.kuvaus = kuvaus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getAika() {
		return aika;
	}

	public void setAika(String aika) {
		this.aika = aika;
	}

	public String getPaikka() {
		return paikka;
	}

	public void setPaikka(String paikka) {
		this.paikka = paikka;
	}

	public String getKaupunki() {
		return kaupunki;
	}

	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	@Override
	public String toString() {
		return "Tapahtuma [id=" + id + ", nimi=" + nimi + ", aika=" + aika + ", paikka=" + paikka + ", kaupunki="
				+ kaupunki + ", kuvaus=" + kuvaus + "]";
	}

	
}
