package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RegPage;
import testbase.TestBase;
import testbase.ExcelReader;


public class RegTest extends TestBase{
	HomePage h;
	RegPage r;
	ExcelReader e= new ExcelReader();
	
  @Test
  public void regTest() {
	 h =PageFactory.initElements(getDriver(), HomePage.class);
	  r=PageFactory.initElements(getDriver(), RegPage.class);
	  h.clickRegister();
	  r.enterRegisterdata("firstname", "lastname","email", "password123", "password123");
  }

 
	
}
