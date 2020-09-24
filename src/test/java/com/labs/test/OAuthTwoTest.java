package com.labs.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class OAuthTwoTest {
	
	//89a44279a96682b611fc7a79bdcfd2ca0093e8f8

	@Test
	public void checkOAuth2Test() {
		
		RestAssured.baseURI = "";
		
		
		
		
		RequestSpecification request = RestAssured.
				            given().
				            auth().
				            oauth2("89a44279a96682b611fc7a79bdcfd2ca0093e8f8");
			
		Response response = request.post("http://coop.apps.symfonycasts.com/api/879/chickens-feed");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
		JsonPath json = response.jsonPath();
		String action = json.get("action");
		String scc = json.get("success");
		String messg = json.get("message");
		String data = json.get("data");
	
		
	}
	
	@Test
	public void getOath2TokenTest() {
		
		RequestSpecification request = RestAssured.given()
		            .formParam("client_id", "AprilAPI")
		            .formParam("client_secret", "c37dd8ce50d2a987941d756964d78d29")
		            .formParam("grant_type", "client_credentials");
		    
		Response response = request.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
	JsonPath js = response.jsonPath();
	
	String accessToken=  js.get("access_token");
	int expiringIN = js.getInt("expires_in");
	String tokenType=  js.get("token_type");
	String scopeToken =  js.get("scope");
	  
	System.out.println(accessToken);
	System.out.println(expiringIN);
	System.out.println(tokenType);
	System.out.println(scopeToken);
	
	
	
	RequestSpecification request1 = RestAssured.
			            given().
			            auth().
			            oauth2(accessToken);
		
	Response response1 = request1.post("http://coop.apps.symfonycasts.com/api/879/chickens-feed");
	
	System.out.println(response1.getStatusCode());
	System.out.println(response1.prettyPrint());
	
		
	}
	

}
