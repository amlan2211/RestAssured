package authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth_2 
{
	@Test
	public void auth2()
	{
		Response resp=given()
				.formParam("client_id","sdet-50 restassured authorization")
				.formParam("client_secret","9c4bc942eb450bc7aa00a72fb697205f")
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
