package com.student.pojomodel;

import java.util.ArrayList;
import java.util.List;

public class PostPojo
{
	String firstName;
	String lastName;
	String email;
	String programme;
	ArrayList<String> courses;
	
	
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getProgramme()
	{
		return programme;
	}
	public void setProgramme(String programme)
	{
		this.programme = programme;
	}
	public ArrayList<String> getCourses()
	{
		return courses;
	}
	public void setCourses(ArrayList<String> courses)
	{
		this.courses = courses;
	}
}
