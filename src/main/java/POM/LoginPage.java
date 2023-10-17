package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password ;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement sign_btn;
	public LoginPage(WebDriver driver) 
    {
   	 PageFactory.initElements(driver, this);
    }
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSign_btn() {
		return sign_btn;
	}
	public void Loginpage(String un,String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		sign_btn.click();
	}
}
