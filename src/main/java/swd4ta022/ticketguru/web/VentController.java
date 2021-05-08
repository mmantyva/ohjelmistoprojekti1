package swd4ta022.ticketguru.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import swd4ta022.ticketguru.domain.Vent;
import swd4ta022.ticketguru.domain.VentDTO;
import swd4ta022.ticketguru.domain.VentRepository;
import swd4ta022.ticketguru.domain.Venue;


@Controller
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VentController {
	
	@Autowired 
	private VentRepository vrepository; 
	
	// REST-metodit:
	
	// /tapahtumat on custom endpoint (ei siis autogeneroitu)!

	//  näytä tapahtumat:
	@RequestMapping(value="/events", method=RequestMethod.GET)
	public @Valid @ResponseBody List<Vent> eventsRest() {
		return (List<Vent>) vrepository.findAll();
	}
	
	// näytä yksittäinen tapahtuma:
	@RequestMapping(value="/events/{id}", method=RequestMethod.GET)
	public @Valid @ResponseBody Optional<Vent> getEventRest(@PathVariable("id") Long ventid) {
		return vrepository.findById(ventid);
	} 
	
	// tallenna uusi tapahtuma:
	@PostMapping("/events")
	ResponseEntity<String> addEvent (@Valid @RequestBody Vent vent){
		return ResponseEntity.ok("Event is saved");
	}
	

    
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> hendleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
	}
	

	
}
