package com.specification.example;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

public class ProxySpecificationEx
{
	
	static RequestSpecification reqSpec;
	static RequestSpecBuilder specBuilder;
	
	@Before
	public void setUp()
	{
		RestAssured.baseURI = "https://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
		
		//Method-1
		//RestAssured.proxy("localhost", 5555, "http");
		
		
		//Method-2
		//specBuilder = new RequestSpecBuilder();
		//specBuilder.setProxy("localhost", 5555, "http");		
		//reqSpec = specBuilder.build();
		
	}
	
	@Test
	public void getStudent()
	{
		
		//Method-3
		ProxySpecification ps = new ProxySpecification("localhost", 5555, "http");
		
		RestAssured.given().
		proxy(ps).
		when().
		get("/list").
		then();
	}
}
