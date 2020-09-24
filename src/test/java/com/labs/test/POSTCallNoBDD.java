package com.labs.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTCallNoBDD {

	
	@Test
	public void tokenPOSTAPITest() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

       String body = "{\"username\" : \"admin\", \"password\" : \"password123\"}";
			
	
	 RequestSpecification request = RestAssured.given().log().all();
	 request.contentType("application/json");
	 request.body(body);	
	 
	Response response = request.post("/auth");
	 
	System.out.println(response.prettyPrint());
	System.out.println(response.getStatusCode());
	
	JsonPath js = response.jsonPath();
	String token = js.get("token");
	
	System.out.println(token);
	
	Assert.assertNotNull(token);
	

}
}
