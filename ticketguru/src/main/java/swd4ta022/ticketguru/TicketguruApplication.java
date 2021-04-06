package swd4ta022.ticketguru;

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
import swd4ta022.ticketguru.domain.Appuser;
import swd4ta022.ticketguru.domain.AppuserRepository;
import swd4ta022.ticketguru.domain.Venue;
import swd4ta022.ticketguru.domain.VenueRepository;


@SpringBootApplication
public class TicketguruApplication {


	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}
	 
}
