package com.hlaing.jackson;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hlaing.jackson.jsonreader.ObjectMappingDemo;

public class JacksonTest {
	
	@Test (enabled = true)
	public void testReadJsonWithObjectMapper() throws JsonParseException, JsonMappingException, IOException {
		final ObjectMappingDemo obj = new ObjectMappingDemo();
		obj.readJsonWithObjectMapper();
	}

}
