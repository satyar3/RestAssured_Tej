package com.walmart.test;

import org.junit.Test;

import io.restassured.RestAssured;

public class SearchAPI
{
	@Test
	public void walmartSearch()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().log().headers().
		get("/search").
		then().log().all();//body();
	}
	
	@Test
	public void walmartSearchExtraction()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		int numItems = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().log().headers().
		get("/search").
		then().
		extract().
		path("numItems");
		
		System.out.println("Num items : "+numItems);
	}
}
