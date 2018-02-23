package net.ryanair.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import net.ryanair.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static org.junit.Assert.assertTrue;

public class SelectSeatsPage extends PageObject {	

	By by;
	////tr[not(@id) and not(@class)]
	@FindBy(xpath="(//span[@class='seat-click']/img[@class='icon-26 seat-person' and not(following-sibling::*)])[1]") 
	private WebElement selectFreeSeat1;

	@FindBy(xpath="(//span[@class='seat-click']/img[@class='icon-26 seat-person' and not(following-sibling::*)])[2]") 
	private WebElement selectFreeSeat2;

	@FindBy(xpath="(//span[@class='seat-click']/img[@class='icon-26 seat-person' and not(following-sibling::*)])[3]") 
	private WebElement selectFreeSeat3;

	@FindBy(xpath="//button[text()='Confirm']")	 
	private WebElement confirmButton;

	@FindBy(xpath="//button//span//translate//span[text()='Next'")	 
	private WebElement nextButton;

	public SelectSeatsPage(WebDriver driver) {		
		super(driver);
	}

	public boolean isInitialized() {
		//return selectFreeSeat1.isDisplayed();
		Utils utils= new Utils();
		//By by = By.xpath("(//span[@class='seat-click']/img[@class='icon-26 seat-person' and not(following-sibling::*)])[1]");
		by = By.xpath("//span[text()='Seat(s) selection']");		
		long time = 10;
		return(utils.isClickable(driver, by, time));	
		//						by = By.xpath("(//div[@class='core-btn-primary'])[1]");				
		//						long time = 10;
		//						Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		//							    .withTimeout(time, TimeUnit.SECONDS)
		//							    .pollingEvery(5, TimeUnit.SECONDS)
		//							    .ignoring(NoSuchElementException.class);
		//						try{
		//							wait.until(ExpectedConditions.presenceOfElementLocated(by));					
		//							return true;
		//						} catch (TimeoutException e){	
		//							System.out.println("*********Element " + by.toString() + " not found after " + time + " seconds");
		//							return false;			
		//						}		
	}	
	//	public void clickButtonContinue(){		
	//		Utils utils= new Utils();
	//		By by = By.id("continue");
	//		assertTrue(utils.isClickable(driver, by, 5));		
	//		
	//	
	//		JavascriptExecutor js = (JavascriptExecutor) driver;		
	//		js.executeScript("arguments[0].click();", this.buttonContinue);		
	//	}
	//	
	//	public void clickButtonOk(){
	//		JavascriptExecutor js = (JavascriptExecutor) driver;		
	//		js.executeScript("arguments[0].click();", this.buttonOk);		
	//	}

	public void clickOnSeats() throws InterruptedException{
		for(int i=1; i<=3; i++){

			Thread.sleep(3000);

			JavascriptExecutor js = (JavascriptExecutor) driver;		
			js.executeScript("arguments[0].click();", this.selectFreeSeat1);
		//	this.confirmButton.click();	

			By bySeat2 = By.xpath("(//span[@class='seat-click']/img[@class='icon-26 seat-person' and not(following-sibling::*)])[2]");
			By bySeat3 = By.xpath("(//span[@class='seat-click']/img[@class='icon-26 seat-person' and not(following-sibling::*)])[3]");
			By byConfirm = By.xpath("//button[text()='Confirm']");
			//			Utils utils= new Utils();
			//					
			//	long time = 10;
			//			if(utils.isClickable(driver, by, time)){			
			//
			//				js.executeScript("arguments[0].click();", this.selectFreeSeat2);			
			//				this.confirmButton.click();		
			//			}

            assertTrue(keepOnCLicking(selectFreeSeat2, byConfirm));
			//if (keepOnCLicking(bySeat2, byConfirm)){
			//	this.confirmButton.click();	
		//	}
            assertTrue(keepOnCLicking(selectFreeSeat3, byConfirm));
//			if (keepOnCLicking(bySeat3, byConfirm)){			
//				this.confirmButton.click();	
//			}
			
			
			//			try {
			//				Thread.sleep(2000);
			//			} catch (InterruptedException e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}
			//			js.executeScript("arguments[0].click();", this.confirmButton);
		}
	}
	public void clickNextButton(){
		this.nextButton.click();			
	}	

	//Clickar  en asiento hasta que salga "confirm"
	public boolean keepOnCLicking(WebElement elementToClick , By expectedElement) throws InterruptedException
	{
		// driver.findElement(By.id("stopEngineButton")).click(); // click the stop engine button

		List<WebElement> expectedElementList;
		boolean found = false;
		int i = 0;
		while (!found && i < 10) // 10 * 1s = 10 sec
		{
			Thread.sleep(1000);
			//driver.findElement(elementToClick).click(); // click the Refresh Status button
			
			JavascriptExecutor js = (JavascriptExecutor) driver;		
			js.executeScript("arguments[0].click();", elementToClick);
			//ESTA PARTE SOLO VA A VECES, CUANDO TE PIDE CONFIRMACION. LAS ÚLTIMAS VECES NO ME LA HA PEDIDO. 
			//CONTEMPLAR AMBAS POSIBILIDADES
			expectedElementList = driver.findElements(expectedElement); // compare the current engine status to Offline
			if (expectedElementList.size() > 0){
				found = true;
			}
			i++;
		}
		return found;
	}



	//	    
	//	    // SELECCION DE ASIENTO
	//	  //--------------------------------------------------------
	//	    driver.findElement(By.cssSelector("button.core-btn-primary.same-seats")).click();
	//	    driver.findElement(By.cssSelector("button.core-link.dialog-overlay-footer__cancel-button")).click();
	//	    driver.findElement(By.cssSelector("button.core-link.dialog-overlay-footer__cancel-button")).click();
	//	    driver.findElement(By.xpath("//div[9]/div/span/span")).click(); // 1er asiento
	//	    driver.findElement(By.xpath("//div[9]/div[2]/span/span")).click(); //2 asiento
	//	    driver.findElement(By.xpath("//div[9]/div[3]/span/span")).click();
	//	    driver.findElement(By.cssSelector("button.core-btn-primary.dialog-overlay-footer__ok-button")).click();
	//	    driver.findElement(By.cssSelector("button.core-btn-primary.dialog-overlay-footer__ok-button")).click();
	//	    driver.findElement(By.linkText("No, thanks")).click();
	//	

}
