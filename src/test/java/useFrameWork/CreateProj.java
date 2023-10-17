package useFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.CreateProject;
import GenericUtility.EndPointsLibrary;
import GenericUtility.JavaUtility;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProj extends BaseClass
{
	
	@Test
	public void createProj() throws Throwable
	{
		CreateProject cp =new CreateProject("amlan","tyss"+jLib.getRandomNo(),"created", 12);
		Response resp=given().spec(reqst).body(cp)
		//.body(cp)
		//.contentType)(contentType.json)
		.when().post(EndPointsLibrary.createProject);
		//capture the project ID
		String expData=rLib.getJsonData(resp, "projectId");
		System.out.println(expData);
		String query="select* from project";
		String actData=dLib.readDataFromDBAndValidate(query, 1, expData);
		Assert.assertEquals(expData, actData);
		System.out.println("test case is pass");
		resp.then().log().all();
		
	}

}
