package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;

import resources.base;

public class Filtters extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("url"));
	}
	@Test(priority=1)
	
	public void Filter() throws IOException, InterruptedException
	{

		LandingPage lp=new LandingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		
		//verify by default Filter and Reset button is disable
		boolean filter=driver.findElement(By.xpath(lp.Filter)).isEnabled();
		if(filter)
		{
			log.info("Filter is not disable by default");
		}
		else
		{
			log.info("Filter is  disable by default");
		}
		
		boolean Reset=driver.findElement(By.xpath(lp.Reset)).isEnabled();
		if(Reset)
		{
			log.info("Reset is not disable by default");
		}
		else
		{
			log.info("Reset is  disable by default");
		}
		
		// click on Price filter
		clicklink("findElementByXPath", lp.Price_Filter, driver, " Price filter");
		
		clicklink("findElementByXPath", lp.Filter, driver, " filter Button");
		
		clicklink("findElementByXPath", lp.Reset, driver, " Reset Button");
		
		boolean checkbox = driver.findElement(By.xpath(lp.Price_Filter)).isSelected();
		if(checkbox)
		{
			log.info("checkbox is not checked after clicked on Reset button");
		}
		else
		{
			log.info("checkbox is checked after clicked on Reset button");
		}
	}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}


}


