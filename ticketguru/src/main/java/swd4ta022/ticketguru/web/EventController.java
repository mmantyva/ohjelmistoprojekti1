package swd4ta022.ticketguru.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd4ta022.ticketguru.domain.Event;
import swd4ta022.ticketguru.domain.EventRepository;


@Controller
public class EventController {
	
	@Autowired 
	private EventRepository erepository; 	
	
	// REST-metodit:
	
	// /tapahtumat on custom endpoint (ei siis autogeneroitu)!

	//  näytä tapahtumat:
	@RequestMapping(value="/events", method=RequestMethod.GET)
	public @Valid @ResponseBody List<Event> eventsRest() {
		return (List<Event>) erepository.findAll();
	}
	
	// näytä yksittäinen tapahtuma:
	@RequestMapping(value="/events/{id}", method=RequestMethod.GET)
	public @Valid @ResponseBody Optional<Event> getEventRest(@PathVariable("id") Long eventid) {
		return erepository.findById(eventid);
	} 
	
	// tallenna uusi tapahtuma:
    @RequestMapping(value="/events", method=RequestMethod.POST)
    public @Valid @ResponseBody Event saveEventRest(@Valid @RequestBody Event event) {	
    	return erepository.save(event);
    }
	

	
}
