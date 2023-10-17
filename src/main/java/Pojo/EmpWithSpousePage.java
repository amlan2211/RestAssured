package Pojo;

public class EmpWithSpousePage 
{
String name;
int[] number;
int age;
SpousePojo spouse;
public EmpWithSpousePage(String name, int[] number, int age, SpousePojo spouse) {
	super();
	this.name = name;
	this.number = number;
	this.age = age;
	this.spouse = spouse;
}
public EmpWithSpousePage() {
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int[] getNumber() {
	return number;
}
public void setNumber(int[] number) {
	this.number = number;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public SpousePojo getSpouse() {
	return spouse;
}
public void setSpouse(SpousePojo spouse) {
	this.spouse = spouse;
}


}
