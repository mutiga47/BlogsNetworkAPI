package com.reagan.location;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(value="/locations")
	public String getLocations(Model modelLocations){
		List<Location> locations = locationService.getAllLocations();
		
		modelLocations.addAttribute("locations", locations);
		
		return "locations";
	}
	
	@RequestMapping(value="/addLocation")
	public ModelAndView addNewLocation() {
		Location location = new Location();
		
		return new ModelAndView("addLocation", "form", location);
	}
	
	@RequestMapping(value = "/saveLocation", method = RequestMethod.POST)
	public String saveNewPost(Location location) {
		locationService.addLocation(location);
		return ("redirect:/locations");

	}

	@RequestMapping(value="/locations/{id}")
	public Optional<Location> getLocation(@PathVariable Long id) {
		return locationService.getLocationById(id);
	}

	@RequestMapping(method=RequestMethod.POST,
					value="/locations")
	public void insertLocation(@RequestBody Location location) {
		locationService.addLocation(location);
	}
	
	@RequestMapping(value="/locations/{id}", method = RequestMethod.PUT)
	public void modifyLocation(@PathVariable Long id, 
							   @RequestBody Location location) {
		locationService.updateLocation(id, 
									   location);
		
	}
	
	@RequestMapping(value="/locations/{id}", 
					method = RequestMethod.DELETE)
	public void removeLocation(@PathVariable Long id) {
		locationService.deleteLocation(id);
		
	}
}
