package com.cts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.jpa.repository.Temporal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Getter
@Setter
@ApiModel(description= "Details about the Restaurants")
@Entity
@Table(name = "restaurant_data")
public class Restaurant{
	@ApiModelProperty(notes = "The Restaurant's ID which is unique")
	@Id
	@NotEmpty(message="RestaurantId is must")
	private String restaurantId;
	
	@ApiModelProperty(notes = "The Restaurant's name")
	@NotBlank(message="RestaurantName cannot be blank or null")
	private String restaurantName;
	
	@NotBlank(message="Address cannot be blank")
	@ApiModelProperty(notes = "The Restaurant's Address")
	private String restaurantAddress;
	
	@ApiModelProperty(notes = "The Restaurant's  owner name")
    private String restaurantOwner;
	
	@NotBlank(message="RestaurantType is must to fill")
	@ApiModelProperty(notes = "The Restaurant's type")
    private String restaurantType;
	@ApiModelProperty(notes = "The Restaurant's rating")
    private String restaurantRating;

	@Override
	public String toString() {
		return "restaurant_data [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantAddress=" + restaurantAddress + ", restaurantOwner=" + restaurantOwner
				+ ", restaurantType=" + restaurantType + ", restaurantRating=" + restaurantRating + "]";
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(String restaurantId, String restaurantName, String restaurantAddress, String restaurantOwner,
			String restaurantType, String restaurantRating) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantOwner = restaurantOwner;
		this.restaurantType = restaurantType;
		this.restaurantRating = restaurantRating;
	}
    
    
}