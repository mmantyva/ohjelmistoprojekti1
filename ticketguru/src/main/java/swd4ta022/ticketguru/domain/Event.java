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
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Event {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long eventid;
	
	@NotBlank(message="Event must have a name")
	//@Max(50)
	private String eventname;
	
	@NotBlank(message="Event must have a time")
	private String eventtime;
	
	@NotBlank(message="Event must have a performer")
	//@Max(50)
	private String performer;
	
	//@Max(250)
	private String desc;
	
	@Positive(message = "Only positive numbers, please")
	private int capacity;
	
	@ManyToOne
	@JoinColumn(name="venueid")
	private Venue venue;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
	@JsonBackReference
	private List<Ticket> tickets;

	public Event() {
	}
	
	
	public Event(String eventname, String eventtime, String performer, String desc, int capacity, Venue venue) {
		super();
		this.eventname = eventname;
		this.eventtime = eventtime;
		this.performer = performer;
		this.desc = desc;
		this.capacity = capacity;
		this.venue = venue;
	}


	public long getEventid() {
		return eventid;
	}

	public void setEventid(long eventid) {
		this.eventid = eventid;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventtime() {
		return eventtime;
	}

	public void setEventtime(String eventtime) {
		this.eventtime = eventtime;
	}
	

	public String getPerformer() {
		return performer;
	}

	public void setPerformer(String performer) {
		this.performer = performer;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public Event(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	
	
}
	
	
	
	