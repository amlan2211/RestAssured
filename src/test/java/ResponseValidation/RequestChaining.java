package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChaining 
{
@Test
public void request()
{

	baseURI="http://rmgtestingserver";
	port=8084;
	
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy","Amlan");
	jObj.put("projectName","smafdhdftestbank");
	jObj.put("status","created");
	jObj.put("teamSize",15);
	
	Response cp=given().body(jObj).contentType(ContentType.JSON)
  .when()
  .post("/addProject");
	String pid=cp.jsonPath().get("projectId");
	System.out.println(pid);
			
	//cp.then().log().all();	
	when().get("/projects/"+pid)
	.then().log().all();
	
	}
}
