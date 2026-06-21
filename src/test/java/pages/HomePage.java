package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testbase.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(linkText="Log in")
	WebElement Link_Login;
	@FindBy(linkText="Log out")
	WebElement Link_Logout;
	
	@FindBy(linkText="Register")
	WebElement Link_Register;
	
	
	public void clickLogin()
	{
		Link_Login.click();
		//driver.findElement(By.linkText("Log in")).click();
	}
	public void clickLogout()
	{
		Link_Logout.click();
	}
	public void clickRegister()
	{
		Link_Register.click();
	}
	
	
}
