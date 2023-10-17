package diffrentwaystopostrequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjFileReqres 
{

	@Test
	public void createproj()
	{
		baseURI="https://reqres.in/";
		
		HashMap<Object,Object> hm= new HashMap<Object,Object>();
		hm.put("name", "amlan");
		hm.put("job", "engineer");
	
		
		given()
		.body(hm)
		.contentType(ContentType.JSON)
		//step 2 actions
		.when()
		.post("/api/users")
		//step 3 
		.then()
		.assertThat()
		.statusCode(201)
		
		.contentType(ContentType.JSON)
		.log()
		.all();
	}
}
