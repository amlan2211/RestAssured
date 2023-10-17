package GenericUtility;

import java.util.Random;

public class JavaUtility 
{
	 public int  getRandomNo()
	 {
		 Random ran=new Random();
		 int random=ran.nextInt();
		 return random;
	 }
}
