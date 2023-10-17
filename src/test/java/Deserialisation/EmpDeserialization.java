package Deserialisation;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.EmployeePojo;

public class EmpDeserialization 
{
@Test
public void complexDataDeserialization() throws Throwable, JsonMappingException, IOException
{
	ObjectMapper Omap=new ObjectMapper();
	EmployeePojo ep =Omap.readValue(new File("./amlan.json"), EmployeePojo.class);
	System.out.println(ep.getName());
	System.out.println(ep.getNumber());
	System.out.println(ep.getId());
	}
}
