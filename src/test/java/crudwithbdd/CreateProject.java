package crudwithbdd;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProject 
{
	@Test
	public void createproj()
	{
		JavaUtility j=new JavaUtility();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Amlan");
		jObj.put("projectName","Online Banking"+j.getRandomNo());
		jObj.put("status","created");
		jObj.put("teamSize",15);
		//step 1 pre condition
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		//step 2 actions
		.when()
		.post("http://rmgtestingserver:8084/addProject")
		//step 3 
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
	}
}
