package Reqres_bdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject 
{
@Test
public void createProj()
{
	JavaUtility j=new JavaUtility();
	JSONObject jObj = new JSONObject();
	jObj.put("name","Amlan");
	jObj.put("job","engineers");
   
	//step 1 pre condition
	given()
	.body(jObj)
	.contentType(ContentType.JSON)
	//step 2 actions
	.when()
	.post("https://reqres.in/api/users")
	//step 3 
	.then()
	.assertThat()
	.statusCode(201)
	.contentType(ContentType.JSON)
	.log()
	.all();
	
	
	
	
	
	
}
}
