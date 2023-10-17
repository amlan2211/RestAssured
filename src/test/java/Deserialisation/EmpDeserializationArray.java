package Deserialisation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import Pojo.EmployeePojoArray;

public class EmpDeserializationArray 
{
@Test
public void employee() throws Throwable, JsonMappingException, IOException
{
	int[] arr= {69699,96966};
	EmployeePojoArray epa=new EmployeePojoArray("amlan", arr, 30);
	ObjectMapper om =new ObjectMapper();
	om.writeValue(new File("./amlan.json"), epa);
	}
}
