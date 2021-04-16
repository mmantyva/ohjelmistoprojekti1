package swd4ta022.ticketguru.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ticketid;
	private Date used;
	
	@ManyToOne
	@JoinColumn(name = "ventid")
	private Vent vent;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Type type;
	
	@ManyToOne
	@JoinColumn(name = "trid")
	private Transaction transaction;

	public Ticket() {}
	
	public Ticket(Date used, Vent vent, Type type, Transaction transaction) {
		super();
		this.used = used;
		this.vent = vent;
		this.type = type;
		this.transaction = transaction;
	}


	public long getTicketid() {
		return ticketid;
	}

	public void setTicketid(long ticketid) {
		this.ticketid = ticketid;
	}
	
	public Date getUsed() {
		return used;
	}

	public void setUsed(Date used) {
		this.used = used;
	}

	public Vent getVent() {
		return vent;
	}

	public void setVent (Vent vent) {
		this.vent = vent;
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
