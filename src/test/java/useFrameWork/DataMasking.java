package useFrameWork;

import java.util.Random;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataMasking 
{
public static void main(String[] args) {
	Random random=new Random();
	int ran=random.nextInt();
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy","Amlan");
	jObj.put("projectName","online banking system"+ran);
	jObj.put("status","created");
	jObj.put("teamSize",23);
	given().config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type")))
	.body(jObj)
	.contentType(ContentType.JSON)
	.log().all()
	.when().post("http://rmgtestingserver:8084/addProject")
	.then()
	.assertThat().log().all();
	
	
}
}
