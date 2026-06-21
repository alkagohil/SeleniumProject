package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

@FindBy(id="Email")	
WebElement Textbox_Email;

@FindBy(id="Password")	
WebElement Textbox_Password;


@FindBy(xpath="//input[@value='Log in']")	
WebElement Link_Login;
	

public void enterLoginData(String u,String p)
{
	Textbox_Email.sendKeys(u);
	Textbox_Password.sendKeys(p);
	Link_Login.click();
}
	 
}
