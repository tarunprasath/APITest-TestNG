package com.companyAAA;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class DeleteEmployeeDetails {
	
	@Test
	public void DeleteEmpolyeeDetails()
	{   
		int EmpID = 27;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json"); 		
		Response response = RestAssured.given().delete("/delete/"+EmpID);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		//Validate the response
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String jsonString =response.asString();
		Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
	}
}
