package crudWithoutbdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProj 
{
	@Test
	public void deleteProj()
	{
		Response resp=RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_75227");
		resp.then().log().all();
		int statuscode=resp.getStatusCode();
		Assert.assertEquals(204,statuscode);
	}

}
