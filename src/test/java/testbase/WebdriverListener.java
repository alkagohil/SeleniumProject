package testbase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.events.WebDriverListener;

public class WebdriverListener extends TestBase implements  WebDriverListener  {

	 @Override
	    public void beforeClick(WebElement element) {
	        System.out.println("Before clicking: " + element);
	    }

	    @Override
	    public void afterClick(WebElement element) {
	        System.out.println("After clicking: " + element);
	    }

	    @Override
	    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
	        System.out.println("Error occurred: " + e.getMessage());
	    }	
}
