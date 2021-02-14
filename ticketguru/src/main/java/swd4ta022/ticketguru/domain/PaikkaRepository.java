package swd4ta022.ticketguru.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PaikkaRepository extends CrudRepository<Paikka, Long> {
	
	List<Paikka> findByName(String paikka_nimi);

}
