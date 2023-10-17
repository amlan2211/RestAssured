package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class StaticResponseValidstion 
{
@Test
public void staticresponse()
{  
	
	String expData="TY_PROJ_20293";
	baseURI="http://rmgtestingserver";
	port=8084;
	Response resp=when().get("/projects");
	String actData=resp.jsonPath().get("[0].projectId");
	Assert.assertEquals(expData, actData, "matched");
	System.out.println("data verified");
	resp.then().log().all();
	
	}
}
