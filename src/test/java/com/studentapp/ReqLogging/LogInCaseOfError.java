package com.studentapp.ReqLogging;

import org.junit.Test;

import com.studentapp.testbase.TestBase;

import io.restassured.RestAssured;

public class LogInCaseOfError extends TestBase
{
	@Test
	public void getStudentByIDError()
	{
		System.out.println("***************getStudentByIDError***************");
		RestAssured.given().
		when().
		get("/-100").
		then().log().ifError();
		
	}
	
	@Test
	public void getStudentByIDSuccess()
	{
		System.out.println("***************getStudentByIDSuccess***************");
		RestAssured.given().
		when().
		get("/100").
		then().log().ifError();
		
	}
}
