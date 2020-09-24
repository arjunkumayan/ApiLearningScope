package com.studentapp.tests;

import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class MyFirstTest {
	
	private void styles() {
		
		RestAssured.given()
	            	.queryParam("", "")
 		           .when()
 		           .get("https://www.google.com/")
 		           .then();
		
		RestAssured.given()
		           .expect()
		           .when();     
		
		
		
	}
	
	
	@Test
	public void getAllStudents() {		
		RequestSpecification  requestSpec = RestAssured.given();
		
		Response response = requestSpec.get("http://localhost:8080/student/list");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getSessionId());
		System.out.println(response.getHeaders());
		Headers head = response.getHeaders();
		System.out.println(head.hashCode());
		
		Iterator<Header> it = head.iterator();
		
		while (it.hasNext()) {
		
		System.out.println(it.next());
		}
		ValidatableResponse vaidatableResponse =response.then();
		System.out.println(vaidatableResponse.statusCode(200));
		
	}

	
	@Test
	public void getAllStudents2() {		
	RestAssured.given().when().get("http://localhost:8080/student/list").then().assertThat().statusCode(200);
		
	
	}
}
