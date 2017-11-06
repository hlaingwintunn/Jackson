package com.hlaing.jackson.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

public class Employee {

	private int id;
	private String name;
	private int age;
	private BigDecimal salary;
	private String designation;
	private Address address;
	private long[] phoneNumbers;
	private Map<String, String> personInformation;

	public Employee() {
	}

	public Employee(int id, String name, int age, BigDecimal salary, String designation, Address address,
			long[] phoneNumbers, Map<String, String> personInformation) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
		this.personInformation = personInformation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long[] getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(long[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Map<String, String> getPersonInformation() {
		return personInformation;
	}

	public void setPersonInformation(Map<String, String> personInformation) {
		this.personInformation = personInformation;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("\n----------Personal Information----------\n");
		sb.append("ID: " + getId() + "\n");
		sb.append("Name: " + getName() + "\n");
		sb.append("Age: " + getAge() + "\n");
		sb.append("Salary: $" + getSalary() + "\n");
		sb.append("Description: " + getDesignation() + "\n");
		sb.append("Phone Numbers: "+ Arrays.toString(getPhoneNumbers())+ "\n");
		sb.append("Address: "+ getAddress() + "\n");
		sb.append("Personal Information: "+ getPersonInformation() + "\n");
		sb.append("***********************************************");
		
		return sb.toString();
	}

}
