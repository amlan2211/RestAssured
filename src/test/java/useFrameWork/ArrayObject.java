package useFrameWork;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import static io.restassured.RestAssured.*;

public class ArrayObject 
{
@Test
public void arrayObject() 
{
	
	baseURI="http://rmgtestingserver";
	port=8084;
	when().get("/projects/TY_PROJ_76302").then()
	.assertThat().body("", Matchers.instanceOf(Map.class)).log().all();
//	when().get("/projects").then()
//	.assertThat().body("", Matchers.instanceOf(java.util.List.class)).log().all();
	
	
	}
}
