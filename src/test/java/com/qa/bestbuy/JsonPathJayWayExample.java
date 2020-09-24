package com.qa.bestbuy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class JsonPathJayWayExample {
	
   String jsonResponse;
	
	@BeforeTest
	public void initialize() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3030;		
		jsonResponse = given().when().get("/products").asString();
	}
	
	@BeforeMethod
	public void printToConsole() {
		System.out.println("Starting the test method");
		System.out.println("   ");
			
	}
	
	@AfterTest
	public void printToConsoleAgain() {
		System.out.println(" ----Ending the test method --------- ");
		System.out.println("    ");
	}
	
	
	
	@Test(description = " Get the root element ")
	public void getRoot() {		
		Map<String, ?> rootElement = JsonPath.read(jsonResponse, "$");		
		System.out.println(rootElement.toString());
	}

	

	@Test(description = " Get the total count ")
	public void getTotalValue() {		
		int totalValue = JsonPath.read(jsonResponse, "$.total");		
		System.out.println(totalValue + " ");
	}
	
	@Test(description = " Get all the data elements")
	public void getAllTheElements() {		
		
		List<HashMap<String, Object>> dataElements= JsonPath.read(jsonResponse, "$.data");		
		dataElements.stream().forEach(System.out::println);
		
	}
	


	@Test(description = " Get the first element ")
	public void getTheFirstElement() {	
		
		Map<String, Object> firstDataElement= JsonPath.read(jsonResponse, "$.data[0]");		
		System.out.println(firstDataElement.toString());
		
	}
	
	@Test(description = " Get the Last element ")
	public void getTheLastElement() {			
		Map<String, Object> lastDataElement= JsonPath.read(jsonResponse, "$.data[-1]");		
		System.out.println(lastDataElement.toString());
		
	}
	
	@Test(description = " Get the all ids ")
	public void getIds() {			
		List<String> allIds= JsonPath.read(jsonResponse, "$.data[*].id");		
		System.out.println(allIds.toString());		
	}
	
	@Test(description = " Get the Deep all ids ")
	public void getDeepIds() {			
		List<String> allIds= JsonPath.read(jsonResponse, "$..data[*].id");		
		System.out.println(allIds.toString());		
	}
	
	
	
	@Test(description = " Get the name of the product whose price is less than 5")
	public void getNameOfProduct() {			
		List<String> names= JsonPath.read(jsonResponse, "$.data[?(@.price>5)].name");		
		//System.out.println(names.toString());		
		names.stream().forEach(System.out::println);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
