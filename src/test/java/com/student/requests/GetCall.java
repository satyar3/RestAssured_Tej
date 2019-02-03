package com.student.requests;

import org.junit.Test;

import com.studentapp.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCall extends TestBase
{
	@Test
	public void getCallTest()
	{
		RestAssured.given().
		//param("Content-Type", "application/json;charset=UTF-8").
		//param("Transfer-Encoding","chunked").log().all().
		when().log().all().
		get("/list").
		then().
		log().all().
		statusCode(200);
		
	}
	
	@Test
	public void getStudentByID()
	{
		Response resp = RestAssured.given().
				when().
				get("/100").
				then().extract().response();
		
		System.out.println(resp.prettyPrint());
				
	}
	
	@Test
	public void getCallWithParam()
	{
		RestAssured.given().
		param("Programme", "Finanlcial Analysis").
		param("limit", "2").
		when().
		get("/list").
		then().log().all();
	}
}
