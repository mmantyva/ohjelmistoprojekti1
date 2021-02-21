package swd4ta022.ticketguru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd4ta022.ticketguru.domain.Tapahtuma;
import swd4ta022.ticketguru.domain.TapahtumaRepository;


@Controller
public class TapahtumaController {
	
	@Autowired 
	private TapahtumaRepository tapahtumarepository; 

	// näytä tapahtumat
	@RequestMapping(value = {"/", "/tapahtumalista"})
    public String tapahtumaList(Model model) {	
        model.addAttribute("tapahtumat", tapahtumarepository.findAll());
        return "tapahtumalista";
    }
	
	// lisää tapahtuma
	@RequestMapping(value = "/add")
	public String lisaaTapahtuma(Model model) {
		model.addAttribute("tapahtuma", new Tapahtuma());
		return "lisaaTapahtuma";
	}
	
	// tallenna uusi tapahtuma
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String tallennaTapahtuma(Tapahtuma tapahtuma) {
		tapahtumarepository.save(tapahtuma);
		return "redirect:tapahtumalista";
	}
	
	// poista tapahtuma
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String poistaTapahtuma (@PathVariable("id") Long tapahtumaId, Model model) {
		tapahtumarepository.deleteById(tapahtumaId);
		return "redirect:../tapahtumalista";
	}
	
	// muokkaa tapahtumaa
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String muokkaaTapahtuma(@PathVariable("id") Long tapahtumaId, Model model) {
		model.addAttribute("tapahtuma", tapahtumarepository.findById(tapahtumaId));
		return "muokkaaTapahtuma";
	}
	
}
