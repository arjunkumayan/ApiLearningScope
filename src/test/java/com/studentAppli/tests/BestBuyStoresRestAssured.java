package com.studentAppli.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestBuyStoresRestAssured {
	
	ValidatableResponse validatableResponse;
	@BeforeClass
	public void initialize() {
				
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3030;
		
		validatableResponse = given().when().get("/stores").then();
		
	}
	@Test
	public void test001() {
		int total = validatableResponse.extract().path("total");
		
		System.out.println(total);
	}	
	
	@Test
	public void test002() {
		String storeName = validatableResponse.extract().path("data[0].name");
		
		System.out.println(storeName);
	}
	
	@Test
	public void test003() {
		String serviceName = validatableResponse.extract().path("data[0].services[0].name");
		
		System.out.println(serviceName);
	}
	@Test
	public void test004() {
		Map<String, Object> mp = validatableResponse.extract().path("data.find{it.zip=='55901'}");
		
		System.out.println(mp.toString());
	}
	@Test
	public void test005() {
		Map<String, Object> mp = validatableResponse.extract().path("data.find{it.serviceId=='17'}");
		
		System.out.println(mp.toString());
	}
	
	@Test
	public void test064() {
		String mp = validatableResponse.extract().path("data.find{it.zip=='55901'}.address");
		
		System.out.println(mp.toString());
	}
	
	@Test
	public void test065() {
		HashMap<String, ?> maxId = validatableResponse.extract().path("data.max{it.id}");
		System.out.println(maxId.toString());
		HashMap<String, ?> minId = validatableResponse.extract().path("data.min{it.id}");
		System.out.println(minId.toString());
	}
	
	
	@Test
	public void test066() {
		List<String> Zipcode = validatableResponse.extract().path("data.findAll{it.id<10}.zip");
		System.out.println(Zipcode.toString());
	}
	
	@Test
	public void test07() {
		List<List<String>> Zipcode = validatableResponse.extract().path("data.services.findAll{it.name}.name");
		System.out.println(Zipcode.toString());
	}
}
