package diffrentwaystopostrequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectwithHashMap 
{
@Test
public void createProject()
{
	baseURI="http://rmgtestingserver";
	port=8084;
	HashMap<Object,Object> hm= new HashMap<Object,Object>();
	hm.put("createdBy", "amlan");
	hm.put("projectName", "Online banking model133w535");
	hm.put("status", "ongoing");
	hm.put("teamSize", 12);
	
	given()
	.body(hm)
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
