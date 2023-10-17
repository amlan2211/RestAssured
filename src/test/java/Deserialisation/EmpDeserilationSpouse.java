package Deserialisation;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.EmpWithSpousePage;

public class EmpDeserilationSpouse 
{
	@Test
	public void deserilazation() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper Omap=new ObjectMapper();
		EmpWithSpousePage esp = Omap.readValue(new File("./empSpouse1.json"), EmpWithSpousePage.class);	
		System.out.println(esp.getName());
		System.out.println(esp.getAge());
		System.out.println(esp.getClass());
		System.out.println(esp.getNumber());
	}
}
