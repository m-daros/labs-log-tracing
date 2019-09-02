package mdaros.labs.spring.cloud.sleuthsampleupstreamservice2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mdaros.labs.spring.cloud.sleuthsampleupstreamservice2.model.Address;
import mdaros.labs.spring.cloud.sleuthsampleupstreamservice2.repository.AddressRepository;

@RestController
public class AddressController {

	private static final Logger logger = LoggerFactory.getLogger ( AddressController.class );

	@Autowired
	private AddressRepository addressRepository;
	
	
	@RequestMapping ( method = RequestMethod.GET, path = "/addresses/customer/{customerId}" )
	public ResponseEntity<List<Address>> getAddresses ( @PathVariable ( "customerId" ) String customerId ) {
		
		logger.info ( "GET /addresses/customer/{}", customerId );
		
		List<Address> result = addressRepository.findByCustomerId ( customerId );
		
		logger.info ( "RESULT: {}", result );
		
		return new ResponseEntity<List<Address>> ( result, HttpStatus.OK ) ;
	}
}