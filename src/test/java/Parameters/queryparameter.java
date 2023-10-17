package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class queryparameter 
{
@Test
public void query()
{
	
	given().queryParam("page",2)
	.when().get("https://reqres.in/api/users")
	.then().log().all();
	
	
	
	}
}
