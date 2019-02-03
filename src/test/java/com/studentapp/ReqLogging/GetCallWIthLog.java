package com.studentapp.ReqLogging;

import org.junit.Test;

import com.studentapp.testbase.TestBase;

import io.restassured.RestAssured;

public class GetCallWIthLog extends TestBase
{
	@Test
	public void getCallTest()
	{
		System.out.println("***************GetCallTest***************");
		RestAssured.given().
		when().log().headers().
		get("/list").
		then().
		log().all().
		statusCode(200);
		
	}
	
	@Test
	public void getStudentByID()
	{
		System.out.println("***************getStudentByID***************");
		RestAssured.given().
		when().
		get("/100").
		then().log().body();
		
	}
	
	@Test
	public void getCallWithParam()
	{
		System.out.println("***************getCallWithParam***************");
		RestAssured.given().
		param("Programme", "Finanlcial Analysis").
		param("limit", "2").
		when().log().parameters().
		get("/list").
		then().log().body();
	}
}
