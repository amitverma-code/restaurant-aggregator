package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.model.Restaurant;
import com.cts.repository.RestaurantListRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
class RestaurantListServiceTest {
@Autowired
private RestaurantListService restaurantListService;
@MockBean
RestaurantListRepository restaurantListRepository;
@Test
public void getAllRestaurantTest(){
	when(restaurantListRepository.findAll()).thenReturn(Stream
			.of(new Restaurant("344","eatgood","bangalore","A.A Raman","north Indian","9/10"),new Restaurant("345","eatbest","bangalore","B.B Raman","north Indian","8/10")).collect(Collectors.toList()));
assertEquals(2, restaurantListService.getAllRestaurant().size());
}
@Test
public void findByrestaurantNameTest() {
	String name= "goodfood";
	when(restaurantListRepository.findByrestaurantNameContaining(name)).thenReturn(Stream.of(new Restaurant("344","goodfood","bangalore","A.A Raman","north Indian","9/10")).collect(Collectors.toList()));
	assertEquals(1, restaurantListService.findByRestaurantName(name).size());
}
@Test
public void deleteTest(){
	Restaurant restaurant = new Restaurant("344","goodfood","bangalore","A.A Raman","north Indian","9/10");
	restaurantListRepository.delete(restaurant);
	verify(restaurantListRepository, times(1)).delete(restaurant);
}

}

