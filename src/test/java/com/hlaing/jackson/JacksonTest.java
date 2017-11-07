package com.hlaing.jackson;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.hlaing.jackson.jsonreader.ObjectMappingDemo;

public class JacksonTest {
	
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
	
	@Test (enabled = true)
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

}
