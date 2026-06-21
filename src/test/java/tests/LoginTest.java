package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import testbase.TestListener;
import testbase.ExcelReader;


@Listeners({testbase.TestListener.class})
public class LoginTest extends TestBase {
	HomePage h;
	LoginPage l;
	ExcelReader e = new ExcelReader();
  @Test(dataProvider="loginData")
  public void validDataLoginTest(String u,String p) {
	
	  h=PageFactory.initElements(getDriver(), HomePage.class);
	  l=PageFactory.initElements(getDriver(), LoginPage.class);
	  h.clickLogin();
	  l.enterLoginData(u, p);
	  /* driver.findElement(By.id("Email")).sendKeys("Itest@test.com");
	  driver.findElement(By.id("Password")).sendKeys("Itest@test");
	  driver.findElement(By.xpath("//input[@value='Log in']")).click();*/

	  try
	  {
		  h.clickLogout();
	  }catch(Exception e)
	  {
		  Assert.fail("LogOut button not found");
	  }
  }

  @DataProvider
  public Object[][] loginData()
  {
	  Object data[][]= e.getTestData("LoginData");
	  return data;
  }
  


}

