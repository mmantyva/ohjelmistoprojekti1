package swd4ta022.ticketguru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd4ta022.ticketguru.domain.Transaction;
import swd4ta022.ticketguru.domain.TransactionRepository;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {
	
	@Autowired
	private TransactionRepository trrepository;
	
	//näytä myyntitapahtumat
	@RequestMapping(value="/transactions", method=RequestMethod.GET)
	public @ResponseBody List<Transaction> trRest() {
		return (List<Transaction>) trrepository.findAll();
	}
	
	// näytä yksittäinen myyntitapahtuma:
	@RequestMapping(value="/transactions/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Transaction> getTrRest(@PathVariable("id") Long trid) {
		return trrepository.findById(trid);
	} 
	
	// tallenna uusi myyntitapahtuma:
    @RequestMapping(value="/transactions", method=RequestMethod.POST)
    public @ResponseBody Transaction saveTrRest(@RequestBody Transaction transaction) {	
    	return trrepository.save(transaction);
    }
}
