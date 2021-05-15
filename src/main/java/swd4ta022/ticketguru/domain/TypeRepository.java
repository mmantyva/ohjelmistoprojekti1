package swd4ta022.ticketguru.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long>{
	List<Type> findByTypename(String typename);
	List<Type> findByVent(Vent event);
}
