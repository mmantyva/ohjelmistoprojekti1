package swd4ta022.ticketguru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paikka {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long paikka_id;
	private String paikka_nimi, katuosoite, postinumero, kaupunki;
		
	public Paikka(long paikka_id, String paikka_nimi, String katuosoite, String postinumero, String kaupunki) {
		super();
		this.paikka_id = paikka_id;
		this.paikka_nimi = paikka_nimi;
		this.katuosoite = katuosoite;
		this.postinumero = postinumero;
		this.kaupunki = kaupunki;
	}
			
	public Paikka() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getPaikka_id() {
		return paikka_id;
	}
	public void setPaikka_id(long paikka_id) {
		this.paikka_id = paikka_id;
	}
	public String getPaikka_nimi() {
		return paikka_nimi;
	}
	public void setPaikka_nimi(String paikka_nimi) {
		this.paikka_nimi = paikka_nimi;
	}
	public String getKatuosoite() {
		return katuosoite;
	}
	public void setKatuosoite(String katuosoite) {
		this.katuosoite = katuosoite;
	}
	public String getPostinumero() {
		return postinumero;
	}
	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}
	public String getKaupunki() {
		return kaupunki;
	}
	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}
	
	
	

}
