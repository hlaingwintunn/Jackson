package com.hlaing.jackson.jsonreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hlaing.jackson.entity.Employee;

public class ObjectMappingDemo {
	private static final Logger logger = LoggerFactory.getLogger(ObjectMappingDemo.class);
	
	JsonNode rootNode;
	ObjectMapper objectMapper;
	
	public ObjectMappingDemo() throws JsonProcessingException, IOException {
		objectMapper = new ObjectMapper();
		rootNode = objectMapper.readTree(new File("employee.json"));
	}
	
	public Employee readJsonWithObjectMapper() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		final Employee emp = mapper.readValue(new File("employee.json"), Employee.class);
		logger.info(emp.toString());
		return emp;
	}
	
	public void objectMappertoMap() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		final ObjectMapper objectMapper = new ObjectMapper();
		final Map<?, ?> empMap = objectMapper.readValue(new FileInputStream("employee.json"), Map.class);
		
		for(Map.Entry<?, ?> entry: empMap.entrySet()) {
			logger.info("\n=============================\n"+ entry.getKey() + "=" + entry.getValue() + "\n");
		}
	}
	
	public JsonNode readJsonWithJsonNode() throws JsonProcessingException {
		String prettyPrintEmployee = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        logger.info(prettyPrintEmployee);
		return rootNode;

	}
	
	public String readNameNode() {
		JsonNode nameNode = rootNode.path("name");
		String name = nameNode.asText();
		logger.info("\n==========================\n Employee Name =" + name + "\n");
		return name;
		
	}
	
	public Map<String, String> readPersonalInformation () {
		JsonNode personalInfoNode = rootNode.get("personalInformation");
		Map<String, String> personalInfoMap = objectMapper.convertValue(personalInfoNode, Map.class);
		
		for(Map.Entry<String, String> entry: personalInfoMap.entrySet()) {
			logger.info("\n======================\n"+ entry.getKey() +"="+ entry.getValue() + "\n");
		}
		
		return personalInfoMap;
	}
	
	public Iterator<JsonNode> readPhoneNumbers() {
		JsonNode phoneNumbersNode = rootNode.path("phoneNumbers");
		Iterator<JsonNode> elements = phoneNumbersNode.elements();
		
		while(elements.hasNext()) {
			JsonNode phoneNode = elements.next();
			logger.info("\n============================\n Phone Numbers = "+ phoneNode.asLong()+ "\n");
		}
		
		return elements;
	}
	
	public void writeEmployeeToJson(Employee emp) {
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
			logger.info("Employee JSON is \n"+ jsonInString);
			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			objectMapper.writeValue(new File(emp.getId()+ "_employee.json"), emp);
		}catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
