package Validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderValidation 
{
	String pid="TY_PROJ_76354";
	{baseURI="http://rmgtestingserver";
	port=8084;}
	@Test
	public void validation()
	{
		
		String expectedStatusLine = "HTTP/1.1 500 ";
		String  expectedPragma = "no-cache";
		String expectedContent_Type = "application/json";;
		String expectedConnection = "close";
		String expectedVary = "Access-Control-Request-Headers";
		Response res = when()
				.get("/projects/"+pid);
		String actualStatusLine = res.statusLine();
		assertEquals(actualStatusLine, expectedStatusLine);
		System.out.println(actualStatusLine);
		System.out.println("Success");
		Headers headers = res.getHeaders();
		System.out.println(headers);
		String actualPragma = res.getHeader("Pragma");
		assertEquals(actualPragma, expectedPragma);
		System.out.println(actualPragma);
		System.out.println("Success");
		String actualContent_Type = res.getHeader("Content-Type");
		assertEquals(actualContent_Type, expectedContent_Type);
		System.out.println(actualContent_Type);
		System.out.println("Success");
		String actualConnection = res.getHeader("Connection");
		assertEquals(actualConnection, expectedConnection);
		System.out.println(actualConnection);
		System.out.println("Success");

		String actualVary = res.getHeader("Vary");
		assertEquals(actualVary, expectedVary);
		System.out.println(actualVary);
		System.out.println("Success");
		System.out.println("--------------------------");
				
		
	}

}
