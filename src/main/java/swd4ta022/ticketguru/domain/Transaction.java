package swd4ta022.ticketguru.domain;

import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long trid;
	private Date trtime; 

	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="transaction")
	private List<Ticket> tickets;
	
	public Transaction(Date trtime) {
		super();
		this.trtime = trtime;
	}
			
	public Transaction() {
	}
	
	public long getTrid() {
		return trid;
	}
	public void setTrid(long trid) {
		this.trid = trid;
	}
	public Date getTrtime() {
		return trtime;
	}
	public void setTrtime(Date trtime) {
		this.trtime = trtime;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}
	  
	public void setTickets(List<Ticket> tickets) {
		  this.tickets = tickets;
	}
	 
	
}
