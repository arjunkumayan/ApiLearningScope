package com.labs.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth1 {
	
	//OauthTest1.0
	
	@Test
	public void createTweet() {		
		
		RequestSpecification request = RestAssured
				.given()
				.auth()
				.oauth("79NWqsYlDIzJsRMhmxaNOcp12", 
				 "ZgyIS8GWNNN1KRQxwFvHdyRE7zqFe6Spy06riI0Zn4ean1Dj0o",
				 "942322901998379008-Gf4tOGMnbpnchBT9C7lsmPoW3pAU2bz",
				 "kYGAla4TlQZ1w1fjT4dGwgbNRcMtcjIikAL6NwZwlkH0c");
		Response response = request.post("https://api.twitter.com/1.1/statuses/update.json?status=h1ello this is post from API");
				
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
	
		
//				WonbKuq6bmSXDsucBsH6Bd1kt
//
//				ypmnMwHPkAHZUVomJVliltDSO8j8kAd0HoHaKv7JU3dR9Vmi3l  
//				Access Token = 942322901998379008-pX8QHYAlCedrannCHivIoiPsbnbacwK
//
//				Secret -
//				txOhC1WhThFlrLTmrQb2HoYW9PXNHk993IAbDvToYse0I
		
		// request.auth().oauth(consumerKey, consumerSecret, accessToken, secretToken);
		// request.auth().oauth2(accessToken);
		
		
		
	}
	
	
	@Test
	public void doRweetTweet() {		
		
		RequestSpecification request = RestAssured
				.given()
				.auth()
				.oauth("79NWqsYlDIzJsRMhmxaNOcp12", 
				 "ZgyIS8GWNNN1KRQxwFvHdyRE7zqFe6Spy06riI0Zn4ean1Dj0o",
				 "942322901998379008-Gf4tOGMnbpnchBT9C7lsmPoW3pAU2bz",
				 "kYGAla4TlQZ1w1fjT4dGwgbNRcMtcjIikAL6NwZwlkH0c");
		Response response = request.post("https://api.twitter.com/1.1/statuses/retweet/:942322901998379008.json");
				
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
			
		
		
	}

}
