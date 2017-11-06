package com.hlaing.jackson.jsonreader;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hlaing.jackson.entity.Employee;

public class ObjectMappingDemo {
	private static final Logger logger = LoggerFactory.getLogger(ObjectMappingDemo.class);
	
	public Employee readJsonWithObjectMapper() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		final Employee emp = mapper.readValue(new File("employee.json"), Employee.class);
		logger.info(emp.toString());
		return emp;
	}

}
