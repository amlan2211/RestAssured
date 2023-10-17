package Serialisation;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

public class Serialisation {
	@Test
	public void startSeriliasation() throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper Omap=new ObjectMapper();
		Pojo.EmployeePojo ep=new Pojo.EmployeePojo("amlan",12432433,12);
		Omap.writeValue(new File("./amlan.json"), ep);
		Omap.writerWithDefaultPrettyPrinter().writeValue(new File("./amlan12.json"), ep);
		
		
		
	}

}
