package com.studentapp.ReqLogging;

import org.junit.Test;

import com.studentapp.testbase.TestBase;

import io.restassured.RestAssured;

public class LogWhenTestFails extends TestBase
{
	@Test
	public void getCallTestFail()
	{
		System.out.println("*********************getCallTestFail*********************");
		RestAssured.given().
		when().log().ifValidationFails().
		get("/list").
		then().
		log().ifValidationFails().
		statusCode(201);
		System.out.println("*********************getCallTestFail*********************");
	}
	
	@Test
	public void getCallTestPass()
	{
		System.out.println("*********************getCallTestPass*********************");
		RestAssured.given().
		when().log().ifValidationFails().
		get("/list").
		then().
		log().ifValidationFails().
		statusCode(200);
		System.out.println("*********************getCallTestPass*********************");
	}
}
