package swd4ta022.ticketguru.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import swd4ta022.ticketguru.domain.LippuRepository;
import swd4ta022.ticketguru.domain.LipputyyppiRepository;
import swd4ta022.ticketguru.domain.MyyntiRepository;
import swd4ta022.ticketguru.domain.PaikkaRepository;
import swd4ta022.ticketguru.domain.TapahtumaRepository;


@Controller
public class TapahtumaController {
	
	@Autowired 
	private LippuRepository lippurepository; 
	
	@Autowired 
	private LipputyyppiRepository lipputyyppirepository; 
	
	@Autowired 
	private MyyntiRepository myyntirepository; 
	
	@Autowired 
	private PaikkaRepository paikkarepository; 
	
	@Autowired 
	private TapahtumaRepository tapahtumarepository; 

	// näytä tapahtumat
	@RequestMapping(value={"/", "/tapahtumalista"})
    public String tapahtumaList(Model model) {	
        model.addAttribute("tapahtumat", tapahtumarepository.findAll());
        return "tapahtumalista";
    }
	
	
}
