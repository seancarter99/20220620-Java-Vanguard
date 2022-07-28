package com.skillstorm.demo.services;

import java.util.List;

import com.skillstorm.demo.models.Owner;
import com.skillstorm.demo.models.Pet;

public interface OwnerService {

	// Paginate this baby
	List<Owner> findAll(int page, int limit);
	Owner findById(int id);
	List<Pet> findPetsByOwnerId(int id);
	Owner save(Owner owner);
}
