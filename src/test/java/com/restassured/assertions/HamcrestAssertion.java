package com.restassured.assertions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Test;

import io.restassured.RestAssured;

public class HamcrestAssertion
{
	@Test
	public void assertion1()
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
		body("numItems", equalTo(10));		
	}
	
	@Test
	public void assertion2()
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
		body("query", equalTo("ipod"));		
	}
	
	@Test //Look up in a List will be hasItem/hasItems .... look up in map will be hasValue
	public void assertion3()
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
		body("items.name", hasItem("Apple iPod touch 32GB"));		
	}
	
	@Test //Look up in a List will be hasItem/hasItems .... look up in map will be hasValue
	public void assertion4()
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
		body("items.name", hasItems("Apple iPod touch 32GB","Apple iPod touch 128GB"));		
	}
	
	@Test //Look up in a List will be hasItem/hasItems .... look up in map will be hasValue
	public void assertion5()
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
		body("items[0].giftOptions", hasKey("allowGiftWrap"));		
	}
	
	@Test //Look up in a List will be hasItem/hasItems .... look up in map will be hasValue
	public void assertion6()
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
		body("items.findAll{it.name == 'Apple iPod touch 32GB'}", hasItem(hasEntry("name", "Apple iPod touch 32GB")));
		//body("items.findAll{it.name == 'Apple iPod touch 32GB'}", hasItem(hasValue("Apple iPod touch 32GB")));
	}
	
	@Test //Multiple assertions
	public void assertion7()
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
		body("items.findAll{it.name == 'Apple iPod touch 32GB'}", hasItem(hasEntry("name", "Apple iPod touch 32GB"))).
		body("items.findAll{it.name == 'Apple iPod touch 32GB'}", hasItem(hasValue("Apple iPod touch 32GB"))).
		body("items.name", hasItem("Apple iPod touch 32GB"));
	}
	
	@Test //logical assertion
	public void assertion8()
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
		body("numItems", lessThan(15));		
	}
}
