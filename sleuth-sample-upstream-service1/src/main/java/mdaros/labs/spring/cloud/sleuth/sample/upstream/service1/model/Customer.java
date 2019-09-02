package mdaros.labs.spring.cloud.sleuth.sample.upstream.service1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private String id;
	private String name;
	private String surname;
	
	
	public Customer () {
		
	}
	
	public Customer ( String id, String name, String surname ) {

		this ();
		this.id      = id;
		this.name    = name;
		this.surname = surname;
	}

	public String getId () {
	
		return id;
	}
	
	public String getName () {
	
		return name;
	}
	
	public String getSurname () {
	
		return surname;
	}

	@Override
	public String toString () {

		StringBuilder builder = new StringBuilder ();
		builder.append ( "Customer [id=" );
		builder.append ( id );
		builder.append ( ", name=" );
		builder.append ( name );
		builder.append ( ", surname=" );
		builder.append ( surname );
		builder.append ( "]" );
		
		return builder.toString ();
	}
}