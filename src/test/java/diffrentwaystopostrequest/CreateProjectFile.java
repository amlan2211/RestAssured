package diffrentwaystopostrequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;



import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProjectFile
{
	@Test
	public void create()
	{
	baseURI="http://rmgtestingserver";
	port=8084;
	File f = new File("./CreateProject.json");
	given()
	.body(f)
	.contentType(ContentType.JSON)
	//step 2 actions
	.when()
	.post("/addProject")
	//step 3 
	.then()
	.assertThat()
	.statusCode(201)
	
	.contentType(ContentType.JSON)
	.log()
	.all();
	}
}
