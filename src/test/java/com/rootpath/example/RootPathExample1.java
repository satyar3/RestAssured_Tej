package com.rootpath.example;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;

public class RootPathExample1
{
	@Test
	public void rootPathEx1()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		root("items[9]").
		body("stock",equalTo("Available")).
		
		root("tems[0]").
		body("stock",equalTo("Available"));   //instead of providing the path as items[9].stock define only stock		
	}
}
