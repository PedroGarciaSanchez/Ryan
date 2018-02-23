package net.ryanair.tests;


import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManage {

	protected static WebDriver driver;
	
	public DriverManage() {
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		//driver = new FirefoxDriver();	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	// Por estas anotaciones no pasa. VER POR QUÉ!!!!
//	@BeforeClass
//	public static void setUp(){
//		//driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}
	
//	@After
//	public void cleanUp(){
//		driver.manage().deleteAllCookies();
//	}
	
//	@AfterClass
//	public static void tearDown(){
//		driver.close();
//	}	
}
