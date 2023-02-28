package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility_Class 
{
	public static String getTD(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspacee\\instagramMaven\\TestData\\instagramTD.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value=sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}
	
	public static void CaptureSS(WebDriver driver, int TCID) throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\LENOVO\\eclipse-workspacee\\Selenium\\Screenshots\\testCaseID"+TCID+".jpg");
		FileHandler.copy(src, dest);
	}
	
	public static String getPropertyFileData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\propertyFile.properties");
		Properties p=new Properties();
		p.load(file);
		String KeyValue = p.getProperty(key);
		return KeyValue;
	}
}
