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

	public class OnMouseHover extends base{
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
			js.executeScript("window.scrollBy(0,500)");
			
			//mouse hover over the element
			
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath(lp.HouseHoverElement));
			action.moveToElement(we).build().perform();
			
			//identify elements on mouse hover
			boolean AddFavroites=driver.findElement(By.xpath(lp.AddFavroites)).isDisplayed();
			if(AddFavroites)
			{
				log.info("Add to Favroites tab is displayed");
			}

			boolean AddCompare=driver.findElement(By.xpath(lp.AddCompare)).isDisplayed();
			if(AddCompare)
			{
				log.info("Add to Compare  tab is displayed");
			}
			
			boolean AddCart=driver.findElement(By.xpath(lp.AddCart)).isDisplayed();
			if(AddCart)
			{
				log.info("Add to Cart tab is displayed");
			}
			
		}
		@AfterTest
		public void teardown()
		{
			
			driver.close();
		
			
		}


	}


