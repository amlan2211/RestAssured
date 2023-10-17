package RequestSpecification;

import org.testng.annotations.Test;

import GenericUtility.CreateProject;
import GenericUtility.JavaUtility;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class createProj 
{
    @Test
    public void createProj()
    {
    	JavaUtility jLib= new JavaUtility();
    		CreateProject cp=new CreateProject("amlan","tyss"+jLib.getRandomNo(),"on going", 12);
    		 RequestSpecification reqst = new RequestSpecBuilder()
    		.setBaseUri("http://rmgtestingserver:8084")
    		.setContentType(ContentType.JSON).build();
    		ResponseSpecification resp = new ResponseSpecBuilder()
    		 .expectContentType(ContentType.JSON)
    		 .expectStatusCode(201).build();
    	  given().spec(reqst).body(cp)
    	  .when().post("/addProject")
    	  .then().spec(resp).log().all();
    }
}
