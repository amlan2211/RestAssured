package GenericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass 
{
  public DatabaseLibrary dLib= new DatabaseLibrary();
  public JavaUtility jLib=new JavaUtility();
  public RestAssuredLibrary rLib=new RestAssuredLibrary();
  public RequestSpecification reqst;
  public ResponseSpecification resp;
  @BeforeSuite
  public void bsConfig() throws Throwable
  {
	  dLib.connectToDB();
	  reqst=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
			  .setContentType(ContentType.JSON).build();
	  resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
  }
  @AfterSuite
  public void asConfig() throws SQLException
  {
	 dLib.closeDB();
  }
}
