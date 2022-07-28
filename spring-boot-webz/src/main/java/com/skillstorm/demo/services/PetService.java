package com.skillstorm.demo.services;

import java.util.Set;

import com.skillstorm.demo.models.Pet;

public interface PetService {

	Set<Pet> findAllOwnerlessPets();
	Pet findById(int id);
	Pet save(Pet pet);
	Pet update(Pet pet);
	void deleteById(int id);
}
