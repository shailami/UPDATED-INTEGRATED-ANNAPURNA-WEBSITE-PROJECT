/**
 * 
 */
package com.capgemini.annapurna.restaurant.entity;
import java.util.Set;

/**
 * @author ugawari
 *
 * FoodItem Entity have all information about food like food name, category, price.
 * And photos to get better idea of restaurant.
 */
public class FoodItem {

	private String foodName;
	private boolean veg;
	private Double price;
	private String description;
	private Set<String> foodPhotos;
	
	/**
	 * Default constructor to create object.
	 */
	public FoodItem() {
		
	}

	/**
	 * 
	 * @param foodName
	 * @param veg
	 * @param price
	 * @param description
	 * @param foodPhotos
	 */
	public FoodItem(String foodName, boolean veg, Double price, String description, Set<String> foodPhotos) {
		super();
		this.foodName = foodName;
		this.veg = veg;
		this.price = price;
		this.description = description;
		this.foodPhotos = foodPhotos;
	}

	public String getFoodName() {
		return foodName;
	}
	
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public boolean isVeg() {
		return veg;
	}
	
	public void setVeg(boolean veg) {
		this.veg = veg;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<String> getFoodPhotos() {
		return foodPhotos;
	}
	
	public void setFoodPhotos(Set<String> foodPhotos) {
		this.foodPhotos = foodPhotos;
	}

	/**
	 * Hash code and equals methods are added to avoid duplicate entry of restaurants in same area.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
		result = prime * result + (veg ? 1231 : 1237);
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
		FoodItem other = (FoodItem) obj;
		if (foodName == null) {
			if (other.foodName != null)
				return false;
		} else if (!foodName.equals(other.foodName))
			return false;
		if (veg != other.veg)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FoodItem [foodName=" + foodName + ", veg=" + veg + ", price=" + price + ", description=" + description
				+ ", foodPhotos=" + foodPhotos + "]";
	}
	
}
