package swd4ta022.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Venue {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long venueid;
	private String venuename, address, postcode, city;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="venue")
	@JsonBackReference
	private List<Event> events;
		
	public Venue(String venuename, String address, String postcode, String city) {
		super();
		this.venuename = venuename;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
	}
			
	public Venue() {

	}

	public long getVenueid() {
		return venueid;
	}
	public void setVenueid(long venueid) {
		this.venueid = venueid;
	}
	public String getVenuename() {
		return venuename;
	}
	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	

}
