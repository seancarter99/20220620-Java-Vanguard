package com.skillstorm.demo.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.demo.models.Pet;

/*
 * Three choices for JPA Repositories
 * 
 * 1. CrudRepository (Strictly deals with CRUD operations) (Top level)
 * 2. PagingAndSortingRepository (Does everything CrudRepository does, but also handle pagination)
 * 3. JpaRepository (Does everything the first two do, but also allows batch updates)
 */

@Repository
//                                                  Type, IdType
public interface PetRepository extends JpaRepository<Pet, Integer> {

	// "SELECT * FROM pets WHERE owner_id IS NULL;"
	public Set<Pet> findByOwnerIsNull();
}
