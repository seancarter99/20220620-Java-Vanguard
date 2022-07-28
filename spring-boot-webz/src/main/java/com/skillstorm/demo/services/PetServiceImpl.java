package com.skillstorm.demo.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.demo.models.Pet;
import com.skillstorm.demo.repositories.PetRepository;

@Service
@Primary
@Transactional // Adds @Transactional to all methods of this class
// @Transactional says that if any error/exception is thrown during execution. Changes are rolled back
// If the function exits normally (no exception thrown) then the transaction is committed
// Adds @AfterThrowing advice that monitors your transaction and basically says conn.rollback if an error occurs
// Adds @AfterReturing advice that monitors if it returns successfully. Basically says conn.commit
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository repository;
	
	@Override
	public Set<Pet> findAllOwnerlessPets() {
		return repository.findByOwnerIsNull();
		
		// This is bad, I force the database to grab everything and then I toss most of the results
//		for (Pet pet : repository.findAll()) {
//			if (pet.getOwner() == null) {}
//		};
	}

	@Override
	public Pet findById(int id) {
		// Optionals hold null or the pet itself
		Optional<Pet> pet = repository.findById(id);
		// If the optional has a pet, return it, otherwise return null
		return pet.isPresent() ? pet.get() : null;
	}

	@Override
	public Pet save(Pet pet) {
		return repository.save(pet);
	}

	@Override
	public Pet update(Pet pet) {
		// May be additional business logic to alter the owner of the pet
		// Make a query to OwnerRepository to remove pet from list of pets in event of removal
		return repository.save(pet);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}
}
