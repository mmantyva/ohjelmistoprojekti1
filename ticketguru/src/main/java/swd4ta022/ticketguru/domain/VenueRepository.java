package swd4ta022.ticketguru.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VenueRepository extends CrudRepository<Venue, Long> {
	
	List<Venue> findByVenuename(String venuename);

}
