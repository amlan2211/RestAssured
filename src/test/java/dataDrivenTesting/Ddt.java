package dataDrivenTesting;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.CreateProject;
import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Ddt 
{
	@DataProvider(name="getData")
	public Object[][] data()
	{
		Object[][] data=new Object[3][4];
		data[0][0]="sachin";
		data[0][1]="Dell";
		data[0][2]="complted";
		data[0][3]=12;
		data[1][0]="prakash";
		data[1][1]="Hp";
		data[1][2]="created";
		data[1][3]=15;
		data[2][0]="vikas";
		data[2][1]="TYSS";
		data[2][2]="On Going";
		data[2][3]=20;
		return data;
	}
	@Test(dataProvider = "getData")
		public void createProject(String createdBy,String projectName,String status,int teamSize)
		{
		JavaUtility jLib=new JavaUtility();
		CreateProject pLib=new CreateProject(createdBy, projectName+jLib.getRandomNo(), status, teamSize);
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
		
		}
		
	
	

}
