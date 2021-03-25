//Put request for replacing/modification of the employee details
//Employee ID is provided in the code, but it can be passed from Excel or DB

package com.companyAAA;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;

public class PutEmployeeDetails {
	
	@Test
	public void EditEmpolyeeDetails() throws JSONException
	{   
		int EmpID = 29;
		RequestSpecification httpRequest = RestAssured.given();
		
		//Used JSONobject for request creation
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "test"); 
		requestParams.put("salary", 123);
		requestParams.put("age", 23);
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.put("/update/"+EmpID);
		System.out.println(response.getBody().prettyPrint());
		
		//Validate the response
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,200,"Expected status code returned");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String status = jsonPathEvaluator.get("status");
		Assert.assertEquals(status, "success", "Expected status message returned");
		
		//Verify updated Emp name is returned
		String nameValue = response.jsonPath().get("data.name");
		Assert.assertTrue(nameValue.equals("test"));
	}
}
