package Test;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class SchemaValida 
{
@Test
public void schema()
{
	File file=new File("./Schema.json");
	when().get("https://reqres.in/api/users?page=2").then().assertThat()
	.body(JsonSchemaValidator.matchesJsonSchema(file)).log().all();
	
	
			}
}
