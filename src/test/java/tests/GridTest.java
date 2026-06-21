package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
	
	WebDriver d;
  @Test
  public void f() {
	  //local chrome intialization
	// d= new ChromeDriver();
	  ChromeOptions o = new ChromeOptions();
	 o.setCapability(CapabilityType.PLATFORM_NAME,Platform.WINDOWS);
	 o.setCapability(CapabilityType.BROWSER_NAME,"chrome");
	  //other capability
	  URL ip;
	try {
		ip = new URL("http://172.26.87.81:5544/wd/hub");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ip=null;
	}
	//Chrome instance on Machine
	  d= new RemoteWebDriver(ip,o);
	  d.get("https://www.selenium.dev/downloads/");
  }
}
