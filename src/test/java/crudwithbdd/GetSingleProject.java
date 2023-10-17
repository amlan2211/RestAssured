package crudwithbdd;

import  static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetSingleProject 
{
	@Test
	public void getsingleproj()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		when()
		.get("/projects/TY_PROJ_76920")
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
		
	}
 
}
