package Pojo;

public class EmployeePojo 
{
	String name;
	long number;
	int id;
	public EmployeePojo(String name, long number, int id) {
		super();
		this.name = name;
		this.number = number;
		this.id = id;
	}
	public EmployeePojo() 
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
