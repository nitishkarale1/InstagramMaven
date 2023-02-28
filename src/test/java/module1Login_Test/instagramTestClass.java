package module1Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import LibraryFiles.Base_Class;
import LibraryFiles.Utility_Class;
import Module1Login.instagramHomePage;
import Module1Login.instagramLoginPage;

public class instagramTestClass extends Base_Class
{
	instagramLoginPage login;
	instagramHomePage home;
	int TCID;
	
	@Parameters("BrowserName")
	@BeforeClass
	public void openBrowser(String BrowserName) throws IOException
	{
		initializeBrowser(BrowserName);
		
		login=new instagramLoginPage(driver);
		home=new instagramHomePage(driver);
	}
	
	@BeforeMethod
	public void LoginToInstagram() throws EncryptedDocumentException, IOException
	{
		login.inpInstagramLoginPageUserName(Utility_Class.getPropertyFileData("UN"));
		login.inpInstagramLoginPagePassword(Utility_Class.getPropertyFileData("PWD"));
		login.clickInstagramLogiPageLoginBTN();
	}
	
	@Test
	public void verifyUserID() throws EncryptedDocumentException, IOException
	{
		TCID=55;
		
		home.clickInstagramHomnePageNotNowBtn();
		home.clickInstagramHomePageturnOnNotificationNotNowBtn();
		home.clickInstagramHomePageProfile();
	
		SoftAssert soft=new SoftAssert();		
		
		String exp_UserID=Utility_Class.getTD(0, 0);
		soft.assertEquals(home.getInstagramHomePageUserID(), exp_UserID,"Failed: Both UserID's are different.");
		
		Reporter.log("running verifyUserID TC",true);
		soft.assertAll();
		
	}
	
	@Test
	public void verify_Name() throws EncryptedDocumentException, IOException
	{
		home.clickInstagramHomePageProfile();
	
		SoftAssert soft=new SoftAssert();
		String exp_Name=Utility_Class.getTD(0, 1);
		soft.assertEquals(home.getInstagramHomePageName(),exp_Name,"Failed: Both Names are differernt.");
		soft.assertAll();
		Reporter.log("running verify_Name TC",true);
	}
	
	@AfterMethod
	public void LogoutFromInstagram(ITestResult result) throws InterruptedException, IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.CaptureSS(driver, TCID);
		}
		
		home.clickInstagramHomePageMore(driver);
		Thread.sleep(2000);
		home.clickInstagramHomePageLogoutBtn();
	}
	
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}
	
}
