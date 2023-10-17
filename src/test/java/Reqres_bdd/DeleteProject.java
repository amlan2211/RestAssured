package Reqres_bdd;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProject 
{
	@Test
	public void delete()
	{
		
		baseURI="https://reqres.in";
		when()
		.delete("/api/users/2")
		.then()
		.assertThat()
		.statusCode(204)
		.log()
		.all();
		
	}

}
