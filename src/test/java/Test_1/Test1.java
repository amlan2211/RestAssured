package Test_1;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test1 
{
	@Test
	public void Validation()
	{

		given().
//	.assertThat()
//	.statusCode(201)
//	.contentType(ContentType.JSON)
		.log()
		.all();
		
		
		
	}

}
