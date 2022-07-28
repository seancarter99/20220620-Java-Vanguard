package com.skillstorm.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.skillstorm.demo.models.Owner;
import com.skillstorm.demo.models.Pet;
import com.skillstorm.demo.repositories.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepository repository;
	
	@Override
	public List<Owner> findAll(int page, int limit) {
		return repository.findAll(PageRequest.of(page, limit)).toList();
	}

	@Override
	public Owner findById(int id) {
		Optional<Owner> owner = repository.findById(id);
		return owner.isEmpty() ? null : owner.get();
	}

	@Override
	public List<Pet> findPetsByOwnerId(int id) {
		// TODO Auto-generated method stub
		return repository.findPetsByOwnerId(id);
	}

	@Override
	public Owner save(Owner owner) {
		return repository.save(owner);
	}
}
