package com.capgemini.annapurna.restaurant.entity;

/**
 * @author ugawari
 *
 * This Entity have address related information of restaurants.
 */
public class Address {
	
	private String area;
	private String city;
	private String state;
	private String country;
	private int pincode;
	
	/**
	 * Default constructor to create object.
	 */
	public Address() {
		super();
	}
	
	/**
	 * 
	 * @param area
	 * @param city
	 * @param state
	 * @param country
	 * @param pincode
	 */
	public Address(String area, String city, String state, String country, int pincode) {
		super();
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [area=" + area + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
				+ pincode + "]";
	}
	
}
