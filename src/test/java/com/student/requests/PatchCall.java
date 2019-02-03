package com.student.requests;

import java.util.ArrayList;

import org.junit.Test;

import com.student.pojomodel.PostPojo;
import com.studentapp.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchCall extends TestBase
{
	
	//Unlike PUT method, in PATCH user can send only the field which he needs to update
	@Test
	public void patchCall()
	{
		String firstName = "FN1New";
		String lastName = "LN1New";
		String email = "test@testmail.com";
		String programme = "testpro";
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("cor1");
		courses.add("cor2");
		
		PostPojo pojo = new PostPojo();		
		
		pojo.setFirstName(firstName);
		pojo.setLastName(lastName);
		pojo.setEmail(email);
		pojo.setProgramme(programme);
		pojo.setCourses(courses);
		
		
		RestAssured.given().
		contentType(ContentType.JSON).
		when().
		body(pojo).
		patch("/124").
		then().log().all().
		statusCode(200);
	}
}
