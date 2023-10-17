package crudWithoutbdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSingleProject 
{
	@Test
	public void getsingleproject()
	{
		RequestSpecification reqs=RestAssured.given();
		Response resp = reqs.get("http://rmgtestingserver:8084/projects/TY_PROJ_75339");
		int statuscode=resp.getStatusCode();
		Assert.assertEquals(200, statuscode);
		System.out.println(resp.prettyPrint());
		System.out.println(resp.contentType());
		System.out.println(resp.getStatusCode());
	}

}
