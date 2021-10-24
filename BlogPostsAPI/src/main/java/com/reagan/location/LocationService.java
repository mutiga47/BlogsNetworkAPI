package com.reagan.location;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

//	Location location1 = new Location("l1",
//									  "Lagos");
//
//	Location location2 = new Location("l2",
//		    						  "Nairobi");
//	Location location3 = new Location("l3",
//									  "Mombasa");
//	
//	private List<Location> locations = new ArrayList<>(Arrays.asList(location1, 
//														     	     location2,
//																     location3));

	public List<Location> getAllLocations(){
		List<Location> locations = new ArrayList<>();
		
		locationRepository.findAll().forEach(locations::add);
		
		return locations;
	}

	public Optional<Location> getLocationById(String id) {
		return locationRepository.findById(id);
	}

	public void addLocation(Location location) {
		locationRepository.save(location);
	}

	public void updateLocation(String id, 
							   Location location) {
		locationRepository.save(location);
	}

	public void deleteLocation(String id) {
		locationRepository.deleteById(id);
	}

}
