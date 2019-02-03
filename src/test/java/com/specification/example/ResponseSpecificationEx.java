package com.specification.example;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationEx
{
	
	static ResponseSpecification resSpec;
	static ResponseSpecBuilder specBuilder;
	
	@Before
	public void setUp()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		specBuilder = new ResponseSpecBuilder();
		specBuilder.expectHeader("Content-Type", "application/json; charset=utf-8");
		specBuilder.expectHeader("Server", "Mashery Proxy");
		specBuilder.expectStatusCode(200);
		specBuilder.expectBody("query", equalTo("ipod"));
		specBuilder.expectBody("numItems", equalTo(10));
		//specBuilder.expectBody("items.name", hasItem("Apple iPod Touch 32GB"));
		
		resSpec = specBuilder.build();
	}
	
	@Test
	public void assertion1()
	{		
		RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().log().all().
		get("/search").
		then().
		spec(resSpec).
		body("items.name", hasItem("Apple iPod Touch 32GB"));

	}
	
}
