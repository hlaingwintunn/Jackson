package com.hlaing.jackson.entity;

public class Address {

	private String street;
	private String city;
	private int zipCode;
	
	public Address() {}

	public Address(String street, String city, int zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return getStreet() + ", " + getCity() + ", " + getZipCode();
	}

}
