/*
 * This is a POJO Template for a Location description of any user in the network
 * 
 */
package com.reagan.location;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
	
	@Id //PrimaryKey
	private String id;
	private String locationName;
	
	public Location() {}
	
	public Location(String id, String locationName) {
		super();
		this.id = id;
		this.locationName = locationName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
}
