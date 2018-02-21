package net.ryanair.tests;

import java.util.concurrent.TimeUnit;

import net.ryanair.pageobjects.PageObject;
import net.ryanair.pageobjects.ReceiptPage;
import net.ryanair.pageobjects.SelectFlightPage;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RyanScenarioSteps extends DriverManage {
	

//	public ATMScenarioSteps() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	@Given("I make a booking from “DUB” to “SXF” on 12/03/2018 for 2 adults and 1 child")
	public void selectFlight() {
		//System.setProperty("webdriver.gecko.driver", "D:\\APPSYS\\AtSQA\\Windows\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Pedro García\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.ryanair.com/ie/en/");	
		
		SelectFlightPage selectFlight = new SelectFlightPage(driver);
		assertTrue(selectFlight.isInitialized());	
		selectFlight.enterDestiny("Dublin");			
	}

	@When("I pay for booking with card details 5555 5555 5555 5557, 10/18 and 265")
	public void createCreditCard() {	       
	}


	@Then("I should get payment declined message")
	public void checkMoney(@Named("result") int amount) {	       
	}

}
