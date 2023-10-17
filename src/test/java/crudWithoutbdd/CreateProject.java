package crudWithoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject 
{
	@Test
	public void createProj()
	{
		JavaUtility j=new JavaUtility();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Amlan");
		jObj.put("projectName","Online Banking"+j.getRandomNo());
		jObj.put("status","created");
		jObj.put("teamSize",15);
		RequestSpecification reqs=RestAssured.given();
		reqs.body(jObj);
		reqs.contentType(ContentType.JSON);
		Response resp = reqs.post("http://rmgtestingserver:8084/addProject");
		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		
	}

}
