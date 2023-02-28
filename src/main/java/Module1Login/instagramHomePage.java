package Module1Login;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class instagramHomePage 
{
	@FindBy(xpath="//div[text()='Profile']") private WebElement Profile;
	@FindBy(xpath="//h2[text()='nitish_karale']") private WebElement UID;
	@FindBy(xpath="//span[text()='Nitish_Karale ]NK[']") private WebElement Name;
	@FindBy(xpath="(//div[text()='More'])[1]") private WebElement More;
	@FindBy(xpath="(//div[@class='_aa61']/div)[7]") private WebElement Logout;
	@FindBy(xpath="//button[text()='Not Now']") private WebElement NotNow;
	@FindBy(xpath="//button[@class='_a9-- _a9_1']") private WebElement TON_NotNow;
	
	public instagramHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickInstagramHomnePageNotNowBtn()
	{
		NotNow.click();	
	}
	
	public void clickInstagramHomePageturnOnNotificationNotNowBtn()
	{
		TON_NotNow.click();
	}
	
	public void clickInstagramHomePageProfile()
	{
		Profile.click();
	}
	
	public String getInstagramHomePageUserID()
	{
		String act_UID=UID.getText();
		return act_UID;
	}
	
	public String getInstagramHomePageName()
	{
		String MyName = Name.getText();
		return MyName;
	}
	
	public void clickInstagramHomePageMore(WebDriver driver)
	{
		More.click();
	}
	
	public void clickInstagramHomePageLogoutBtn()
	{
		Logout.click();
	}
	
}
