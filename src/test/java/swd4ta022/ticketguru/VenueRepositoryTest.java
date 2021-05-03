
package swd4ta022.ticketguru;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd4ta022.ticketguru.domain.Venue;
import swd4ta022.ticketguru.domain.VenueRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class VenueRepositoryTest {

    @Autowired
    private VenueRepository repository;

    @Test
    public void findByNameShouldReturnVenue() {
        List<Venue> venues = repository.findByVenuename("Tavastia");
        
        assertThat(venues).hasSize(1);
        assertThat(venues.get(0).getPostcode()).isEqualTo("00100");
    }
    
    @Test
    public void createNewVenue() {
    	Venue venue = new Venue("Jaffa-Halli", "Areenakuja 1", "00250", "Helsinki");
    	repository.save(venue);
    	assertThat(venue.getVenueid()).isNotNull();
    }    

}
