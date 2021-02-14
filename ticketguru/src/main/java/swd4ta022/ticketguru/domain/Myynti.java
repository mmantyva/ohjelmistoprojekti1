package src.main.java.swd4ta022.ticketguru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Myynti {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long myynti_id;
	private String myynti_aika; //en jaksanut nyt tässä vaiheessa miettiä tietotyyppejä niin laitoin stringin paikkaa pitämään :D
	
	public Myynti(long myynti_id, String myynti_aika) {
		super();
		this.myynti_id = myynti_id;
		this.myynti_aika = myynti_aika;
	}
			
	public Myynti() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getMyynti_id() {
		return myynti_id;
	}
	public void setMyynti_id(long myynti_id) {
		this.myynti_id = myynti_id;
	}
	public String getMyynti_aika() {
		return myynti_aika;
	}
	public void setMyynti_aika(String myynti_aika) {
		this.myynti_aika = myynti_aika;
	}
	
	
}
