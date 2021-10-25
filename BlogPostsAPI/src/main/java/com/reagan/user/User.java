/*
 * This is a POJO Template for a User that is in the network
 * 
 */
package com.reagan.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.reagan.location.Location;

@Entity
public class User {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id//PrimaryKey
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	@ManyToOne //Foreign link Relationship
	private Location location;
	
	public User() {}
	
	public User(Long id, 
				String firstName, 
				String lastName, 
				String email, 
				Location location) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	

}
