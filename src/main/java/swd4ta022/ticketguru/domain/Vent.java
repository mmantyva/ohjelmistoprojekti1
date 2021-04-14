package swd4ta022.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Vent {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long ventid;
	
	@NotBlank(message="Event must have a name")
	//@Max(50)
	private String ventname;
	
	@NotBlank(message="Event must have a time")
	private String venttime;
	
	@NotBlank(message="Event must have a performer")
	//@Max(50)
	private String performer;
	
	//@Max(250)
	private String description;
	
	@Positive(message = "Only positive numbers, please")
	private int capacity;
	
	@ManyToOne
	@JoinColumn(name="venueid")
	private Venue venue;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="vent")
	@JsonBackReference
	private List<Ticket> tickets;

	public Vent() {
	}
	
	
	public Vent (String ventname, String venttime, String performer, String description, int capacity, Venue venue) {
		super();
		this.ventname = ventname;
		this.venttime = venttime;
		this.performer = performer;
		this.description = description;
		this.capacity = capacity;
		this.venue = venue;
	}


	public long getEventid() {
		return ventid;
	}

	public void setEventid(long ventid) {
		this.ventid = ventid;
	}

	public String getEventname() {
		return ventname;
	}

	public void setEventname(String ventname) {
		this.ventname = ventname;
	}

	public String getEventtime() {
		return venttime;
	}

	public void setEventtime(String venttime) {
		this.venttime = venttime;
	}
	

	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Vent(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	
	
}
	
	
	
	