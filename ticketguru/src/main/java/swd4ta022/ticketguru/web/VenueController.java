package swd4ta022.ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd4ta022.ticketguru.domain.Venue;
import swd4ta022.ticketguru.domain.VenueRepository;


@Controller
public class VenueController {
    @Autowired 
	private VenueRepository vrepository; 	
    
 
	//  näytä paikat:
	@RequestMapping(value="/venues", method=RequestMethod.GET)
	public @ResponseBody List<Venue> venuesRest() {
		return (List<Venue>) vrepository.findAll();
	}
	
	// näytä yksittäinen paikka:
	@RequestMapping(value="/venues/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Venue> getPaikkaRest(@PathVariable("id") Long venueid) {
		return vrepository.findById(venueid);
	} 
	
	// tallenna uusi paikka:
    @RequestMapping(value="/venues", method=RequestMethod.POST)
    public @ResponseBody Venue saveVenueRest(@RequestBody Venue venue) {	
    	return vrepository.save(venue);
    }
}