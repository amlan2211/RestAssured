package Reqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSingleProject 
{
	@Test
	public void getallProject()
	{
		RequestSpecification reqs=RestAssured.given();
		Response resp = reqs.get("https://reqres.in/api/unknown/2");
		resp.then().log().all();
		int statuscode=resp.getStatusCode();
		Assert.assertEquals(200, statuscode);
		System.out.println(resp.prettyPrint());
		System.out.println(resp.contentType());
		System.out.println(resp.getStatusCode());
	}

}
