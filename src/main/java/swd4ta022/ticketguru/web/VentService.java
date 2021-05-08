package swd4ta022.ticketguru.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swd4ta022.ticketguru.domain.Vent;
import swd4ta022.ticketguru.domain.VentDTO;
import swd4ta022.ticketguru.domain.VentRepository;
import swd4ta022.ticketguru.domain.Venue;
import swd4ta022.ticketguru.domain.Type;

@Service
public class VentService {
	
	@Autowired
	private VentRepository ventRepository;
	
	public List<VentDTO> getAllEvents() {
		return ((List<Vent>) ventRepository
				.findAll())
				.stream()
				.map(this::convertToVentDTO)
					.collect(Collectors.toList());
	}
	
	private VentDTO convertToVentDTO(Vent vent) {
		VentDTO ventDTO = new VentDTO();
		ventDTO.setVentid(vent.getEventid());
		ventDTO.setEventname(vent.getEventname());
		ventDTO.setEventtime(vent.getEventtime());
		ventDTO.setPerformer(vent.getPerformer());
		ventDTO.setDescription(vent.getDescription());
		ventDTO.setCapacity(vent.getCapacity());
		Venue venue = vent.getVenue();
		ventDTO.setVenuename(venue.getVenuename()); 
		return ventDTO;
	}
	
	

}
