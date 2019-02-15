/**
 * 
 */
package com.capgemini.annapurna.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.capgemini.annapurna.restaurant.entity.FoodItem;
import com.capgemini.annapurna.restaurant.entity.Restaurant;

/**
 * @author ugawari
 *
 */
//@Controller
//@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	private RestTemplate restTemplate;

	//@RequestMapping("/")
	public String getAllRestaurants(Model model) {
		ResponseEntity<List> entity = restTemplate.getForEntity("http://localhost:8686/restaurants", List.class);
		model.addAttribute("list", entity.getBody());
		return "Home";
	}

	//@RequestMapping("/foodItems")
	public String getFoodItemsById(Model model, @RequestParam int restaurantId) {
		ResponseEntity<Restaurant> entity = restTemplate
				.getForEntity("http://localhost:8686/restaurants/" + restaurantId, Restaurant.class);
		model.addAttribute("restaurant", entity.getBody());
		return "FoodItems";
	}

	// @SuppressWarnings("unchecked")
	//@RequestMapping("/search")
	public String search(Model model, @RequestParam String search) {
		ResponseEntity<Restaurant[]> entity = restTemplate.getForEntity("http://localhost:8686/restaurants",
				Restaurant[].class);
		List<Restaurant> restaurantlist = Arrays.asList(entity.getBody());
		List<Restaurant> searchedList = new ArrayList<>();
		// List<FoodItem> foodItems = new ArrayList<>();
		for (Restaurant restaurant : restaurantlist) {
			if (restaurant.getName().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			if (restaurant.getAddress().getCity().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			for (FoodItem foodItem : restaurant.getFoodItems()) {
				if (foodItem.getFoodName().equalsIgnoreCase(search))
					searchedList.add(restaurant);
				// foodItems.add(foodItem);
			}
		}
		// System.out.println(foodItems.toString());
		model.addAttribute("list", searchedList);
		return "Home";
	}

}
