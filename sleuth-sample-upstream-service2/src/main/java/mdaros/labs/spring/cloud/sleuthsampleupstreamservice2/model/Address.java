package mdaros.labs.spring.cloud.sleuthsampleupstreamservice2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	private String id;
	
	private String country;
	private String city;
	private String street;
	private int    zipCode;
	private String customerId;
	
	
	public Address () {
		
	}
	
	public Address ( String id, String country, String city, String street, int zipCode, String customerId ) {

		this.id         = id;
		this.country    = country;
		this.city       = city;
		this.street     = street;
		this.zipCode    = zipCode;
		this.customerId = customerId;
	}
	
	public String getId () {
	
		return id;
	}
	
	public void setId ( String id ) {
	
		this.id = id;
	}
	
	public String getCountry () {
	
		return country;
	}
	
	public void setCountry ( String country ) {
	
		this.country = country;
	}
	
	public String getCity () {
	
		return city;
	}
	
	public void setCity ( String city ) {
	
		this.city = city;
	}

	public String getStreet () {
	
		return street;
	}
	
	public void setStreet ( String street ) {
	
		this.street = street;
	}
	
	public int getZipCode () {
	
		return zipCode;
	}
	
	public void setZipCode ( int zipCode ) {
	
		this.zipCode = zipCode;
	}

	public String getCustomerId () {
	
		return customerId;
	}
	
	public void setCustomerId ( String customerId ) {
	
		this.customerId = customerId;
	}

	@Override
	public String toString () {

		StringBuilder builder = new StringBuilder ();
		builder.append ( "Address [country=" );
		builder.append ( country );
		builder.append ( ", city=" );
		builder.append ( city );
		builder.append ( ", street=" );
		builder.append ( street );
		builder.append ( ", zipCode=" );
		builder.append ( zipCode );
		builder.append ( "]" );
		
		return builder.toString ();
	}
}