package testbase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;


public class BrowserFactory {

	public static  WebDriver createWebDriver(String browser,String browserType,String ip)
	{
		WebDriver driver=null;
		WebDriver ef;
		if(browser.equals("chrome") && browserType.equals("local"))
		{
		  
		  driver=new ChromeDriver();
		}
		if(browser.equals("firefox")&& browserType.equals("local"))
		{
			  
			  driver=new FirefoxDriver();
			
		}
		if(browser.equals("chrome") && browserType.equals("remote"))
		{
			 ChromeOptions o = new ChromeOptions();
			 o.setCapability(CapabilityType.PLATFORM_NAME,Platform.LINUX);
			 o.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			  //other capability
			  URL u=null;
			try {
				u = new URL(ip);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ip=null;
			}
			//Chrome instance on Machine
			  driver= new RemoteWebDriver(u,o);
		}
		if(browser.equals("firefox")&& browserType.equals("remote"))
		{
			FirefoxOptions o = new FirefoxOptions();
			 o.setCapability(CapabilityType.PLATFORM_NAME,Platform.LINUX);
			 o.setCapability(CapabilityType.BROWSER_NAME,"firefox");
			  //other capability
			  URL u=null;
			try {
				u = new URL(ip);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ip=null;
			}
			//Chrome instance on Machine
			  driver= new RemoteWebDriver(u,o);
			
		}
		//custom listener
		WebDriverListener listener = new WebdriverListener();
        WebDriver decoratedDriver =
            new EventFiringDecorator(listener).decorate(driver);

		driver.manage().window().maximize();
		return decoratedDriver;
	}
	
}
