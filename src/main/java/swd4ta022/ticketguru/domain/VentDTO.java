package swd4ta022.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class VentDTO {
	
	private long ventid;
	private String eventname;
	private String eventtime;
	private String performer;
	private String description;
	private int capacity;
	private String venuename;
	
	
	
	public long getVentid() {
		return ventid;
	}
	public void setVentid(long ventid) {
		this.ventid = ventid;
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
	public String getVenuename() {
		return venuename;
	}
	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}
	public VentDTO(long ventid, String eventname, String eventtime, String performer, String description, int capacity,
			String venuename) {
		super();
		this.ventid = ventid;
		this.eventname = eventname;
		this.eventtime = eventtime;
		this.performer = performer;
		this.description = description;
		this.capacity = capacity;
		this.venuename = venuename;
	}
	public VentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
