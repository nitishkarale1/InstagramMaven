package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class instagramLoginPage 
{
	@FindBy(xpath="//input[@name='username']") private WebElement UN;
	@FindBy(xpath="//input[@name='password']") private WebElement PWD;
	@FindBy(xpath="//div[text()='Log in']") private WebElement loginBTN;
	
	public instagramLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpInstagramLoginPageUserName(String UserName)
	{
		UN.sendKeys(UserName);
	}
	
	public void inpInstagramLoginPagePassword(String Password)
	{
		PWD.sendKeys(Password);
	}
	
	public void clickInstagramLogiPageLoginBTN()
	{
		loginBTN.click();
	}
	
}
