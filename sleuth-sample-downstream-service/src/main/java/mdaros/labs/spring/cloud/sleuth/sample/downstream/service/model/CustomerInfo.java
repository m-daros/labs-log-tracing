package mdaros.labs.spring.cloud.sleuth.sample.downstream.service.model;

import java.util.List;

public class CustomerInfo extends Customer {

	private List<Address> addresses;

	
	public CustomerInfo () {
		
	}
	
	public CustomerInfo ( Customer customer, List<Address> addresses ) {

		super ( customer.getId (), customer.getName (), customer.getSurname () );
		this.addresses = addresses;
	}

	public List<Address> getAddresses () {
	
		return addresses;
	}
	
	public void setAddresses ( List<Address> addresses ) {
	
		this.addresses = addresses;
	}

	@Override
	public String toString () {

		StringBuilder builder = new StringBuilder ();
		builder.append ( "CustomerInfo [addresses=" );
		builder.append ( addresses );
		builder.append ( ", getId()=" );
		builder.append ( getId () );
		builder.append ( ", getName()=" );
		builder.append ( getName () );
		builder.append ( ", getSurname()=" );
		builder.append ( getSurname () );
		builder.append ( "]" );
		
		return builder.toString ();
	}



	
}