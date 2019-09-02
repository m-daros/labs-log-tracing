package mdaros.labs.spring.cloud.sleuth.sample.upstream.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import mdaros.labs.spring.cloud.sleuth.sample.upstream.service1.model.Customer;
import mdaros.labs.spring.cloud.sleuth.sample.upstream.service1.repository.CustomerRepository;

@EnableJpaRepositories
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public static void main ( String [] args ) {

		SpringApplication.run ( Application.class, args );
	}

	@Override
	public void run ( String... args ) throws Exception {

		customerRepository.save ( new Customer ( "customer-0001", "Mario", "Rossi" )  );
		customerRepository.save ( new Customer ( "customer-0002", "Andrea", "Bianchi" )  );
		customerRepository.save ( new Customer ( "customer-0003", "Alessia", "Corini" )  );
		customerRepository.save ( new Customer ( "customer-0004", "Marco", "Recalcati" )  );
		customerRepository.save ( new Customer ( "customer-0005", "Sandra", "Giani" )  );
	}
}