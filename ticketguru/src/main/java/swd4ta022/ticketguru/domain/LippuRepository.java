package swd4ta022.ticketguru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface LippuRepository extends CrudRepository<Lippu, Long> {
	
	List<Lippu> findByLippuid(String lippuid);
	

}
