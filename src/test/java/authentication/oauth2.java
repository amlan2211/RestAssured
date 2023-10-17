package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class oauth2 
{
	@Test
	public void oauth()
	{
		
		Response resp=given()
				.formParam("client_id","sdet_50_amlan")
				.formParam("client_secret","e078ee9cc947e48f7768a045e86b69c3")
				.formParam("grant_type","client_credentials")
				.formParam("redirect_uri","http://example.com")
				.formParam("code","authorization_code")
				.when()
				.post("http://coop.apps.symfonycasts.com/token ");
		     //   resp.then().log().all();
		  String token=resp.jsonPath().get("access_token");
		  System.out.println(token);
		  given().auth().oauth2(token)
		  .pathParam("User_Id", 4673)
		  .when().post("http://coop.apps.symfonycasts.com/api/{User_Id}/chickens-feed")
		  .then().log().all();
				
	}

}
