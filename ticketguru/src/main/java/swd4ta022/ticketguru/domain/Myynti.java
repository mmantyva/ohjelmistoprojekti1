package swd4ta022.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Myynti {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long myyntiid;
	private String myynti_aika; //en jaksanut nyt t�ss� vaiheessa mietti� tietotyyppej� niin laitoin stringin paikkaa pit�m��n :D

	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="myynti")
	private List<Lippu> liput;
	
	public Myynti(long myyntiid, String myynti_aika) {
		super();
		this.myyntiid = myyntiid;
		this.myynti_aika = myynti_aika;
	}
			
	public Myynti() {
	}
	
	public long getMyyntiid() {
		return myyntiid;
	}
	public void setMyynti_id(long myyntiid) {
		this.myyntiid = myyntiid;
	}
	public String getMyynti_aika() {
		return myynti_aika;
	}
	public void setMyynti_aika(String myynti_aika) {
		this.myynti_aika = myynti_aika;
	}

	public List<Lippu> getLiput() {
		return liput;
	}
	  
	public void setLiput(List<Lippu> liput) {
		  this.liput = liput;
	}
	 
	
}
