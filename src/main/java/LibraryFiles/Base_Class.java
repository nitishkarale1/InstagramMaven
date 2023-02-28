package LibraryFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base_Class 
{
	public WebDriver driver;
	
	
	public void initializeBrowser(String BrowserName) throws IOException
	{
		
		if(BrowserName.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(BrowserName.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(Utility_Class.getPropertyFileData("URL"));
	}
	
}
