package com.companyAAA;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostEmployeeDetails {
	@Test
	public void CreateNewEmpolyeeDetails()
	{   
		
		//Used String for Request creation
		String req = "{\"name\":\"test1\",\"salary\":\"1123\",\"age\":\"23\"}";
		
		Response response = RestAssured.given().body(req).post("/create");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);
		
		//Validate the response
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Expected status code returned");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String status = jsonPathEvaluator.get("status");
		Assert.assertEquals(status, "success", "Expected status message returned");
		
		//Verify if the newly created employee has ID
		int idValue = response.jsonPath().get("data.id");
		System.out.println("idValue Body:  " + idValue);
		
		Assert.assertEquals(status, "success", "Expected status message returned");
	    if(idValue!= 0) {
	    	System.out.println("ID value has been created for new employee");
	    }
		
	}
}
