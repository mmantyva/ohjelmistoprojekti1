package swd4ta022.ticketguru.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	List<Transaction> findByTrid(long trid);

}
