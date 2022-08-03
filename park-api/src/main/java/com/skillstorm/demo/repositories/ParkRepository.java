package com.skillstorm.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.demo.models.Park;

@Repository
public interface ParkRepository extends CrudRepository<Park, Integer> {

}
