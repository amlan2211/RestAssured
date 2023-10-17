package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectCreationPage 
{
	@FindBy(xpath="//input[@name='projectName']")
	private WebElement proj_name;
	@FindBy(xpath="//input[@name='createdBy']")
	private WebElement create_By;
	@FindBy(xpath="//input[@value='Add Project']")
	private WebElement add_prg;
	public WebElement getAdd_prg() {
		return add_prg;
	}

	public ProjectCreationPage(WebDriver driver) 
    {
   	 PageFactory.initElements(driver, this);
    }

	public WebElement getProj_name() 
	{
		return proj_name;
	}
	public WebElement getCreate_By() 
	{
		return create_By;
	}
	public void projCreate(String prj_name,String create_by)
	{
		proj_name.sendKeys(prj_name);
		create_By.sendKeys(create_by);
		add_prg.click();
		
	}
	
	
}
