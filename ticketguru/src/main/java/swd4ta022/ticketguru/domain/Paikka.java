package swd4ta022.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Paikka {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long paikkaid;
	private String pnimi, katuosoite, postinumero, kaupunki;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="paikka")
	private List<Tapahtuma> tapahtumat;
		
	public Paikka(String paikka_nimi, String katuosoite, String postinumero, String kaupunki) {
		super();
		
		this.pnimi = paikka_nimi;
		this.katuosoite = katuosoite;
		this.postinumero = postinumero;
		this.kaupunki = kaupunki;
	}
			
	public Paikka() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getPaikkaid() {
		return paikkaid;
	}
	public void setPaikkaid(long paikkaid) {
		this.paikkaid = paikkaid;
	}
	public String getPaikka_nimi() {
		return pnimi;
	}
	public void setPnimi(String pnimi) {
		this.pnimi = pnimi;
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

	public List<Tapahtuma> getTapahtumat() {
		return tapahtumat;
	}

	public void setTapahtumat(List<Tapahtuma> tapahtumat) {
		this.tapahtumat = tapahtumat;
	}
	

}
