package com.hibernateJPAcourse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernateJPAcourse.model.Location;
import com.hibernateJPAcourse.model.User;
import com.hibernateJPAcourse.service.LocationService;

@RestController
public class LocationController {
	
	@Autowired
	
	private LocationService locationService;
	
	@GetMapping("/locations")
	public List<Location> getAllLocations(){	
		return locationService.findAll();
	}

	@GetMapping("/location/{id}")
	public Optional<Location> getLocationById(@PathVariable Integer id) {
		return locationService.getById(id);
	}
	
	@GetMapping("/location/{id}/users")
	public List<User> GetUsersByLocation(@PathVariable Integer id) {
	    Optional<Location> location = locationService.getById(id);
	    if(location.isPresent()) {
		return location.get().getUsers();
	    }		
	    return null;
	}
	
	
	@PostMapping("/location/addNew")
	public void AddLocation(@RequestBody Location location) {
		
		locationService.AddLocation(location);
		
	}
	
	@PutMapping("/location/{id}/update")
	public void updateLocation(@RequestBody Location location ) {
		locationService.updateLocation(location);
	}
	
	@DeleteMapping("/location/{id}/delete")
	public void deleteLocation(@PathVariable Integer id) {
		locationService.deleteLocation(id);	
	}
}
