package crudwithbdd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteProj 
{
	@Test
	public void Delete()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		when()
		.delete("/projects/TY_PROJ_75466")
		.then()
		.assertThat()
		.statusCode(204)
		.log()
		.all();
	}

}
