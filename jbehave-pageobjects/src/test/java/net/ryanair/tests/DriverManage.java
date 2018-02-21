package net.ryanair.tests;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverManage {

	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUp(){
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	driver.manage().window().maximize();
	}
	
//	@After
//	public void cleanUp(){
//		driver.manage().deleteAllCookies();
//	}
	
	@AfterClass
	public static void tearDown(){
		driver.close();
	}	
}
