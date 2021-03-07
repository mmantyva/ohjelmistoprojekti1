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

import swd4ta022.ticketguru.domain.Myynti;
import swd4ta022.ticketguru.domain.MyyntiRepository;

@Controller
public class MyyntiController {
	
	@Autowired
	private MyyntiRepository mrepository;
	
	//näytä myyntitapahtumat
	@RequestMapping(value="/myynnit", method=RequestMethod.GET)
	public @ResponseBody List<Myynti> myyntiRest() {
		return (List<Myynti>) mrepository.findAll();
	}
	
	// näytä yksittäinen myyntitapahtuma:
	@RequestMapping(value="/myynnit/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Myynti> getMyyntiRest(@PathVariable("id") Long myynti_id) {
		return mrepository.findById(myynti_id);
	} 
	
	// tallenna uusi myyntitapahtuma:
    @RequestMapping(value="/myynnit", method=RequestMethod.POST)
    public @ResponseBody Myynti saveLipputyyppiRest(@RequestBody Myynti myynti) {	
    	return mrepository.save(myynti);
    }
}
