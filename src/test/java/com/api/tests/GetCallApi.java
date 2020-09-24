package com.api.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class GetCallApi {
	
	// Rest Assured - BDD Approach
	@Test(priority=1)
	public void getUserTestAPI() {
		
		RestAssured.baseURI = "https://gorest.co.in/";
		
	given().log().all()
		       .contentType("application/json")
		      .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
	.when()
		      .get("public-api/users")
		        
	 .then().log().all()
	         .statusCode(200)
		         .and()
		         .header("Server", "nginx")
		         .header("X-Rate-Limit-Limit", "30");
	
	}
	
	@Test(priority=2)
	public void getSingleUserApiTest() {
			RestAssured.baseURI = "https://gorest.co.in/";
	given().log().all()
		    .contentType("application/json")
		    .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
	.when()
		    .get("public-api/users?first_name=Simola")   
	 .then().log().all()
	         .statusCode(200)
		     .and()
		     .header("Server", "nginx")
		     .header("X-Rate-Limit-Limit", "30");
		}

	
	public void getUserAPItest() {
		RestAssured.baseURI="";
		RestAssured.basePath="";
		
		
		given().log().all()
		      .contentType("application/json")
		      .header("Authorization", "Beared ")
		      
		    .when()
		    .get("public-api/users/?first-name=Somola")
		    
		   .then()
		   .log().all()
		   .header("server", "nginx")
		   .header("", "")
		   .statusCode(200);
		   
		      
		     
	}
	
	@Test(priority=3)
	public void getUserWithOneQueryParameterAPITest() {
			RestAssured.baseURI = "https://gorest.co.in/";
	given().log().all()
		    .contentType("application/json")
		    .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		    .queryParam("first_name", "Simola")
		    .queryParam("gender", "male")
	.when()
		    .get("public-api/users")   
	 .then().log().all()
	         .statusCode(200)
		     .and()
		     .header("Server", "nginx")
		     .header("X-Rate-Limit-Limit", "30");
		}
	public static void getAPITestWithParam() {
		RestAssured.baseURI = " ";
		
		given().log().all()
		.contentType("application/json")
		.header("Authorization","Beared  ")
		.queryParam("first-name", "arjun")
		.queryParam("last-name", "singh")
		
		.when().get("public-api/users")
		.then().log().all().contentType("application/json").statusCode(200)
		.header("server", "nginx");
		
		
	}

}
