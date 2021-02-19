package swd4ta022.ticketguru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd4ta022.ticketguru.TicketguruApplication;
import swd4ta022.ticketguru.domain.LippuRepository;
import swd4ta022.ticketguru.domain.LipputyyppiRepository;
import swd4ta022.ticketguru.domain.MyyntiRepository;
import swd4ta022.ticketguru.domain.PaikkaRepository;
import swd4ta022.ticketguru.domain.TapahtumaRepository;


@SpringBootApplication
public class TicketguruApplication {
	private static final Logger log = LoggerFactory.getLogger(TicketguruApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}
	
	
}
