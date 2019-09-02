package mdaros.labs.spring.cloud.sleuth.sample.downstream.service.model;

public class Customer {

	private String id;
	private String name;
	private String surname;
	
	
	public Customer () {
		
	}
	
	public Customer ( String id, String name, String surname ) {

		this.id      = id;
		this.name    = name;
		this.surname = surname;
	}

	public String getId () {
	
		return id;
	}

	public void setId ( String id ) {
		
		this.id = id;
	}

	public String getName () {
	
		return name;
	}
	
	public void setName ( String name ) {
		
		this.name = name;
	}
	
	public String getSurname () {
	
		return surname;
	}
	
	public void setSurname ( String surname ) {
		
		this.surname = surname;
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