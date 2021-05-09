package swd4ta022.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<TicketType, Long>{
	List<TicketType> findByTypename(String typename);
	List<TicketType> findByVent(Vent event);
}