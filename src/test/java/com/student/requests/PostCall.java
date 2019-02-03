package com.student.requests;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.student.pojomodel.PostPojo;
import com.studentapp.testbase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostCall extends TestBase
{
	
	PostPojo pojo;
	
	@Test
	public void postCall()
	{
		String firstName = "FN1";
		String lastName = "LN1";
		String email = "test@testmail.com";
		String programme = "testpro";
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("cor1");
		courses.add("cor2");
		
		pojo = new PostPojo();		
		
		pojo.setFirstName(firstName);
		pojo.setLastName(lastName);
		pojo.setEmail(email);
		pojo.setProgramme(programme);
		pojo.setCourses(courses);
		
		
		RestAssured.given().
		contentType(ContentType.JSON).
		when().
		body(pojo).log().all().
		post().
		then().log().all().
		statusCode(201);
		
		
		//Verifying if the student is added
		HashMap<String,String> val = RestAssured.given().
		when().
		get("/list").
		then().
		extract().
		path("findAll{it.email=='test@testmail.com'}.get(0)");
		
		System.out.println("ID is : "+val.get("id"));
	}
}
