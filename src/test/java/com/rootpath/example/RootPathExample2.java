package com.rootpath.example;

import static org.hamcrest.Matchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;

public class RootPathExample2
{
	@Before
	public void setUp()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		RestAssured.rootPath = "items[0]";
	}
	
	
	@Test
	public void rootPathEx1()
	{
		
		
		RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().

		body("stock",equalTo("Available")).
		
		body("stock",equalTo("Available"));   //instead of providing the path as items[9].stock define only stock		
	}
	
	@After
	public void tearDown()
	{
		RestAssured.reset();
	}
}
