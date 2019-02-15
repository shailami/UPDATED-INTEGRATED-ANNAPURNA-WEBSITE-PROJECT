package com.capgemini.annapurna.restaurant.entity;

import java.util.Set;


public class Cart {

	private int cartId;
	private String restaurantName;
	private Set<FoodProducts> products;
	private double totalAmount;
	private Address address;
	
	// private int quantity;
	// private Set<Product> products;
//	private String foodName;
//	private double price;
//	private Set<String> foodPhotos;
//	private Address address;

	public Cart() {
		
	}
	
	public Cart(int cartId, String restaurantName, Set<FoodProducts> products, double totalAmount, Address address) {
		super();
		this.cartId = cartId;
		this.restaurantName = restaurantName;
		this.products = products;
		this.totalAmount = totalAmount;
		this.address = address;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Set<FoodProducts> getProducts() {
		return products;
	}

	public void setProducts(Set<FoodProducts> products) {
		this.products = products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", restaurantName=" + restaurantName + ", products=" + products
				+ ", totalAmount=" + totalAmount + ", address=" + address + "]";
	}



}
