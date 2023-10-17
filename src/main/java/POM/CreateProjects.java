package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProjects 
{
	@FindBy(xpath="//span[text()='Create Project']")
	private WebElement create_prg;
	public CreateProjects(WebDriver driver) 
    {
   	 PageFactory.initElements(driver, this);
    }
	public WebElement getCreate_prg() {
		return create_prg;
	}
	public void Createproj()
	{
		create_prg.click();
	}
}
