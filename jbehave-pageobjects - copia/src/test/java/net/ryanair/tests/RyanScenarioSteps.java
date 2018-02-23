package net.ryanair.tests;

import java.util.concurrent.TimeUnit;

import net.ryanair.pageobjects.PageObject;
import net.ryanair.pageobjects.PricesPage;
import net.ryanair.pageobjects.ReceiptPage;
import net.ryanair.pageobjects.SelectFlightPage;
import net.ryanair.pageobjects.SelectSeatsPage;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RyanScenarioSteps extends DriverManage {
	
	//Start the driver
	public RyanScenarioSteps(){
		super();
	}

	@Given("I make a booking from “DUB” to “SXF” on 12/03/2018 for 2 adults and 1 child")
	public void selectFlight() throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "D:\\APPSYS\\AtSQA\\Windows\\geckodriver.exe");
		//driver = new FirefoxDriver();		
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		
		
//		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		
		driver.get("https://www.ryanair.com/ie/en/");	
	
//FLIGHTS	
		SelectFlightPage selectFlight = new SelectFlightPage(driver);
		assertTrue(selectFlight.isInitialized());	
		selectFlight.enterDestiny("Dublin");

		selectFlight.clickCloseAdd();		
		
		selectFlight.clickOneWayButton();		
		selectFlight.clickContinueButton();
		selectFlight.clickPassengersDropdown();
		selectFlight.clickAdultsButton();
		selectFlight.clickChildrenButton();
		selectFlight.enterDate("26");			
		selectFlight.clickLetsgoButton();

//PRICES

		PricesPage selectPrice = new PricesPage(driver);	
		assertTrue(selectPrice.isInitialized());		
		selectPrice.clickFirstPrice();
		selectPrice.clickStandardFare();
		selectPrice.clickButtonContinue();
		selectPrice.clickButtonOk();
		
		//SEATS SELECTION
		
	    SelectSeatsPage selectSeats = new SelectSeatsPage(driver);
	    System.out.println("titulo: " + driver.getCurrentUrl());
	    assertTrue(selectSeats.isInitialized());
	    selectSeats.clickOnSeats();
	    selectSeats.clickNextButton();
	}
	
	
	


	@When("I pay for booking with card details 5555 5555 5555 5557, 10/18 and 265")
	public void createCreditCard() {
		
	}


	@Then("I should get payment declined message")
	public void checkMoney(@Named("result") int amount) {	       
	}

}
