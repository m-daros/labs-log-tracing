package mdaros.labs.spring.cloud.sleuthsampleupstreamservice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import mdaros.labs.spring.cloud.sleuthsampleupstreamservice2.model.Address;
import mdaros.labs.spring.cloud.sleuthsampleupstreamservice2.repository.AddressRepository;

@EnableJpaRepositories
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private AddressRepository addressRepository;
	
	
	public static void main ( String [] args ) {

		SpringApplication.run ( Application.class, args );
	}

	@Override
	public void run ( String... args ) throws Exception {

		addressRepository.save ( new Address ( "address-0001", "Italy", "Milan", "via Larga 3", 20154, "customer-0001" ) );
		addressRepository.save ( new Address ( "address-0002", "Italy", "Milan", "via Mazzini 22", 20152, "customer-0002" ) );
		addressRepository.save ( new Address ( "address-0003", "Italy", "Rome", "via del corso 34", 00120, "customer-0003" ) );
		addressRepository.save ( new Address ( "address-0004", "Italy", "Rome", "piazza di Spagna 5", 00100, "customer-0004" ) );
		addressRepository.save ( new Address ( "address-0005", "Italy", "Milan", "viale Umbria 123", 20156, "customer-0005" ) );
	}
}