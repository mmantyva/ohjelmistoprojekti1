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

import swd4ta022.ticketguru.domain.Type;
import swd4ta022.ticketguru.domain.TypeRepository;


@Controller
public class TypeController {
	
	@Autowired
	private TypeRepository typerepository;
	
	//näytä lipputyypit
	@RequestMapping(value="/types", method=RequestMethod.GET)
	public @ResponseBody List<Type> typesRest() {
		return (List<Type>) typerepository.findAll();
	}
	
	// näytä yksittäinen lipputyyppi:
	@RequestMapping(value="/types/{id{}", method=RequestMethod.GET)
	public @ResponseBody Optional<Type> getTypeRest(@PathVariable("id") Long typeid) {
		return typerepository.findById(typeid);
	} 
	
	// tallenna uusi lipputyyppi:
    @RequestMapping(value="/types", method=RequestMethod.POST)
    public @ResponseBody Type saveTypeRest(@RequestBody Type typeid) {	
    	return typerepository.save(typeid);
    }
}
