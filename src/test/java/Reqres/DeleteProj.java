package Reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteProj 
{
@Test
public void DeleteProj()
{
	RequestSpecification reqs=RestAssured.given();
	
	reqs.contentType(ContentType.JSON);
	Response resp = reqs.delete("https://reqres.in/api/users/2");
	System.out.println(resp.prettyPrint());
	System.out.println(resp.contentType());
	}
}
