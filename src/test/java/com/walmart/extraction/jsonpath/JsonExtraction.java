package com.walmart.extraction.jsonpath;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;

public class JsonExtraction
{
	@Test
	public void walmartSearchExtraction1()
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
		
		System.out.println("Num items : "+numItems);
	}
	
	
	@Test
	public void walmartSearchExtraction2()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		String names = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		extract().
		path("items[0].name");
		
		System.out.println("Name is  : "+names);
	}
	
	@Test
	public void walmartSearchExtraction3()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		HashMap<String,String> giftOptions = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		extract().
		path("items[1].giftOptions");
		
		System.out.println("Gift options are : "+giftOptions);
	}
	
	@Test //Extract all the names under items
	public void walmartSearchExtraction4()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		List<String> names = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		extract().
		path("items.name");
		
		System.out.println("Name are  : "+names);
	}
	
	
	@Test //Extract all the names under items having name value as Apple iPod touch 32GB
	public void walmartSearchExtraction5()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		List<HashMap<String, Object>> names = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		extract().
		path("items.findAll{it.name == 'Apple iPod touch 32GB'}");
		
		System.out.println("Name are  : "+names);
	}
	
	
	@Test //Extract all the sale price under items having name value as Apple iPod touch 32GB
	public void walmartSearchExtraction6()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		List<Float> salePrice = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		extract().
		path("items.findAll{it.name == 'Apple iPod touch 32GB'}.salePrice");
		
		System.out.println("Sale price are  : "+salePrice);
	}
	
	
	@Test //Extract all the names where sale price less than $150
	public void walmartSearchExtraction7()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		List<String> names = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		extract().
		path("items.findAll{it.salePrice < 150}.name");
		
		System.out.println("Names having less than 150 are  : "+names);
	}
	
	@Test //Extract all msrp items where name starts with Ref
	public void walmartSearchExtraction8()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		List<String> msrp = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		extract().
		path("items.findAll{it.name ==~/Ref.*/}.msrp");
		
		System.out.println("MSRP Values are  : "+msrp);
	}
	
	@Test //Extract all sale price from items where name ends with ed
	public void walmartSearchExtraction9()
	{
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "v1";
		
		List<Float> salePrice = RestAssured.given().
		param("apiKey", "75e3u4sgb2khg673cbv2gjup").
		param("query", "ipod").
		param("format", "json").
		when().
		get("/search").
		then().
		extract().
		path("items.findAll{it.name ==~/*.ed/}.salePrice");
		
		System.out.println("Sale price with name ending with ed are  : "+salePrice);
	}
}
