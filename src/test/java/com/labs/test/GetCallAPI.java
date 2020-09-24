package com.labs.test;

import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class GetCallAPI {
	
	// Rest Assured  - BDD Approach
	@Test(priority = 1, enabled = false)
	public void getUsersAPITest() {
		
		RestAssured.baseURI= "https://gorest.co.in";
		
		given().log().all().contentType("application/json")
		       .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		       
		.when() 
		        .get("/public-api/users")
		.then().log().all()
		       .statusCode(200)
		       .contentType("application/json")
		       .header("server","nginx")
		       .header("Content-Encoding", "gzip")
		       .header("X-Rate-Limit-Limit", "60");
			
	}
	
	@Test
	public void getSingleUSERAPIQueryParamTest() {
		
		RestAssured.baseURI="https://gorest.co.in";
		//Hanna first_name
		
		given().log().all() .contentType("application/json")
		          .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		         .queryParam("first_name", "Hanna")
		         .queryParam("gender", "female")
		 .when().get("/public-api/users")  
		 .then().statusCode(200).and().header("server", "nginx");
		
	}
	
	
	@Test
	public void getSingleUSERAPITest() {
		
		RestAssured.baseURI="https://gorest.co.in";
		//Hanna first_name
		
		given().log().all()
		.contentType("application/json")
		          .header("Authorization","Bearer g0JIGvfO6SIYnwmMYDM-Kp3nCYVw-xInSDif")
		         .when().get("/public-api/users/?first_name=Hanna")  
		 .then().statusCode(200);
		
	}
	

}
