package GenericUtility;

import io.restassured.response.Response;

public class RestAssuredLibrary 

{

	
	public String getJsonData(Response respose,String path)
	{
		
		String jsonData=respose.jsonPath().get(path);
		return jsonData;
	}

}
