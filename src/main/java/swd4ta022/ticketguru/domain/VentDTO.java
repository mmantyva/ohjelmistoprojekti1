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
import swd4ta022.ticketguru.domain.Type;

public class VentDTO {
	
	private long ventid;
	private String eventname;
	private String eventtime;
	private String performer;
	private String description;
	private int capacity;
	private List<Type> types;
	private String tickettype;
	private double price;
	
	
	
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

	
	public VentDTO(long ventid, String eventname, String eventtime, String performer, String description, int capacity,
			 List<Type> types) {
		super();
		this.ventid = ventid;
		this.eventname = eventname;
		this.eventtime = eventtime;
		this.performer = performer;
		this.description = description;
		this.capacity = capacity;

		this.setTypes(types);
	}
	
	public VentDTO(Vent vent, List<Type> types) {
		super();
		this.ventid = vent.getEventid();
		this.eventname = vent.getEventname();
		this.eventtime = vent.getEventtime();
		this.performer = vent.getPerformer();
		this.description = vent.getDescription();
		this.capacity = vent.getCapacity();
		this.setTypes(types);
	}
	
	public VentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}

	

}
