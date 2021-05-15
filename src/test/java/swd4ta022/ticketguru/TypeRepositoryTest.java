
package swd4ta022.ticketguru;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd4ta022.ticketguru.domain.TicketType;
import swd4ta022.ticketguru.domain.TypeRepository;
import swd4ta022.ticketguru.domain.Vent;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TypeRepositoryTest {

    @Autowired
    private TypeRepository repository;

    @Test
    public void findByNameShouldReturnType() {
        List<TicketType> types = repository.findByTypename("Student");
        
        assertThat(types).hasSize(1);
        assertThat(types.get(0).getPrice()).isEqualTo(15.0);
    }
    
    @Test
    public void createNewType() {
    	TicketType type = new TicketType("Really old person", 100.0, null);
    	repository.save(type);
    	assertThat(type.getTypeid()).isNotNull();
    }    

}