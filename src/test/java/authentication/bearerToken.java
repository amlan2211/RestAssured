package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class bearerToken 
{
	@Test
	public void bearerToken()
	{
		baseURI="https://api.github.com";
	
		JSONObject jObj = new JSONObject();
		jObj.put("name","sdet_50_restassured_12");
		given()
		.auth().oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		.when().post("/user/repos")
		.then().log().all();
	}

}
