package Reqres;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject_1 
{
	@Test
	public void Test()
	{
		RequestSpecification reqs=RestAssured.given();
		Response resp = reqs.post("https://petstore.swagger.io/v2/pet");
		JsonObject js=new JsonObject();
		
		
		
	}

}
