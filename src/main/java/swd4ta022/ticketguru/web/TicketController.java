package swd4ta022.ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swd4ta022.ticketguru.domain.Ticket;
import swd4ta022.ticketguru.domain.TicketRepository;

@RestController
public class TicketController {
	
	@Autowired
	private TicketRepository ticketrepository;
	
	//näytä liput
	@RequestMapping(value="/tickets", method=RequestMethod.GET)
	public @ResponseBody List<Ticket> ticketsRest() {
		return (List<Ticket>) ticketrepository.findAll();
	}
	
	// näytä yksittäinen lippu:
	@RequestMapping(value="/tickets/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Ticket> getTicketRest(@PathVariable("id") Long ticketid) {
		return ticketrepository.findById(ticketid);
	} 
	
	// tallenna uusi lipputyyppi:
    @RequestMapping(value="/tickets", method=RequestMethod.POST)
    public @ResponseBody Ticket saveTicketRest(@RequestBody Ticket ticket) {	
    	return ticketrepository.save(ticket);
    }
}
