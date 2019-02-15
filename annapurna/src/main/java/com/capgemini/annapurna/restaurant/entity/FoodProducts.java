package com.capgemini.annapurna.restaurant.entity;

public class FoodProducts {

	private String foodName;
	private double price;
	private int quantity;

	public FoodProducts(String foodName, double price, int quantity) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.quantity = quantity;
	}

	public FoodProducts() {
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
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
		FoodProducts other = (FoodProducts) obj;
		if (foodName == null) {
			if (other.foodName != null)
				return false;
		} else if (!foodName.equals(other.foodName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FoodProducts [foodName=" + foodName + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
