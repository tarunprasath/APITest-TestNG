package com.companyAAA;
import java.io.FileReader;
import java.util.Properties;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;


public class configutlities {
	
	public static String endpoint;
	@BeforeClass
	public static void loadProperties() throws Exception{  
		FileReader reader=new FileReader("C:\\Workspaces\\CompanyAAA_APITest\\src\\com\\companyAAA\\config.properties");
		Properties p=new Properties();
		p.load(reader);
		System.out.println(p.getProperty("com.env"));
		String env = p.getProperty("com.env");
		switch (env) {
		case "UAT1":
			endpoint = "http://dummy.restapiexample.com/api/v1"; 
			RestAssured.baseURI = configutlities.endpoint;
			break;
		case "UAT2":
			endpoint = "http://dummy.restapiexample.com/api/v1";
			RestAssured.baseURI = configutlities.endpoint;
		}	
	}

}
