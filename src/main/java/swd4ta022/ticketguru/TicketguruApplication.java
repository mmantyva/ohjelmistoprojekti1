package swd4ta022.ticketguru;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd4ta022.ticketguru.TicketguruApplication;

import swd4ta022.ticketguru.domain.Vent;
import swd4ta022.ticketguru.domain.VentRepository;
import swd4ta022.ticketguru.domain.Ticket;
import swd4ta022.ticketguru.domain.TicketRepository;
import swd4ta022.ticketguru.domain.Transaction;
import swd4ta022.ticketguru.domain.TransactionRepository;
import swd4ta022.ticketguru.domain.Type;
import swd4ta022.ticketguru.domain.TypeRepository;
import swd4ta022.ticketguru.domain.Appuser;
import swd4ta022.ticketguru.domain.AppuserRepository;
import swd4ta022.ticketguru.domain.Venue;
import swd4ta022.ticketguru.domain.VenueRepository;


@SpringBootApplication
public class TicketguruApplication {


	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
		
		
	}
	@Bean
	 public CommandLineRunner demo(VentRepository ventrepository, VenueRepository vrepository, TypeRepository typerepository, TransactionRepository trrepository, TicketRepository ticketrepository, AppuserRepository arepository) {
		 return (args)->{
			 
			 Venue venue1 = new Venue("Tavastia", "Urhokekkosenkatu", "00100", "Helsinki");
			 Venue venue2 = new Venue("Finlandiatalo", "Mansku", "00100", "Helsinki");
			 Venue venue3 = new Venue("Lutakko", "Lutakonaukio 3", "40100", "Jyväskylä");
			 vrepository.save(venue1);
			 vrepository.save(venue2);
			 vrepository.save(venue3);
			 
			 Vent event1 = new Vent("Iso D", "11.11.2022", "Danny", "Kuvaus1", 2000, vrepository.findByVenuename("Tavastia").get(0));
			 Vent event2 = new Vent("Konsertti", "22.1.2021. klo. 19", "Armi", "Kuvaus2", 2000, vrepository.findByVenuename("Finlandiatalo").get(0));
			 ventrepository.save(event1);
			 ventrepository.save(event2);
			 
			 Type type1 = new Type("Child", 10.0);
			 Type type2 = new Type("Adult", 30.0);
			 Type type3 = new Type("Student", 15.0);
			 typerepository.save(type1);
			 typerepository.save(type2);
			 typerepository.save(type3);
			 
			 
			 Transaction transaction1 = new Transaction("2021-03-03");
			 trrepository.save(transaction1);

				 //User
				 Appuser appuser = new Appuser("Tuomas", "Martsa", "user", "user",
				 "user"); arepository.save(appuser);
				 

		 };
	 }
}
