package swd4ta022.ticketguru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LipputyyppiRepository extends CrudRepository<Lipputyyppi, Long>{
	List<Lipputyyppi> findByname(String tyyppi_kuvaus);
	Lipputyyppi findByid(Long id);
}
