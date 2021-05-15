package swd4ta022.ticketguru.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swd4ta022.ticketguru.domain.TicketType;
import swd4ta022.ticketguru.domain.TypeRepository;
import swd4ta022.ticketguru.domain.Vent;
import swd4ta022.ticketguru.domain.VentDTO;
import swd4ta022.ticketguru.domain.VentRepository;
import swd4ta022.ticketguru.domain.Venue;

@RestController
public class VentDTOcontroller {
	
	@Autowired 
	private VentService ventService;
	@Autowired 
	private VentRepository ventRepository;
	@Autowired 
	private TypeRepository typeRepository;
	
	@GetMapping("/getevents")
	@ResponseBody
	public List<VentDTO> getAllEvents() {
		
		List <VentDTO> eventVenues = ventService.getAllEvents();
		return eventVenues;
	}
	
	@GetMapping("/eventtickets")
	@ResponseBody
	public List<VentDTO> eventTickets() {
		List<Vent> events = (List<Vent>) ventRepository.findAll();
		List<VentDTO> ventDTOs = new ArrayList<>();
		for (Vent event : events) {
			List<TicketType> ticketTypes = typeRepository.findByVent(event);
			//Venue venue = event.getVenue();
			//String venueName = venue.getVenuename(); 
			ventDTOs.add(new VentDTO(event, /*venueName,*/ ticketTypes));
		}
		return ventDTOs;
	}
}
