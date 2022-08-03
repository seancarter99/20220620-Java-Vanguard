package com.skillstorm.demo.services;

import java.util.List;

import com.skillstorm.demo.models.Park;

public interface ParkService {

	public List<Park> findAll();
	public Park findById(int id);
	public Park create(Park park);
	public Park update(Park park);
	public void deleteById(int id);
}
