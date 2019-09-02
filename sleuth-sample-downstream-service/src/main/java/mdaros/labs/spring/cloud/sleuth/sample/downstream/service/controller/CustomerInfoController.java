package mdaros.labs.spring.cloud.sleuth.sample.downstream.service.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import mdaros.labs.spring.cloud.sleuth.sample.downstream.service.model.Address;
import mdaros.labs.spring.cloud.sleuth.sample.downstream.service.model.Customer;
import mdaros.labs.spring.cloud.sleuth.sample.downstream.service.model.CustomerInfo;

@RestController
public class CustomerInfoController {

	private static final Logger logger = LoggerFactory.getLogger ( CustomerInfoController.class );

	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping ( method = RequestMethod.GET, path = "/customers-info/{id}" )
	public Optional<Customer> getCustomer ( @PathVariable ( "id" ) String id ) {
		
		logger.info ( "GET /customers-info/{}", id );
		
		ResponseEntity<Customer> customerResponse = restTemplate.exchange ( "http://localhost:8080/customers/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<Customer> () {} );

		Customer customer;
		
		if ( HttpStatus.OK.equals ( customerResponse.getStatusCode () ) ) {
			
			customer = customerResponse.getBody ();
		}
		else {
			
			logger.info ( "Customer not found using id: {}", id );
			
			return Optional.empty ();
		}
		
		ResponseEntity<List<Address>> addressesResponse = restTemplate.exchange ( "http://localhost:9090/addresses/customer/" + id, HttpMethod.GET, null, new ParameterizedTypeReference<List<Address>> () {} );
		
		List<Address> addresses = addressesResponse.getBody ();
		
		CustomerInfo customerInfo = new CustomerInfo ( customer, addresses );
		
		return Optional.of ( customerInfo );
	}
}