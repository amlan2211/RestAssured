package Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject 
{
	@Test
	public void updateproject()
	{

		JSONObject jObj = new JSONObject();
		
		jObj.put("name","amlanmishra");
		jObj.put("job","engineer-2133691475");
	
		
		RequestSpecification reqs=RestAssured.given();
		reqs.body(jObj);
		reqs.contentType(ContentType.JSON);
		Response resp = reqs.put("https://reqres.in/api/users/2");
		System.out.println(resp.prettyPrint());
		System.out.println(resp.contentType());
	}

}
