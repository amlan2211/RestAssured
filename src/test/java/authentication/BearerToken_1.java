package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerToken_1 
{
	@Test
	public void bearertoken()
	{
		baseURI="https://api.github.com";
		
		JSONObject jObj = new JSONObject();
		jObj.put("name","sdet_50_restassureed_16");
		given()
		.auth().oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		.when().post("/user/repos")
		.then().log().all();

	}
}
