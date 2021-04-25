package swd4ta022.ticketguru.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import swd4ta022.ticketguru.domain.Venue;
import swd4ta022.ticketguru.domain.VenueRepository;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VenueController {
    @Autowired 
	private VenueRepository vrepository; 	
    
 
	//  näytä paikat:
	@RequestMapping(value="/venues", method=RequestMethod.GET)
	public @Valid @ResponseBody List<Venue> venuesRest() {
		return (List<Venue>) vrepository.findAll();
	}
	
	// näytä yksittäinen paikka:
	@RequestMapping(value="/venues/{id}", method=RequestMethod.GET)
	public @Valid @ResponseBody Optional<Venue> getPaikkaRest(@PathVariable("id") Long venueid) {
		return vrepository.findById(venueid);
	} 
	
	// tallenna uusi paikka:
	
	@PostMapping("/venues")
	ResponseEntity<String> addVenue (@Valid @RequestBody Venue venue){
		return ResponseEntity.ok("Venue is saved");
	}
	
    //@RequestMapping(value="/venues", method=RequestMethod.POST)
    //public @Valid @ResponseBody Venue saveVenueRest(@Valid @RequestBody Venue venue) {	
   // 	return vrepository.save(venue);
   // }
    
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