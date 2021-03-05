package swd4ta022.ticketguru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TapahtumaRepository extends CrudRepository<Tapahtuma, Long> {

	List<Tapahtuma> findByTnimi(String tnimi);
}
