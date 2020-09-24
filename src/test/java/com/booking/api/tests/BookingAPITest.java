package com.booking.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.HTTPStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookingAPITest {
	
	@Test
	public void doBookingTest() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType("application/json");
		
		Bookingdates bd = new Bookingdates("2018-02-02", "2019-02-02");
		
		Booking booking = new Booking("priyank", "Joshi", 150, true, "lunch", bd);
		ObjectMapper mapper = new ObjectMapper();
		String bookingJson = null;
		
		// POJO to Json - serialization - Object to json
		try {
			bookingJson =  mapper.writeValueAsString(booking);
		} catch (JsonProcessingException e) {
				e.printStackTrace();
		}
		
		System.out.println(bookingJson);
		
		request.body(bookingJson);
		
		Response response = request.post("/booking");
		
		System.out.println(response.prettyPrint());
		
		Assert.assertEquals(response.getStatusCode(), HTTPStatus.HTTP_STATUS_CODE_200);
		
		JsonPath js = response.jsonPath();
		int bookingID = js.get("bookingid");
		Assert.assertNotNull(bookingID);
		
		String firstname = js.get("booking.firstname");
		System.out.println(firstname);
		
		Assert.assertEquals(firstname, booking.getFirstname());
		String lastname = js.get("booking.lastname");
		System.out.println(lastname);
		Assert.assertEquals(lastname, booking.getLastname());
		
		Assert.assertEquals(firstname, booking.getFirstname());
		int totalprice = js.getInt("booking.totalprice");
		System.out.println(totalprice);
		Assert.assertEquals(totalprice, booking.getTotalprice());
		
		Assert.assertEquals(js.get("booking.firstname"), booking.getFirstname());
		Assert.assertEquals(js.get("booking.lastname"), booking.getLastname());
		Assert.assertEquals(js.getInt("booking.totalprice"), booking.getTotalprice());
		Assert.assertEquals(js.getBoolean("booking.depositpaid"), booking.isDepositpaid());
		Assert.assertEquals(js.get("booking.additionalneeds"), booking.getAdditionalneeds());
		
		System.out.println(bd.getCheckin());
		System.out.println(bd.getCheckout());
		
		Assert.assertEquals(js.get("booking.bookingdates.checkin"), bd.getCheckin());
		Assert.assertEquals(js.get("booking.bookingdates.checkout"), bd.getCheckout());
	}

}
