package com.hlaing.jackson;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.hlaing.jackson.entity.Address;
import com.hlaing.jackson.entity.Employee;
import com.hlaing.jackson.jsonreader.ObjectMappingDemo;

public class JacksonTest {
	final Employee emp = new Employee();
	
	@BeforeMethod
	public void setUpEmployee() {
		Address address=new Address();
	      address.setStreet("Lake Park Road");
	      address.setCity("Phoenix");
	      address.setZipcode(85003);
	      emp.setId(124);
	      emp.setName("Alice Celci");
	      emp.setAge(24);
	      emp.setSalary(new BigDecimal(1800));
	      emp.setDesignation("UI Designer");
	      emp.setAddress(address);
	      emp.setPhoneNumbers(new long[]{246802});
	      Map<String, String> infoMap = new HashMap<>();
	      infoMap.put("gender", "Female");
	      infoMap.put("maritialstatus", "Unmarried");
	      emp.setPersonalInformation(infoMap);
	}
	
	@Test (enabled = false)
	public void testReadJsonWithObjectMapper() throws JsonParseException, JsonMappingException, IOException {
		final ObjectMappingDemo obj = new ObjectMappingDemo();
		obj.readJsonWithObjectMapper();
	}
	
	@Test (enabled = false)
	public void testObjectMappertoMap() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		final ObjectMappingDemo obj = new ObjectMappingDemo();
		obj.objectMappertoMap();
	}
	
	@Test (enabled = false)
	public void testReadDataWithJsonNode() throws JsonProcessingException, IOException {
		final ObjectMappingDemo obj = new ObjectMappingDemo();
		JsonNode rootNode = obj.readJsonWithJsonNode();
		assertNotNull(rootNode);
		
		String name = obj.readNameNode();
		assertEquals("Henry Smith", name);
		
		Map<String, String> addressMap = obj.readPersonalInformation();
		assertEquals(2, addressMap.size());
		
		Iterator<JsonNode> phoneNode = obj.readPhoneNumbers();
		assertNotNull(phoneNode);
	}
	
	@Test (enabled = true)
	public void testWriteEmployeeToJson() throws JsonProcessingException, IOException {
		final ObjectMappingDemo obj = new ObjectMappingDemo();
		obj.writeEmployeeToJson(emp);
	}

}
