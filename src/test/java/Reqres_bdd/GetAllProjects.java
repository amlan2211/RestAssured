package Reqres_bdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjects 
{
	
@Test
public void getallproj()
{
	baseURI="https://reqres.in";		
	when()
	.get("/api/unknown")
	.then()
	.assertThat()
	.statusCode(200)
	.log()
	.all();
	
	
	
	}
}
