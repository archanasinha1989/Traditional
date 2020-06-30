package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CommonChecks;
import pageObjects.LandingPage;

import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("url"));
	}
	@Test(priority=1)
	
	public void basePageNavigation() throws IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		LandingPage l=new LandingPage(driver);
		CommonChecks CommCheck=new CommonChecks(driver);
		//verify header elements
		//CommCheck.Header();
		
		js.executeScript("window.scrollBy(0,1000)");
		CommCheck.Footer();
		}

	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}


}
