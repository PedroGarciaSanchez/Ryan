package net.ryanair.pageobjects;

import net.ryanair.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage extends PageObject {

	@FindBy(xpath="//img[@class='room-take-over__img']")
	private WebElement closeAdd;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement from;	
	
	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement destiny;	
	
	@FindBy(id="flight-search-type-option-one-way")	
	private WebElement oneWayButton;	
	
	@FindBy(xpath="//div[4]/button")
	private WebElement continueButton;	

	@FindBy(xpath="//div[@class='dropdown-handle']")
	private WebElement passengersDropdown;	
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement adultsButton;
	
	@FindBy(xpath="(//button[@type='button'])[7]")
	private WebElement childrenButton;	
	
	@FindBy(xpath="//input[@type='text' and @name='dateInput0']")
	private WebElement date;	
	
	@FindBy(xpath="//span[contains(.,'s go!')]") 
	private WebElement letsgoButton;		
	

	public SelectFlightPage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return destiny.isDisplayed();
	}
	
	public void enterFrom(String from){
		this.from.clear();
		this.from.sendKeys(from);		
	}
	
	public void enterDestiny(String destiny){
		this.destiny.clear();
		this.destiny.sendKeys(destiny);		
	}
	public void clickContinueButton(){
		this.continueButton.click();			
	}
	public void clickAdultsButton(){
		this.adultsButton.click();			
	}
	public void clickChildrenButton(){
		this.childrenButton.click();			
	}
	public void clickLetsgoButton(){
		this.letsgoButton.click();			
	}
	public void clickOneWayButton(){
		this.oneWayButton.click();			
	}	
	public void clickPassengersDropdown(){
		this.passengersDropdown.click();
	}	
	public void enterDate(String date){
		this.date.clear();
		this.date.sendKeys(date);		
	}

	public void clickCloseAdd() {
		// TODO Auto-generated method stub
		Utils utils = new Utils();
		if (utils.isClickable(driver,By.xpath("//img[@class='room-take-over__img'])"),5))
		this.closeAdd.click();
		
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
