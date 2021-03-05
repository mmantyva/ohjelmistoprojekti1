package swd4ta022.ticketguru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LipputyyppiRepository extends CrudRepository<Lipputyyppi, Long>{
	List<Lipputyyppi> findByTyyppiid(Long tyypiid);
}
