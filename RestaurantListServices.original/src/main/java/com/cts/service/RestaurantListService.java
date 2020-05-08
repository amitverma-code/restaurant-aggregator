package com.cts.service;
import java.util.List;
import java.util.Optional;

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

	public Optional<Restaurant> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleterestaurantById(Integer id) {
		// TODO Auto-generated method stub
		
	}


//
//	public void deleterestaurantById(Integer id) {
//		restaurantListRepository.deleteById(id);
//
//	
//}

	

	
}

