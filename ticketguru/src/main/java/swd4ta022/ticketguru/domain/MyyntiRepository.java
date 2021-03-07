package swd4ta022.ticketguru.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MyyntiRepository extends CrudRepository<Myynti, Long> {
	List<Myynti> findByMyyntiid(Long myyntiid);


}
