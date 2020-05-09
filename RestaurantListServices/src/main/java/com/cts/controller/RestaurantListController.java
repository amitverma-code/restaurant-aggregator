package com.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Restaurant;
import com.cts.service.RestaurantListService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class RestaurantListController {
	
	@Autowired
	RestaurantListService restaurantListService;
	
	@GetMapping("/restaurants")
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
	public void addRestaurant(@Valid @RequestBody Restaurant restaurant) {
     restaurantListService.addRestaurant(restaurant);
	}
	
	
	@ApiOperation(value= "find restaurant from restaurants list",
			notes="use restaurant's name for searching",
			response = Restaurant.class)
	@RequestMapping(value = "/restaurants/{name}", method = RequestMethod.GET)
	public List<Restaurant> getRestaurantByrestaurantName(@ApiParam(value="Name value for the restaurant you need to retrieve", required= true)@PathVariable String name) {
		return restaurantListService.findByrestaurantName(name) ;
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
	
}