package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormPara 
{
	@Test
	public void form()
	{

		
		
		given().formParam("name", "amlan123")
		.formParam("job", "engineer")
		.contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/users")
		.then()
//	.assertThat()
//	.statusCode(201)
//	.contentType(ContentType.JSON)
		.log()
		.all();
	}

}
