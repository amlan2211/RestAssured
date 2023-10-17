package Reqres_bdd;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import GenericUtility.DatabaseLibrary;
import GenericUtility.JavaUtility;
import POM.CreateProjects;
import POM.HomePage;
import POM.LoginPage;
import POM.ProjectCreationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ThreeLayerUpdate 
{
public static void main(String[] args) throws Throwable 
{
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
	CreateProjects cp=new CreateProjects(driver);
	cp.Createproj();
	Thread.sleep(2000);
	 String name="Online Banking systme"+jLib.getRandomNo();
	ProjectCreationPage pc=new ProjectCreationPage(driver);
	pc.projCreate(name, "amlan");
	Thread.sleep(2000);
	String id=driver.findElement(By.xpath("//td[text()='"+name+"']/preceding-sibling::td")).getText();
	 System.out.println(id);
	 baseURI="http://rmgtestingserver";
		port=8084;
		JavaUtility j=new JavaUtility();
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy","Amlan kiran");
		jObj.put("projectName","Online Banking"+j.getRandomNo());
		jObj.put("status","on going");
		jObj.put("teamSize",10);
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		//step 2 actions
		.pathParam("pid",id)
		.when().put("/projects/{pid}")
		//step 3 
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log()
		.all();
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
