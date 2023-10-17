package Reqres_bdd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class UpdateProject 
{
	@Test
	public void updateProject()
	{ 
		baseURI="https://reqres.in";	
		JavaUtility j=new JavaUtility();
		JSONObject jObj = new JSONObject();
		jObj.put("name","Amlan");
		jObj.put("job","sdet");

		//step 1 pre condition
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		//step 2 actions
		.when()
		.put("/api/users/2")
		//step 3 
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
		
		
		
		
		
		
		
		
	}

}
