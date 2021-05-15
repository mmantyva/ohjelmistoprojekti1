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
public class TicketType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeid;
	@NotBlank(message="Ticket type must have a name")
	private String typename;
	@Positive(message = "Price must be positive")
	private double price;
	
	@ManyToOne
	@JoinColumn(name="ventid")
	private Vent vent;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="type")
	@JsonBackReference
	private List<Ticket> tickets;

	public TicketType() {
	}
	
	public TicketType(String typename, double price, Vent vent) {
		super();
		this.typename = typename;
		this.price = price;
		this.vent = vent;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}
	
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Vent getVent() {
		return vent;
	}

	public void setVent(Vent vent) {
		this.vent = vent;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	

<<<<<<< HEAD
}
=======
}
>>>>>>> 22245edfa18d7ea54f383ecbef842ff794a478d8
