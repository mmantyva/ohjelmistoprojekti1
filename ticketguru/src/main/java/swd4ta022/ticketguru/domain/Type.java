package swd4ta022.ticketguru.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeid;
	@NotBlank(message="Ticket type must have a name")
	private String typename;
	@Positive(message = "Price must be over positive")
	private double price;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="type")
	@JsonBackReference
	private List<Ticket> tickets;

	public Type() {
	}
	
	public Type(String typename, double price) {
		super();
		this.typename = typename;
		this.price = price;
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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	

}
