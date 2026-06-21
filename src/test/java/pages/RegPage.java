package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegPage {
	
@FindBy(id="gender-female")
WebElement RadioBtn_Female;

@FindBy(id="FirstName")
WebElement TextBox_FirstName;

@FindBy(id="LastName")
WebElement TextBox_LastName;


@FindBy(id="Email")
WebElement TextBox_Email;

@FindBy(id="Password")
WebElement TextBox_Password;

@FindBy(id="ConfirmPassword")
WebElement TextBox_ConfirmPassword;

public void enterRegisterdata(String f,String l,String e,String p,String cp)
{
	RadioBtn_Female.click();
	TextBox_FirstName.sendKeys(f);
	TextBox_LastName.sendKeys(l);
	TextBox_Email.sendKeys(e);
	TextBox_Password.sendKeys(p);
	TextBox_ConfirmPassword.sendKeys(cp);
}

}
