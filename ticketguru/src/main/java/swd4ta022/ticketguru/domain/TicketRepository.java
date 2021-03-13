package swd4ta022.ticketguru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
	List<Ticket> findByTicketid(Long ticketid);
	

}
