package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestReqres 
{
	@Test
	public void reqres()
	{
		int id=2;
		baseURI="https://reqres.in/";
		
		Response resp=when().get("/api/unknown");
		int resid=resp.jsonPath().get("data[1].id");
		Assert.assertEquals(id, resid, "matched");
		System.out.println("data verified");
		resp.then().log().all();
	}
	@Test
	public void dyanamicresponse()
	{
		String expData="lindsay.ferguson@reqres.in";
		baseURI="https://reqres.in";
		
		Response resp=when().get("/api/users?page=2");
		boolean flag=false;
		List<String> pIDs=resp.jsonPath().get("data.email");
		for (String projectID : pIDs) 
		{
			if(projectID.equals(expData))
			{
				flag=true;
			}
			
		}
		Assert.assertTrue(flag);
		System.out.println("data is found");
		resp.then().log().all();
	}
	@Test
	public void dynamicdata()
	{
		String expData="cerulean";
		baseURI="https://reqres.in";
		
		Response resp=when().get("/api/unknown");
		boolean flag=false;
		List<String> pIDs=resp.jsonPath().get("data.name");
		for (String projectID : pIDs) 
		{
			if(projectID.equals(expData))
			{
				flag=true;
			}
			
		}
		Assert.assertTrue(flag);
		System.out.println("data is found");
		resp.then().log().all();
		
	}

}
