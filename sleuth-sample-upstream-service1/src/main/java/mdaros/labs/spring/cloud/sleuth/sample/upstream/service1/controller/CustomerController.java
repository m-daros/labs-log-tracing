package mdaros.labs.spring.cloud.sleuth.sample.upstream.service1.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mdaros.labs.spring.cloud.sleuth.sample.upstream.service1.model.Customer;
import mdaros.labs.spring.cloud.sleuth.sample.upstream.service1.repository.CustomerRepository;

@RestController
public class CustomerController {

	
	private static final Logger logger = LoggerFactory.getLogger ( CustomerController.class );

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping ( method = RequestMethod.GET, path = "/customers/{id}" )
	public ResponseEntity<Customer> getCustomer ( @PathVariable ( "id" ) String id ) {
		
		logger.info ( "GET /customers/{}", id );
		
		Optional<Customer> result = customerRepository.findById ( id );
		
		logger.info ( "RESULT: {}", result );
		
		if ( ! result.isPresent () ) {
			
			return new ResponseEntity<Customer> ( HttpStatus.NOT_FOUND );
		}
		
		return new ResponseEntity<Customer> ( result.get (), HttpStatus.OK );
	}
}