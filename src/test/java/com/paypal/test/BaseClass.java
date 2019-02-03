package com.paypal.test;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass
{
	static String accessToken;
	public static final String  clientId="";
	public static  final String  clientSecret="";	
	
	@BeforeClass
	public static void getToken()
	{
		RestAssured.baseURI="https://api.sandbox.paypal.com";
		RestAssured.basePath="/v1";
		
		accessToken = RestAssured.given().
			param("grant_type", "client_credentials").
			auth().
			preemptive().
			basic(clientId, clientSecret).
		when().
			post("/oauth2/token").
		then().log().all().
		extract().
		path("acces_token");
	}
}
