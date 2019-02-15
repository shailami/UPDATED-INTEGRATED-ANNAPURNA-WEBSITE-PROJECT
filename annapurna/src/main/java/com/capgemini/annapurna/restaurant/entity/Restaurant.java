/**
 * 
 */
package com.capgemini.annapurna.restaurant.entity;
import java.util.Map;
import java.util.Set;

/**
 * @author ugawari
 *
 * This is main entity to perform operations on restaurant to store and 
 * Retrieve restaurant related data like name, address foods etc.
 * Rating and reviews fields are used give rating and reviews against profile or customer.
 */

public class Restaurant {
	
	private Integer restaurantId;	
	private String name;
	private Address address;
	private Set<FoodItem> foodItems;
	private Map<Integer, Integer> ratings;
	private Map<Integer, String> reviews;
	private String type;
	private Set<String> photos;	

	/**
	 * Default constructor to create object.
	 */
	public Restaurant() {
		super();
	}
	
	public Restaurant(String name, Address address, Set<FoodItem> foodItems, Map<Integer, Integer> ratings,
			Map<Integer, String> reviews, String type, Set<String> photos) {
		super();
		this.name = name;
		this.address = address;
		this.foodItems = foodItems;
		this.ratings = ratings;
		this.reviews = reviews;
		this.type = type;
		this.photos = photos;
	}

	/**
	 * Class constructor specifying number of objects to create.
	 * 
	 * @param restaurantId
	 * @param name
	 * @param address
	 * @param foodItems
	 * @param ratings
	 * @param reviews
	 * @param type
	 * @param photos
	 */
	public Restaurant(Integer restaurantId, String name, Address address, Set<FoodItem> foodItems,
			Map<Integer, Integer> ratings, Map<Integer, String> reviews, String type, Set<String> photos) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.foodItems = foodItems;
		this.ratings = ratings;
		this.reviews = reviews;
		this.type = type;
		this.photos = photos;
	}
	
	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(Set<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

	public Map<Integer, Integer> getRatings() {
		return ratings;
	}

	public void setRatings(Map<Integer, Integer> ratings) {
		this.ratings = ratings;
	}

	public Map<Integer, String> getReviews() {
		return reviews;
	}

	public void setReviews(Map<Integer, String> reviews) {
		this.reviews = reviews;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<String> getPhotos() {
		return photos;
	}

	public void setPhoto(Set<String> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address + ", foodItems="
				+ foodItems + ", ratings=" + ratings + ", reviews=" + reviews + ", type=" + type + ", photos=" + photos
				+ "]";
	}

	/**
	 * Hash code and equals methods are added to avoid duplicate entry of restaurants in same area.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}
