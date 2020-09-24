package com.studentAppli.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

public class BestBuyJayway {
	
	String jsonResponse;
	@BeforeClass
	public void initialize() {
				
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3030;
		
	jsonResponse = given().when().get("/products").asString();
		
	}
	@Test
	public void test001() {
		
		HashMap<String,?> rooTelement = JsonPath.read(jsonResponse, "$");
		
		System.out.println(rooTelement.toString());
	}
	
	@Test
	public void test002() {
		
		int totalValue = JsonPath.read(jsonResponse, "$.total");
		
		System.out.println(totalValue);
	}

	
	@Test
	public void test003() {
		
		List<HashMap<String,?>> rooTelement = JsonPath.read(jsonResponse, "$.data");
		
		System.out.println(rooTelement.toString());
	}
	
	@Test
	public void test004() {
		
		List<HashMap<String,?>> rooTelement = JsonPath.read(jsonResponse, "$.categories");
		
		System.out.println(rooTelement.toString());
	}
	
	
	@Test
	public void test005() {
		
		HashMap<String,?> rooTelement = JsonPath.read(jsonResponse, "$.data[0]");
		
		System.out.println(rooTelement.toString());
	}
	
	@Test
	public void test006() {
		
		HashMap<String,?> rooTelement = JsonPath.read(jsonResponse, "$.data[-1]");
		
		System.out.println(rooTelement.toString());
	}
	
	@Test
	public void test007() {
		
		List<String> names = JsonPath.read(jsonResponse, "$.data[*].name");
		
		System.out.println(names.toString());
	}
	
	@Test
	public void test008() {
		
		List<String> Ids = JsonPath.read(jsonResponse, "$..[*].id");
		
		System.out.println(Ids.toString());
	}
	
	@Test
	public void test009() {
		
		List<String> Ids = JsonPath.read(jsonResponse, "$..[*].id");
		
		System.out.println(Ids.toString());
	}
	
	@Test
	public void test010() {
		
		List<String> names = JsonPath.read(jsonResponse, "$.data[?(@.price<5)].name");
		names.forEach((nam)->{
			System.out.println(nam);
		});
		
	}
	
	@Test
	public void test011() {
		
		List<HashMap<String,Object>> names = JsonPath.read(jsonResponse, "$.data[*].categories");
		
		System.out.println(names.toString());
	}
	
	
}
