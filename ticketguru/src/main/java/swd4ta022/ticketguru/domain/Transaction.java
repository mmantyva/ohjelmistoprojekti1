package swd4ta022.ticketguru.domain;

import java.util.List;

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
	private String trtime; //en jaksanut nyt t�ss� vaiheessa mietti� tietotyyppej� niin laitoin stringin paikkaa pit�m��n :D

	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="transaction")
	private List<Ticket> tickets;
	
	public Transaction(String trtime) {
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
	public String getTrtime() {
		return trtime;
	}
	public void setTrtime(String trtime) {
		this.trtime = trtime;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}
	  
	public void setTickets(List<Ticket> tickets) {
		  this.tickets = tickets;
	}
	 
	
}
