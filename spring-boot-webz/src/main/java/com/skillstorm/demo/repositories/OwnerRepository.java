package com.skillstorm.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.demo.models.Owner;
import com.skillstorm.demo.models.Pet;

@Repository
public interface OwnerRepository extends PagingAndSortingRepository<Owner, Integer>{

	// Select the pet object from the pet class where the pet.getOwner().getId() == id
	// ?1 means use the first parameter in the method
	@Query("select p from Pet p where p.owner.id = ?1")
	public List<Pet> findPetsByOwnerId(int id);
}
