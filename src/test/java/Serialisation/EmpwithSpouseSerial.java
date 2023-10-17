package Serialisation;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.EmpWithSpousePage;
import Pojo.SpousePojo;

public class EmpwithSpouseSerial 
{
	@Test
	public void employeeSpouse() throws Throwable, JsonMappingException, IOException
	{
		int[] num= {69699,96969};
		SpousePojo sp=new SpousePojo("priya", 18, num);
		int[] pnum= {619619,916916};
		EmpWithSpousePage esp=new EmpWithSpousePage("amlan", pnum, 10, sp);
		ObjectMapper om=new ObjectMapper();
		om.writeValue(new File("./empSpouse1.json"), esp);
	}

}
