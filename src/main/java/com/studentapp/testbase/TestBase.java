package com.studentapp.testbase;

import org.junit.Before;

import io.restassured.RestAssured;

public class TestBase
{
	@Before
	public void steUp()
	{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
	}
}
