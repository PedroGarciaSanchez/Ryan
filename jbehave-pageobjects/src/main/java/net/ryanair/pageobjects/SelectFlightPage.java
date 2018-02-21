package net.ryanair.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage extends PageObject {

	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement destiny;	

	public SelectFlightPage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return destiny.isDisplayed();
	}
	
	public void enterDestiny(String destiny){
		this.destiny.clear();
		this.destiny.sendKeys(destiny);		
	}
	

}
