package com.filters.example;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class FiltersExapmle
{
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;
	
	public static StringWriter responseWriter;
	public static PrintStream responseCapture;
	
	public static StringWriter errorWriter;
	public static PrintStream errorCapture;
	
	@BeforeClass
	public static void setUp()
	{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";
	}
	
	@Before
	public void beforeEachTest()
	{
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);
		
		responseWriter = new StringWriter();
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter), true);
		
		errorWriter = new StringWriter();
		errorCapture = new PrintStream(new WriterOutputStream(errorWriter), true);
	}
	
	@Test
	public void test001()
	{
		RestAssured.given().
		filter(new RequestLoggingFilter()).
		filter(new ResponseLoggingFilter()).
		when().
		get("/list").
		then();
		
		
		System.out.println(requestWriter.toString());
		System.out.println(responseWriter.toString());
	}
	
	@Test	//This will be printed only if the error code is between 400 and 500
	public void test002()
	{
		RestAssured.given().
		filter(new ErrorLoggingFilter()).
		when().
		get("/listJUNK").
		then();
		
		
		System.out.println(errorWriter.toString().toUpperCase());
		
	}
}
