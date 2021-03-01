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

import swd4ta022.ticketguru.domain.Paikka;
import swd4ta022.ticketguru.domain.PaikkaRepository;


@Controller
public class PaikkaController {
    @Autowired 
	private PaikkaRepository paikkarepository; 	
    
    
	
	//  näytä paikat:
	@RequestMapping(value="/paikat", method=RequestMethod.GET)
	public @ResponseBody List<Paikka> paikatRest() {
		return (List<Paikka>) paikkarepository.findAll();
	}
	
	// näytä yksittäinen paikka:
	@RequestMapping(value="/paikat/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Paikka> getPaikkaRest(@PathVariable("id") Long paikka_id) {
		return paikkarepository.findById(paikka_id);
	} 
	
	// tallenna uusi paikka:
    @RequestMapping(value="/paikat", method=RequestMethod.POST)
    public @ResponseBody Paikka savePaikkaaRest(@RequestBody Paikka paikka) {	
    	return paikkarepository.save(paikka);
    }
}