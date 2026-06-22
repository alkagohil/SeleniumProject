package testbase;
//this is comment
//This is comment 2
//This is comment 3

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase {

	
	private static final ThreadLocal<WebDriver> drivers=
			new ThreadLocal<WebDriver>();

	
@Parameters({"browsername","browserType","URL","ip"})
@BeforeMethod	
public void intialization(String browser,String browserType,String url,@Optional("ip")String ip)
{
	
	//sizing of window
	//cookie management
	//capability setting
		WebDriver driver = BrowserFactory.createWebDriver(browser,browserType,url);
		drivers.set(driver);
	  driver.get(url);
	  
}
public WebDriver getDriver()
{
	return drivers.get();
}
@AfterMethod
public void tearDown()
{
	getDriver().close();
}
public String captureScreenshot()
{
	TakesScreenshot ts = (TakesScreenshot)getDriver();
	File f = ts.getScreenshotAs(OutputType.FILE);
	File target = new File("\\test-output\\screenshots\\ss_"+System.currentTimeMillis()+".png");
	try {
		FileUtils.copyFile(f, target);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String path = target.getAbsolutePath();
	return path;
}

}
