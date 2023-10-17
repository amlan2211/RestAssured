package Pojo;

public class SpousePojo 
{
	String name;
	int age;
	int[] phone;
	public SpousePojo(String name, int age, int[] phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public SpousePojo() 
	{
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(int[] phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int[] getPhone() {
		return phone;
	}
	

}
