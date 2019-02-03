package com.restassured.assertions;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasValue;

import org.junit.Test;

import io.restassured.RestAssured;


public class SoftAssertions
{
	@Test //Multiple assertions
	public void softAssertion()
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
		body("items.findAll{it.name == 'Apple iPod touch 32GB88'}", hasItem(hasEntry("name", "Apple iPod touch 32GB")),
				"items.findAll{it.name == 'Apple iPod touch 32GB'}", hasItem(hasValue("Apple iPod touch 32GB")),
				"items.name", hasItem("Apple iPod touch 32GB78998"));
	}
}
