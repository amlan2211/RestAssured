package GetJson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetJsonResponse 
{
  @Test
  public void GetJson() throws Throwable, JsonMappingException, IOException
  {
	  RequestSpecification reqs=RestAssured.given();
		Response resp = reqs.get("https://reqres.in/api/users/2");
		String stp=resp.getBody().asString();
		System.out.println(stp);
		FileWriter writer=new FileWriter(new File(".\\response.json"));
		writer.write(stp);
		writer.flush();
		
		
		
  }
}
