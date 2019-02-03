package com.restassured.assertions;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AssertOnCompleteJson
{
	@Test
	public void test001() throws JSONException
	{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
		
		Response resp = RestAssured.given().
		when().
		get("/list").
		then().extract().response();
		
		String respString = resp.asString();
		//JsonPath actualJPath = new JsonPath(respString);
		
		String expectedJPath = respString;
		
		JSONAssert.assertEquals(expectedJPath, respString, JSONCompareMode.STRICT);
	}
}
