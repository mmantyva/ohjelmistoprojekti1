package swd4ta022.ticketguru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VentRepository extends CrudRepository<Vent, Long> {

	List<Vent> findByVentname(String ventname);
}
