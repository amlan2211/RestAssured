package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath="//a[text()='Projects']")
	private WebElement Projects;
	@FindBy(xpath="//a[text()='Users']")
	private WebElement users;
	@FindBy(xpath="//a[text()='Settings']")
	private WebElement settings;
	public HomePage(WebDriver driver) 
    {
   	 PageFactory.initElements(driver, this);
    }
	public WebElement getProjects() {
		return Projects;
	}
	public WebElement getUsers() {
		return users;
	}
	public WebElement getSettings() {
		return settings;
	}
	public void HomePageProjectClick()
	{
		Projects.click();
	}
	

}
