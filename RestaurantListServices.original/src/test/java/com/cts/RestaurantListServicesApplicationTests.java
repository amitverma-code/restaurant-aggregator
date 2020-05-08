package com.cts;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
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
import com.cts.service.RestaurantListService;

import io.swagger.annotations.ApiModelProperty;
@RunWith(SpringRunner.class)
@SpringBootTest
class RestaurantListServicesApplicationTests {
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
	when(restaurantListRepository.findByrestaurantName(name)).thenReturn(Stream.of(new Restaurant("344","goodfood","bangalore","A.A Raman","north Indian","9/10")).collect(Collectors.toList()));
	assertEquals(1, restaurantListService.findByrestaurantName(name).size());
}
@Test
public void deleteTest(){
	Restaurant restaurant = new Restaurant("344","goodfood","bangalore","A.A Raman","north Indian","9/10");
	restaurantListRepository.delete(restaurant);
	verify(restaurantListRepository, times(1)).delete(restaurant);
}

}
