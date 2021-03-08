package swd4ta022.ticketguru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ticketid;
	
	@ManyToOne
	@JoinColumn(name = "eventid")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Type type;
	
	@ManyToOne
	@JoinColumn(name = "trid")
	private Transaction transaction;

	public Ticket() {}
	
	public Ticket(Event event, Type type, Transaction transaction) {
		super();
		this.event = event;
		this.type = type;
		this.transaction = transaction;
	}


	public long getTicketid() {
		return ticketid;
	}

	public void setTicketid(long ticketid) {
		this.ticketid = ticketid;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent (Event event) {
		this.event = event;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction (Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + ticketid + "]";
	}
	
	
}
