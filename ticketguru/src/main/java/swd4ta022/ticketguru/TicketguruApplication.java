package swd4ta022.ticketguru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd4ta022.ticketguru.TicketguruApplication;

import swd4ta022.ticketguru.domain.Event;
import swd4ta022.ticketguru.domain.EventRepository;
import swd4ta022.ticketguru.domain.Ticket;
import swd4ta022.ticketguru.domain.TicketRepository;
import swd4ta022.ticketguru.domain.Transaction;
import swd4ta022.ticketguru.domain.TransactionRepository;
import swd4ta022.ticketguru.domain.Type;
import swd4ta022.ticketguru.domain.TypeRepository;
import swd4ta022.ticketguru.domain.Venue;
import swd4ta022.ticketguru.domain.VenueRepository;


@SpringBootApplication
public class TicketguruApplication {
	private static final Logger log = LoggerFactory.getLogger(TicketguruApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}
	 @Bean
	 public CommandLineRunner demo(EventRepository erepository, VenueRepository vrepository, TypeRepository typerepository, TransactionRepository trrepository, TicketRepository ticketrepository) {
		 return (args)->{
			 
			 Venue venue1 = new Venue("Tavastia", "Urhokekkosenkatu", "00100", "Helsinki");
			 Venue venue2 = new Venue("Finlandiatalo", "Mansku", "00100", "Helsinki");
			 Venue venue3 = new Venue("Lutakko", "Lutakonaukio 3", "40100", "Jyväskylä");
			 vrepository.save(venue1);
			 vrepository.save(venue2);
			 vrepository.save(venue3);
			 
			 Event event1 = new Event("Iso D", "22.1.2021. klo. 19", "Danny", "Kuvaus1", 2000, vrepository.findByVenuename("Tavastia").get(0));
			 Event event2 = new Event("Konsertti", "22.1.2021. klo. 19", "Armi", "Kuvaus2", 2000, vrepository.findByVenuename("Finlandiatalo").get(0));
			 erepository.save(event1);
			 erepository.save(event2);
			 
			 Type type1 = new Type("Child", 10.0);
			 Type type2 = new Type("Adult", 30.0);
			 Type type3 = new Type("Student", 15.0);
			 typerepository.save(type1);
			 typerepository.save(type2);
			 typerepository.save(type3);
			 
			 // event, type, transaction
			 Ticket ticket1 = new Ticket();
			 ticketrepository.save(ticket1);
			 
			 Transaction transaction1 = new Transaction("2021-03-03");
			 trrepository.save(transaction1);

		 };
	 }
	
}
