package com.studentAppli.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class MyFirstTest {

	@Test
	public void getAllStudentName() {
		
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		
		ValidatableResponse validateResponse = RestAssured.given()
		           .when()
		           .get("/student/list")
		           .then();
		
		System.out.println(validateResponse.statusCode(200));
	}
	
	
	@Test
	public void getStudents() {
		
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get("http://localhost:8080/student/list");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		
		System.out.println(response.getHeaders());
		System.out.println(response.prettyPrint());
		
		 ValidatableResponse valid = response.then();
		 
		 valid.statusCode(200);
		 
		 
		 
	}
	
	@Test
	public void getStudent1() {
		
		RestAssured.given()
		           .when()
		.get("http://localhost:8080/student/list")
		.then().statusCode(200);
	}
	
	@Test
	public void getStudent2() {
		
		     given()
		           .when()
		.get("http://localhost:8080/student/list")
		.then().statusCode(200);
	}
	
	@Test
	public void getStudent3() {
		
		          given()
		           .when().contentType(ContentType.JSON)
		.get("http://localhost:8080/student/list")
		.then().statusCode(200);
	}
	
}
