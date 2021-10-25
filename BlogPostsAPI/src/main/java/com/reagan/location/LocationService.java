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

	public List<Location> getAllLocations(){
		List<Location> locations = new ArrayList<>();
		
		locationRepository.findAll().forEach(locations::add);
		
		return locations;
	}

	public Optional<Location> getLocationById(Long id) {
		return locationRepository.findById(id);
	}

	public void addLocation(Location location) {
		locationRepository.save(location);
	}

	public void updateLocation(Long id, 
							   Location location) {
		locationRepository.save(location);
	}

	public void deleteLocation(Long id) {
		locationRepository.deleteById(id);
	}

}
