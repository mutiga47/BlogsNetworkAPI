/*
 * This is a POJO Template for a Location description of any user in the network
 * 
 */
package com.reagan.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id //PrimaryKey
	private Long id;
	private String locationName;
	
	public Location() {}
	
	public Location(Long id, String locationName) {
		super();
		this.id = id;
		this.locationName = locationName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
}
