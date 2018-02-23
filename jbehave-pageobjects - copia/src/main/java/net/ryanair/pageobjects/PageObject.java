package net.ryanair.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	protected WebDriver driver; 
	public PageObject(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this); 
	}
//	Read more at https://www.pluralsight.com/guides/software-engineering-best-practices/getting-started-with-page-object-pattern-for-your-selenium-tests#uZClXSIXYDAhRToF.99

}
