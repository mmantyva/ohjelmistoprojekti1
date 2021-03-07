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

import swd4ta022.ticketguru.domain.Lippu;
import swd4ta022.ticketguru.domain.LippuRepository;

@Controller
public class LippuController {
	
	@Autowired
	private LippuRepository lrepository;
	
	//näytä liput
	@RequestMapping(value="/liput", method=RequestMethod.GET)
	public @ResponseBody List<Lippu> liputRest() {
		return (List<Lippu>) lrepository.findAll();
	}
	
	// näytä yksittäinen lippu:
	@RequestMapping(value="/liput/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Lippu> getLippuRest(@PathVariable("id") Long lippu_id) {
		return lrepository.findById(lippu_id);
	} 
	
	// tallenna uusi lipputyyppi:
    @RequestMapping(value="/liput", method=RequestMethod.POST)
    public @ResponseBody Lippu saveLippuRest(@RequestBody Lippu lippu) {	
    	return lrepository.save(lippu);
    }
}
