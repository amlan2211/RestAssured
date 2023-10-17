package Reqres;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class GetProjectWithoutbdd
{
	@Test
	public void getproject()
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
