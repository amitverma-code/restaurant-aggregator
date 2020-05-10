package com.cts.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.model.Restaurant;
import com.cts.repository.RestaurantListRepository;

@Service
@Transactional
public class RestaurantListService {
    
	@Autowired
	RestaurantListRepository restaurantListRepository;
	
	public List<Restaurant> getAllRestaurant(){
		return (List<Restaurant>) restaurantListRepository.findAll();
	}
	
	public void addRestaurant(Restaurant restaurant) {
		restaurantListRepository.save(restaurant);
	}
	@Transactional
	public List<Restaurant> findByRestaurantName(String name) {
		return restaurantListRepository.findByrestaurantNameContaining(name);
	}
	@Transactional
	public List<Restaurant> findByRestaurantID(String id) {
		return restaurantListRepository.findByrestaurantId(id);
	}
	@Transactional
	public boolean updateRestaurant(Restaurant restaurant) {
		return restaurantListRepository.save(restaurant) != null;
	}
	@Transactional
	public void delete(Restaurant restaurant) {
		restaurantListRepository.delete(restaurant);
	}

	

	
}

