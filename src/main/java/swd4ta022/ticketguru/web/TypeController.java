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

import swd4ta022.ticketguru.domain.TicketType;
import swd4ta022.ticketguru.domain.TypeRepository;
import swd4ta022.ticketguru.domain.Venue;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypeController {
	
	@Autowired
	private TypeRepository typerepository;
	
	//näytä lipputyypit
	@RequestMapping(value="/types", method=RequestMethod.GET)
	public @ResponseBody List<TicketType> typesRest() {
		return (List<TicketType>) typerepository.findAll();
	}
	
	// näytä yksittäinen lipputyyppi:
	@RequestMapping(value="/types/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<TicketType> getTypeRest(@PathVariable("id") Long typeid) {
		return typerepository.findById(typeid);
	} 
	
	// tallenna uusi lipputyyppi:
	@PostMapping("/types")
	ResponseEntity<String> addType (@Valid @RequestBody TicketType type){
		return ResponseEntity.ok("Ticket type is saved");
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
