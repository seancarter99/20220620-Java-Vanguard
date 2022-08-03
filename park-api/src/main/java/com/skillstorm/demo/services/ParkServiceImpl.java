package com.skillstorm.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.demo.models.Park;
import com.skillstorm.demo.repositories.ParkRepository;

@Service
@Transactional
public class ParkServiceImpl implements ParkService {

	@Autowired
	private ParkRepository repository;
	
	@Override
	public List<Park> findAll() {
		return (List<Park>) repository.findAll();
	}

	@Override
	public Park findById(int id) {
		Optional<Park> park = repository.findById(id);
		return park.isPresent() ? park.get() : null;
	}

	@Override
	public Park create(Park park) {
		return repository.save(park);
	}

	@Override
	public Park update(Park park) {
		return repository.save(park);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
