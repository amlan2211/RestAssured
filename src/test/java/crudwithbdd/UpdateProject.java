package crudwithbdd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class UpdateProject 
{
	@Test
	public void update()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaUtility j=new JavaUtility();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Amlan");
		jObj.put("projectName","Online Banking"+j.getRandomNo());
		jObj.put("status","created");
		jObj.put("teamSize",10);
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		//step 2 actions
		.when()
		.put("/projects/TY_PROJ_75466")
		//step 3 
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
		
	}

}
