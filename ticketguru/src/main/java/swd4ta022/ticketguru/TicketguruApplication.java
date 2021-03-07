package swd4ta022.ticketguru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd4ta022.ticketguru.TicketguruApplication;
import swd4ta022.ticketguru.domain.Lippu;
import swd4ta022.ticketguru.domain.LippuRepository;
import swd4ta022.ticketguru.domain.Lipputyyppi;
import swd4ta022.ticketguru.domain.LipputyyppiRepository;
import swd4ta022.ticketguru.domain.Myynti;
import swd4ta022.ticketguru.domain.MyyntiRepository;
import swd4ta022.ticketguru.domain.Paikka;
import swd4ta022.ticketguru.domain.PaikkaRepository;
import swd4ta022.ticketguru.domain.Tapahtuma;
import swd4ta022.ticketguru.domain.TapahtumaRepository;


@SpringBootApplication
public class TicketguruApplication {
	private static final Logger log = LoggerFactory.getLogger(TicketguruApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TicketguruApplication.class, args);
	}
	 @Bean
	 public CommandLineRunner demo(TapahtumaRepository trepository, PaikkaRepository prepository, LipputyyppiRepository ltrepository, MyyntiRepository mrepository, LippuRepository lrepository) {
		 return (args)->{
			 Paikka paikka1 = new Paikka("Tavastia", "Urhokekkosenkatu", "00100", "Helsinki");
			 Paikka paikka2 = new Paikka("Finlandiatalo", "Mansku", "00100", "Helsinki");
			 prepository.save(paikka1);
			 prepository.save(paikka2);
			 
			 Tapahtuma tapahtuma1 = new Tapahtuma("Iso D", "22.1.2021. klo. 19", "Danny", "Kuvaus1", 2000, prepository.findByPnimi("Tavastia").get(0));
			 Tapahtuma tapahtuma2 = new Tapahtuma("Konsertti", "12.2.2021. klo. 21", "Armi", "Kuvaus2", 2000, prepository.findByPnimi("Finlandiatalo").get(0));
			 trepository.save(tapahtuma1);
			 trepository.save(tapahtuma2);
			 
				
			 Lipputyyppi lipputyyppi1 = new Lipputyyppi(10.0, "Lapsi");
			 Lipputyyppi lipputyyppi2 = new Lipputyyppi(40.0, "Aikuinen");
			 Lipputyyppi lipputyyppi3 = new Lipputyyppi(20.0, "Opiskelija");
			 ltrepository.save(lipputyyppi1);
			 ltrepository.save(lipputyyppi2);
			 ltrepository.save(lipputyyppi3);
			 
			 // tapahtuma, tyyppi, myynti
			 Lippu lippu1 = new Lippu(trepository.findByTnimi("Iso D").get(0), ltrepository.findByKuvaus("Lapsi").get(0), null);
			 Lippu lippu2 = new Lippu();
			 Lippu lippu3 = new Lippu();
			 lrepository.save(lippu1);
			 lrepository.save(lippu2);
			 lrepository.save(lippu3);
			  
			 Myynti myynti1 = new Myynti(1, "2021-03-03");
			 mrepository.save(myynti1);
			 

		 };
	 }
	
}
