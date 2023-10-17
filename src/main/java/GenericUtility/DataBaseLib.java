package GenericUtility;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;


public class DataBaseLib
{
	 
	Driver driverRef;
	   Connection con;
	   
	   public void connectToDB() throws Throwable
	   {
		  driverRef= new Driver();
		  DriverManager.registerDriver(driverRef);
		   con=DriverManager.getConnection(Iconstant.dbURL,Iconstant.dbUsername,Iconstant.dbPassword );
	   }
	public void closeDB() throws SQLException
	{
		con.close();
	}
	public String readDataFromDBAndValidate(String query,int columnNo,String ExpData) throws SQLException
	{
		ResultSet result=con.createStatement().executeQuery(ExpData);
		boolean flag=false;
		while(result.next())
		{
			String data=result.getString(columnNo);
			if(data.equalsIgnoreCase(ExpData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data is verified");
			return ExpData;
		}
		else
		{
		System.out.println("data not verified");	
		return "";
		}
	}	

}
