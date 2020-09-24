package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookingAPITest {
	
	@Test
	public void doBookingTest() {
		
		String bookingJson = null;
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType("application/json");
		
		Bookingdates bd = new Bookingdates("2020-08-23","2020-08-24");
		
		BookingPOJO bp = new BookingPOJO("arjun", "singh", 111, true, "breakfast", bd);
		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			bookingJson = mapper.writeValueAsString(bp);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("Booking json payload: "+bookingJson);
		
		request.body(bp);
		
		Response response = request.post("/booking");
		
		System.out.println(response.prettyPrint());
		
		
		Assert.assertEquals(response.getStatusCode(), HTTPStatus.HTTP_STATUS_CODE_200);
		
		JsonPath js =response.jsonPath();
		Assert.assertEquals(js.get("booking.firstname"), bp.getFirstname());
		Assert.assertEquals(js.get("booking.lastname"), bp.getLastname());
		Assert.assertEquals(js.getInt("booking.totalprice"), bp.getTotalprice());
		Assert.assertEquals(js.getBoolean("booking.depositpaid"), bp.isDepositpaid());
		Assert.assertEquals(js.get("booking.additionalneeds"), bp.getAdditionalneeds());
		
		Assert.assertEquals(js.get("booking.bookingdates.checkin"), bd.getCheckin());
		Assert.assertEquals(js.get("booking.bookingdates.checkout"), bd.getCheckout());
		
		
		
		
		
	}

}
