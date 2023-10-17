package crudWithoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject
{
	@Test
	public void UpdateProject()
	{   
		
		JSONObject jObj = new JSONObject();
		
		jObj.put("createdBy","Amlan");
		jObj.put("projectName","Online Banking1628df096813");
		jObj.put("status","ended");
		jObj.put("teamSize", 15);
		RequestSpecification reqs=RestAssured.given();
		reqs.body(jObj);
		reqs.contentType(ContentType.JSON);
		Response resp = reqs.put("http://rmgtestingserver:8084/projects/TY_PROJ_75339");
		System.out.println(resp.prettyPrint());
		System.out.println(resp.contentType());
		
	}

}
