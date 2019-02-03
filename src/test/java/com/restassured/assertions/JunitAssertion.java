package com.restassured.assertions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;


public class JunitAssertion
{
	@Test
	public void assertion1()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		int numItems = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		extract().
		path("numItems");
		
		assertEquals(10, numItems);
	}
}
