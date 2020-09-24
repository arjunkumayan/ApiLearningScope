package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTokenPOJO {

	
	
	
	@Test
	public void getTokenWithPOJOTest() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given().log().all();
		
		request.contentType("application/json");
		
		Credentials cred = new Credentials("admin", "password123");
		
		Credentials cred1 = new Credentials("admin", "password123");
		Credentials cred2 = new Credentials("admin", "password123");
		
		
		// POJO to json
		// Jackson library
		
		ObjectMapper mapper = new ObjectMapper();
		String credJson = null;
		try {
			credJson = mapper.writeValueAsString(cred);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Credential json payload: "+ credJson);
		
		// hit the API
		
		
		request.body(credJson);
		Response response = request.post("/auth");
		
		System.out.println(response.prettyPrint());
		
		System.out.println(response.getStatusCode());
		
		Assert.assertEquals(response.getStatusCode(), HTTPStatus.HTTP_STATUS_CODE_200);
		
		JsonPath  js = response.jsonPath();
		
		String tokenId = js.get("token");
		
		System.out.println(tokenId);
		
		Assert.assertNotNull(tokenId);
		
		
		
	}
	
	@Test
	public void tokenAPIWithWrongCredentialTest(){
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given().log().all();
		
		request.contentType("application/json");
		
		Credentials cred = new Credentials("admin", "admin");
		
			
		// POJO to json
		// Jackson library
		
		ObjectMapper mapper = new ObjectMapper();
		String credJson = null;
		try {
			credJson = mapper.writeValueAsString(cred);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Credential json payload: "+ credJson);
		
		// hit the API
		
		
		request.body(credJson);
		Response response = request.post("/auth");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
		
		JsonPath js = response.jsonPath();
		String messg = js.get("reason");
		
		System.out.println("reason is: "+ messg);
		
		Assert.assertEquals(messg, HTTPStatus.WRONG_CREDENTIIALS_MESSAGE);
	
		
	}
	
	
	@Test
	public void gettokenAPIWithBadJSONPayloadTest(){
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given().log().all();
		
		request.contentType("application/json");
		String payload = "{\"username\" : \"admin\" \"password\" : \"admin123\"}";
		
		System.out.println("Credential json payload: "+ payload);
		
		// hit the API
		
		
		request.body(payload);
		Response response = request.post("/auth");
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
		Assert.assertEquals(response.getStatusCode(), HTTPStatus.HTTP_STATUS_CODE_400);
		
		JsonPath js = response.jsonPath();
		String messg = js.get("reason");
		
		System.out.println("reason is: "+ messg);
		
		Assert.assertEquals(messg, HTTPStatus.WRONG_CREDENTIIALS_MESSAGE);
	
		
	}
}
