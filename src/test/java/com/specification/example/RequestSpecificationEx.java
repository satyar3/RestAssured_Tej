package com.specification.example;

import static org.junit.Assert.assertEquals;

import org.apache.http.client.methods.RequestBuilder;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationEx
{
	
	static RequestSpecification reqSpec;
	static RequestSpecBuilder specBuilder;
	
	@Before
	public void setUp()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		specBuilder = new RequestSpecBuilder();
		specBuilder.addParam("apiKey", "75e3u4sgb2khg673cbv2gjup");
		specBuilder.addParam("query", "ipod");
		specBuilder.addParam("format", "json");
		
		reqSpec = specBuilder.build();
	}
	
	@Test
	public void assertion1()
	{		
		RestAssured.given().
		spec(reqSpec).
		when().log().all().
		get("/search").
		then().
		extract().
		path("numItems");

	}
	
}
