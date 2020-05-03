package com.cts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.Restaurant;

public interface RestaurantListRepository extends CrudRepository<Restaurant, Long>{
	List<Restaurant> findByrestaurantName(String name);
}