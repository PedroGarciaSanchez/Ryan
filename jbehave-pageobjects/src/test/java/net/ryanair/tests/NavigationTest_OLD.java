package net.ryanair.tests;

import static org.junit.Assert.assertTrue;
import net.ryanair.pageobjects.SelectFlightPage;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class NavigationTest_OLD extends DriverManage {	

	@Given("I make a booking from “DUB” to “SXF” on 12/03/2018 for 2 adults and 1 child")
	public void selectFlight() {
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

	//	@Test
	//	public void signUp(){
	//		driver.get("https://www.ryanair.com/ie/en/");
	//		
	//		SignUpPage signUpPage = new SignUpPage(driver);
	//		assertTrue(signUpPage.isInitialized());
	//
	//		signUpPage.enterName("First", "Last");
	//		signUpPage.enterAddress("123 Street", "12345");
	//
	//		ReceiptPage receiptPage = signUpPage.submit();
	//		assertTrue(receiptPage.isInitialized());
	//
	//		assertEquals("Thank you", receiptPage.confirmationHeader());		
	//		
	//	}	
}
