//Get the employee details and verify if the response status code has returned '200'

package com.companyAAA;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetEmployeeDetails {
	@Test
	public void GetAllEmpolyeeDetails()
	{   
		
		Response response = RestAssured.given().get("/employees");
		
		//Validate the response
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode , 200 , "Expected status code returned");
		List<Object> idList = response.jsonPath().getList("data.id");
		List<Object> nameList = response.jsonPath().getList("data.employee_name");
		List<Object> salaryList = response.jsonPath().getList("data.employee_salary");
		List<Object> ageList = response.jsonPath().getList("data.employee_age");
		List<Object> imageList = response.jsonPath().getList("data.profile_image");
		System.out.println("idList of Body :  " + idList);
		System.out.println("nameList of Body :  " + nameList);
		System.out.println("salaryList of Body :  " + salaryList);
		System.out.println("ageList of Body :  " + ageList);
		System.out.println("imageList of Body :  " + imageList);
		
	}
		
	@Test
	public void GetIndividualEmpolyeeDetails()
	{   
		int EmpID = 7;
		Response response = RestAssured.given().get("/employee/"+EmpID);
		
		//Validate the response
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode , 200 , "Expected status code returned");
		String idValue = response.jsonPath().get("data.id");
		
		//Verify Expected EmpID detail is returned
		Assert.assertTrue(idValue.equals(String.valueOf(EmpID)));
	}

}
