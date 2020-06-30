
package Academy;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;

import resources.base;

public class ProductDetailPage extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("url"));
	}
	@Test(priority=1)
	
	public void MouseHover() throws IOException, InterruptedException
	{

		LandingPage lp=new LandingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		//click on Product
		
	
		clicklink("findElementByXPath", lp.Product, driver, " Product");
		//verify property on product details page
		
		verifyElementPresent(driver,lp.AddCart_ProcutDetail,"xpath","Add to cart button");
		
		verifyElementPresent(driver,lp.AddCart_ProcutDetail,"xpath","Price of the Product");
		
		//click on size dropdown
		
		clicklink("findElementByXPath", lp.SizeChat, driver, " size dropdown");
	
		//Verify drop down element
		verifyElementPresent(driver,lp.SmallSize,"xpath","Small size in dropdown");
		verifyElementPresent(driver,lp.MSize,"xpath","Medium size in dropdown");
		verifyElementPresent(driver,lp.LSize,"xpath","Large size in dropdown");
		verifyElementPresent(driver,lp.XLSize,"xpath","Xtra Large size in dropdown");
	}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}


}


