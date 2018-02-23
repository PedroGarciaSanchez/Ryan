package net.ryanair.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Utils {
	public boolean isClickable(WebDriver driver, By by, long time) {		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(time, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		try{
			wait.until(ExpectedConditions.elementToBeClickable(by));
			return true;		
		} catch (TimeoutException e){	
			System.out.println("-------Element " + by.toString() + " not found after " + time + " seconds");
			return false;		
		}
	}
	
//	public boolean isClickable(WebDriver driver, WebElement element) {
//		long time = 10;
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(time, TimeUnit.SECONDS)
//				.pollingEvery(5, TimeUnit.SECONDS)
//				.ignoring(NoSuchElementException.class);		
//		try{
//			wait.until(ExpectedConditions..elementToBeClickable(by));
//			return true;		
//		} catch (TimeoutException e){	
//			System.out.println("-------Element " + by.toString() + " not found after " + time + " seconds");
//			return false;		
//		}
//	}



}
