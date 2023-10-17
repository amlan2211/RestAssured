package crudwithbdd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetallProjects 
{
@Test
public void getallProject()
{
	
	baseURI="http://rmgtestingserver";
	port=8084;
	when()
	.get("/projects")
	.then()
	.assertThat()
	.statusCode(200)
	.log()
	.all();
    
	
	
	
	
	}
}
