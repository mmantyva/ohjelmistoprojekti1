package swd4ta022.ticketguru.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swd4ta022.ticketguru.domain.VentDTO;

@RestController
public class VentDTOcontroller {
	
	@Autowired 
	private VentService ventService;
	
	@GetMapping("/getevents")
	@ResponseBody
	public List<VentDTO> getAllEvents() {
		List <VentDTO> eventVenues = ventService.getAllEvents();
		return eventVenues;
	}
	

}
