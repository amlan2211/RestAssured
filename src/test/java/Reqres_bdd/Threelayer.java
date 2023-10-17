package Reqres_bdd;


import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import GenericUtility.BaseClass;
import GenericUtility.DatabaseLibrary;
import GenericUtility.JavaUtility;
import GenericUtility.RestAssuredLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;


import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Threelayer extends BaseClass
{
	public static void main(String[] args) throws InterruptedException, Throwable 
	{
		
		JavaUtility jLib=new JavaUtility();
		DatabaseLibrary dLib= new DatabaseLibrary();
		RestAssuredLibrary rLib=new RestAssuredLibrary();
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
		 driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 Thread.sleep(2000);
		 String name="Online Banking systme"+jLib.getRandomNo();
		 System.out.println(name);
		 String expdata=name;
		 driver.findElement(By.xpath("//a[text()='Projects']")).click();
		 driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		 driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(name);
		 driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("sachin mn",Keys.TAB,Keys.ENTER,Keys.ARROW_DOWN,Keys.ENTER);
		 driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		 Thread.sleep(2000);
		 String id=driver.findElement(By.xpath("//td[text()='"+name+"']/preceding-sibling::td")).getText();
		 System.out.println(id);
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
			Thread.sleep(2000);
			when()
			.delete("/projects/"+id)
			.then()
			.assertThat()
			.statusCode(204)
			.log()
			.all();
	}

}
