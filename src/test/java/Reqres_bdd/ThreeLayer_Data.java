package Reqres_bdd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.DatabaseLibrary;
import GenericUtility.JavaUtility;
import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ThreeLayer_Data 
{
	@Test
	public void CreateProj() throws Throwable
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaUtility j=new JavaUtility();
		String name="Online banking"+j.getRandomNo();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Amlan");
		jObj.put("projectName",name);
		jObj.put("status","created");
		jObj.put("teamSize",15);
		//step 1 pre condition
		Response cp=given().body(jObj).contentType(ContentType.JSON)
	   .when()
	   .post("/addProject");
		String pid=cp.jsonPath().get("projectId");
		System.out.println(pid);
		when().get("/projects/"+pid)
		.then().log().all();
		JavaUtility jLib=new JavaUtility();
		DatabaseLibrary dLib= new DatabaseLibrary();
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		LoginPage lg= new LoginPage(driver);
		lg.Loginpage("rmgyantra", "rmgy@9999");
		Thread.sleep(2000);
		HomePage hp=new HomePage(driver);
		hp.HomePageProjectClick();
		Thread.sleep(2000);
		String id=driver.findElement(By.xpath("//td[text()='"+name+"']/preceding-sibling::td")).getText();
		 System.out.println(id);
		 Thread.sleep(2000);
	     Assert.assertEquals(pid, id);
	     System.out.println("data is present in database");
	     driver.quit();
	     baseURI="http://rmgtestingserver";
			port=8084;
			Response resp=when().get("/projects/"+id);
			String query="select* from project";
			dLib.connectToDB();
			String pname=dLib.readDataFromDBAndValidate(query, 1, id);
			Assert.assertEquals(pname, id);
			System.out.println("test case is pass");
			resp.then().log().all();
		 
		
	}

}
