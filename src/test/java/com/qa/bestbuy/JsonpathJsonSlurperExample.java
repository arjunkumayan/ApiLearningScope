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
import io.restassured.response.ValidatableResponse;

public class JsonpathJsonSlurperExample {
	
   ValidatableResponse validatableResponse;
	
	@BeforeTest
	public void initialize() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3030;		
		validatableResponse = given().when().get("/stores").then();
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
		
	}

	

	@Test(description = " Get the total count ")
	public void getTotalValue() {
		int total = validatableResponse.extract().path("total");
		System.out.println(total);
	}
	
	@Test(description = " Get all the data elements")
	public void getAllTheElements() {}
	


	@Test(description = "Print store name")
	public void getTheFirstElement() {
	String storeName = validatableResponse.extract().path("data[0].name");
	System.out.println(storeName);
				
	}
	
	@Test(description = " Get the serviceName ")
	public void serviceName() {
		
		String serviceName = validatableResponse.extract().path("data[0].services[0].name");
		System.out.println(serviceName);
		
	}
	
	@Test(description = " Get all the info of store with zip 55901")
	public void firstStoreWithZip() {
		
		Map<String, ?> info = validatableResponse.extract().path("data.find{it.zip=='55901'}");
		System.out.println(info.toString());
		
	}
	
	@Test(description = " Get the address of the store with zip 55901 ")
	public void getDeepIds() {
		String address = validatableResponse.extract().path("data.find{it.zip=='55901'}.address");
		System.out.println(address);	
		
	}
	
	
	
	@Test(description = " Get all the max id")
	public void getMax() {
		HashMap<String,?> maxId = validatableResponse.extract().path("data.max{it.id}");
		System.out.println(maxId);
		
	}
	@Test(description = " Get all the min id")
	public void getMin() {
		HashMap<String,?> minId = validatableResponse.extract().path("data.min{it.id}");
		System.out.println(minId);		
	}
	
	
	@Test(description = " Get all the store zip codes with id<10")
	public void getFindData() {
		List<String> zipcode = validatableResponse.extract().path("data.findAll{it.id<10}.zip");
		zipcode.stream().forEach((zip) -> {
			System.out.println(zip);
		});	
	}
	
	
	@Test(description = " Get all the store zip codes with id<10")
	public void getServices() {
		List<List<String>> zipcode = validatableResponse.extract().path("data.services.findAll{it.name}.name");
		zipcode.stream().forEach((zip) -> {
			System.out.println(zip);
		});	
	}
	
	
	
	
	
	
	
}
