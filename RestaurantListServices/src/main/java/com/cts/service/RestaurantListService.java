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
	
	public void saveRestaurant(Restaurant restaurantList) {
		restaurantListRepository.save(restaurantList);
	}
	@Transactional
	public List<Restaurant> findByrestaurantName(String name) {
		return restaurantListRepository.findByrestaurantName(name);
	}
	@Transactional
	public boolean updateRestaurant(Restaurant restaurant) {
		return restaurantListRepository.save(restaurant) != null;
	}
	@Transactional
	public void delete(Restaurant restaurant) {
		restaurantListRepository.delete(restaurant);
	}

	//remaining catch exception

	
}

