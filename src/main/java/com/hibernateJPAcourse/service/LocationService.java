package com.hibernateJPAcourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernateJPAcourse.model.Location;
import com.hibernateJPAcourse.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	public List<Location> findAll() {
		
		return (List<Location>) locationRepository.findAll();
	}

	public Optional<Location> getById(Integer id) {
		
		return locationRepository.findById(id);
	}

	public void AddLocation(Location location) {
		
		locationRepository.save(location);
		
	}

	public void updateLocation(Location location) {
		locationRepository.save(location);
		
	}

	public void deleteLocation(Integer id) {
		locationRepository.deleteById(id);
		
	}



}
