package com.capgemini.annapurna.restaurant.entity;


import java.time.LocalDateTime;
import java.util.Set;


/**
 * 
 * @author shailami
 *
 */

public class Order {
	
	
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Indexed(unique = true)
	private Integer orderId;
	private LocalDateTime date;
	private String modeOfPayment;
	private String status;
	private Set<FoodProducts> products;
	private Double totalAmount;
	private String restaurantName;
	private Address deliveryAddress;
	private Integer cartId;
	

	public Order() {
	
	}
	
	public Order(Integer orderId,String modeOfPayment, String status, Set<FoodProducts> products,
			Double totalAmount,  String restaurantName, Address deliveryAddress, Integer cartId) {
		super();
		this.orderId =orderId;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
		this.products = products;
		this.totalAmount = totalAmount;
		
		this.restaurantName = restaurantName;
		this.deliveryAddress = deliveryAddress;
		this.cartId = cartId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<FoodProducts> getProducts() {
		return products;
	}

	public void setProducts(Set<FoodProducts> products) {
		this.products = products;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		
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
		Order other = (Order) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + ", modeOfPayment=" + modeOfPayment + ", status="
				+ status + ", products=" + products + ", totalAmount=" + totalAmount + ", restaurantName="
				+ restaurantName + ", deliveryAddress=" + deliveryAddress + ", cartId=" + cartId + "]";
	}




}
