package com.cts.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.IdException;
import com.cts.model.Restaurant;
import com.cts.service.RestaurantListService;
import com.cts.exception.ErrorMessage;
import com.cts.exception.IdException;
import com.cts.model.Restaurant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class RestaurantListController {
	
	@Autowired
	RestaurantListService restaurantListService;
	
	@GetMapping("/restaurantss")
	@ApiOperation(value= "find all restaurants",
	notes="Return all restaurant with there detail",
	response = Restaurant.class)
	public List<Restaurant> getRestaurant(){
		return restaurantListService.getAllRestaurant();
	}
	
	
	@ApiOperation(value= "update restaurants list",
			notes="pust new restaurant into the list",
			response = Restaurant.class)
	@PostMapping("/restaurants")
	public void addRestaurant(@RequestBody Restaurant restaurant) {
     restaurantListService.addRestaurant(restaurant);
	}
	
	
	@ApiOperation(value= "find restaurant from restaurants list",
			notes="use restaurant's name for searching",
			response = Restaurant.class)
	@RequestMapping(value = "/restaurants/{name}", method = RequestMethod.GET)
	public List<Restaurant> getRestaurantByrestaurantName(@ApiParam(value="Name value for the restaurant you need to retrieve", required= true)@PathVariable String name) {
		return restaurantListService.findByrestaurantName(name);
	}
	
	
	@ApiOperation(value= "update exisiting restaurant",
			notes="update restaurant which is already in database",
			response = Restaurant.class)
	@RequestMapping(value = "/restaurants", method = RequestMethod.PUT)
	public HttpStatus updateRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantListService.updateRestaurant(restaurant)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@ApiOperation(value= "delete restaurant from list",
			notes="delete existing restaurant from restaurants list",
			response = Restaurant.class)
	@RequestMapping(value = "/restaurants", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestBody Restaurant restaurant) {
		restaurantListService.delete(restaurant);
		return "deleted";
	}
	
	@ExceptionHandler
	public ResponseEntity<com.cts.exception.ErrorMessage> handleError1(IdException ine)
	{
		com.cts.exception.ErrorMessage errorMessage=new com.cts.exception.ErrorMessage();
		errorMessage.setMessage(ine.getMessage());
		errorMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorMessage.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<com.cts.exception.ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<com.cts.exception.ErrorMessage> handleError2(Exception e)
	{
		com.cts.exception.ErrorMessage errorMessage=new com.cts.exception.ErrorMessage();
		errorMessage.setMessage(e.getMessage());
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<com.cts.exception.ErrorMessage>(errorMessage,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getrestaurant/{id}")
	public Optional<Restaurant> findById(@PathVariable Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Restaurant> restaurant1=restaurantListService.findById(id);
		if(!restaurant1.isPresent())
		{
			throw new IdException("Item not found with id: "+id);
		}
		return restaurantListService.findById(id);
	}
	
	@DeleteMapping("/deleterestaurant/{id}")
	public void deleteById(@PathVariable Integer id) {
		if(restaurantListService.findById(id)!=null) {
			restaurantListService.deleterestaurantById(id);
		}
	else {
		throw new IdException("Restaurant not found with id: "+id);
	}
	}
//	
//	@PutMapping("/restaurant/{id}")
//	public Restaurant updateMenuById(@RequestBody Restaurant , @PathVariable Integer id) {
//	if(restaurantListService.findById(id)!=null) {
//		restaurantListService.createRestaurant(restaurant);
//	}
//	else  {
//			throw new IdException("Restaurant not found with id: "+id);
//		}
//	return restaurant;
//	}
//	
	
}