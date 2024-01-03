package Test_1;

import static io.restassured.RestAssured.given;

import java.util.Iterator;

import org.testng.annotations.Test;




public class Test1 
{
	@Test
	public void Validation()
	{  
		int n=5;
		for(int i=0;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(" ");
			}
			
			for(int j=i;j<=n;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
	@Test
	public void validates() 
	{
		
		
	}

}
