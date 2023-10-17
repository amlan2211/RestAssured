package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter 
{
	@Test
	public void path()
	{
		
		baseURI="http://rmgtestingserver";
		port=8084;
		given().pathParam("pid","TY_PROJ_76920")
		.when().get("/projects/{pid}")
		.then().log().all();
	}

}
