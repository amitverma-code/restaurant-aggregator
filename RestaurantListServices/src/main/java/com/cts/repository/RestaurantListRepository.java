package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cts.model.Restaurant;

public interface RestaurantListRepository extends JpaRepository<Restaurant, Long>{
	List<Restaurant> findByrestaurantNameContaining(String name);
	List<Restaurant> findByrestaurantId(String id);
}