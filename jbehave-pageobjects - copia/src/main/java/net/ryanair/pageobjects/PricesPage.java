package net.ryanair.pageobjects;

import java.util.concurrent.TimeUnit;

import net.ryanair.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static org.junit.Assert.assertTrue;

public class PricesPage extends PageObject {

	//@FindBy(xpath="(//span[@class='flights-table-price__price'])[1]")
	//@FindBy(xpath="//div[2]/flights-table-price/div/div/span[2]")
	@FindBy(xpath="(//div[@class='core-btn-primary'])[1]")
	private WebElement firstPrice;	
	
	@FindBy(css="span.flights-table-fares__fare-radio")	     
	private WebElement standardFare;
	
	//@FindBy(xpath="//button/descendant::span[contains(.,'Continue')]")
	//@FindBy(xpath="(//span[contains(.,'Continue')])[2]")
	//@FindBy(xpath="//button[@ng-click='$ctrl.onContinueBtnClick()']")
	@FindBy(id="continue")
	private WebElement buttonContinue;
	
	@FindBy(xpath="//button[contains(.,'Ok, got it')]")
	private WebElement buttonOk;
	
	private static By by;		
	

	public PricesPage(WebDriver driver) {		
		super(driver);
	}

	public boolean isInitialized() {					  
				by = By.xpath("(//div[@class='core-btn-primary'])[1]");				
				long time = 10;
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					    .withTimeout(time, TimeUnit.SECONDS)
					    .pollingEvery(5, TimeUnit.SECONDS)
					    .ignoring(NoSuchElementException.class);
				try{
					wait.until(ExpectedConditions.presenceOfElementLocated(by));					
					return true;
				} catch (TimeoutException e){	
					System.out.println("*********Element " + by.toString() + " not found after " + time + " seconds");
					return false;			
				}		
			}
//		return firstPrice.isDisplayed();
//	}	
	
	public void clickFirstPrice(){		
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", this.firstPrice);
    }
	public void clickStandardFare(){
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", this.standardFare);
		//this.standardFare.click();			
	}
	
	public void clickButtonContinue(){		
		Utils utils= new Utils();
		By by = By.id("continue");
		assertTrue(utils.isClickable(driver, by, 5));		
		
	
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", this.buttonContinue);		
	}
	
	public void clickButtonOk(){
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", this.buttonOk);		
	}
	
	
	
	
//	    
//	    // desde que selecciona precio hasta que pide logado 
//	    //--------------------------------------------------------
//	    driver.findElement(By.cssSelector("div.flight-header__min-price.hide-mobile > flights-table-price > div.flights-table-price > div.core-btn-primary > span.flights-table-price__price")).click(); //marca el primer precio
////	    driver.findElement(By.cssSelector("span.flights-table-fares__fare-radio")).click(); //coge el más barato
////	    driver.findElement(By.id("continue")).click();
////	    driver.findElement(By.xpath("//button[@type='button']")).click();
////	    driver.findElement(By.cssSelector("button.popup-msg__button.popup-msg__button--cancel")).click();  //no thanks..
////	    
//	    driver.findElement(By.cssSelector("span.flights-table-fares__fare-radio")).click();
//	    driver.findElement(By.xpath("//button[@type='button']")).click();
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
