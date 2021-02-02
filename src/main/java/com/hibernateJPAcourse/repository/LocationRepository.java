package com.hibernateJPAcourse.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hibernateJPAcourse.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location,Integer> {

	

	
}
