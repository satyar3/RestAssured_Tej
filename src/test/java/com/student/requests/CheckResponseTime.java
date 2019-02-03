package com.student.requests;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import static org.hamcrest.Matchers.*;

import com.studentapp.testbase.TestBase;

import io.restassured.RestAssured;

public class CheckResponseTime extends TestBase
{
	@Test
	public void test001()
	{
		long timeDuration = RestAssured.given().
		when().
		get("/list").
		timeIn(TimeUnit.SECONDS);
		
		System.out.println("Duration is : "+timeDuration);
	}
	
	@Test
	public void test002()
	{
		RestAssured.given().
		when().
		get("/list").
		then().
		time(lessThan(5L), TimeUnit.SECONDS);
	}

}
