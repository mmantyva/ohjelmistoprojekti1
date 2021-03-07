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

import swd4ta022.ticketguru.domain.Lipputyyppi;
import swd4ta022.ticketguru.domain.LipputyyppiRepository;

@Controller
public class LipputyyppiController {
	
	@Autowired
	private LipputyyppiRepository ltrepository;
	
	//näytä lipputyypit
	@RequestMapping(value="/lipputyypit", method=RequestMethod.GET)
	public @ResponseBody List<Lipputyyppi> lipputyypitRest() {
		return (List<Lipputyyppi>) ltrepository.findAll();
	}
	
	// näytä yksittäinen lipputyyppi:
	@RequestMapping(value="/lipputyypit/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Lipputyyppi> getLipputyyppiRest(@PathVariable("id") Long tyyppiid) {
		return ltrepository.findById(tyyppiid);
	} 
	
	// tallenna uusi lipputyyppi:
    @RequestMapping(value="/lipputyypit", method=RequestMethod.POST)
    public @ResponseBody Lipputyyppi saveLipputyyppiRest(@RequestBody Lipputyyppi lipputyyppi) {	
    	return ltrepository.save(lipputyyppi);
    }
}
