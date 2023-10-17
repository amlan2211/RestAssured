package diffrentwaystopostrequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericUtility.CreateProject;
import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProjectwithPojo 
{  @Test
	public void create()
	{
	baseURI="http://rmgtestingserver";
	port=8084;
	JavaUtility j =new JavaUtility();
	CreateProject c= new CreateProject("amlan"," online banking system"+j.getRandomNo(), "created", 12);
	given()
	.body(c)
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
