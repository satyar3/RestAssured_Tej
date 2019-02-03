package com.student.requests;

import org.junit.Test;

import com.studentapp.testbase.TestBase;

import io.restassured.RestAssured;

public class DeleetCall extends TestBase
{
	@Test
	public void deleteCall()
	{
		RestAssured.given().
		when().
		delete("/124").
		then().log().all().
		statusCode(204);
	}
}
