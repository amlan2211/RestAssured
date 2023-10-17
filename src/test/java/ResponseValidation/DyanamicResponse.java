package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DyanamicResponse 
{
	@Test
	public void dynamicresponse()
	{
		
		String expData="TY_PROJ_9938";
		baseURI="http://rmgtestingserver";
		port=8084;
		Response resp=when().get("/projects");
		boolean flag=false;
		List<String> pIDs=resp.jsonPath().get("projectId");
		for (String projectID : pIDs) 
		{
			if(projectID.equalsIgnoreCase(expData))
			{
				flag=true;
			}
			
		}
		Assert.assertTrue(flag);
		System.out.println("data is found");
//		resp.then().log().all();
	}

}
