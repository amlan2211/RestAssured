package crudwithbdd;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateProject_1 
{
	@Test
	public void createprojct1() 
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaUtility j=new JavaUtility();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Amlan");
		jObj.put("projectName","Online Banking"+j.getRandomNo());
		jObj.put("status","created");
		jObj.put("teamSize",15);
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		//step 2 actions
		.when()
		.post("/addProject")
		//step 3 
		.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThan(300l), TimeUnit.SECONDS)
		.contentType(ContentType.JSON)
		.log()
		.all();
	}

}
