package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.model.Log;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public  WebDriver driver;
	public Properties prop;
	public static Logger log =LogManager.getLogger(base.class.getName());
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("src\\main\\java\\resources\\data.properties");

prop.load(fis);

String strBrowserType = prop.getProperty("BrowserType");

try {
	if (strBrowserType.equalsIgnoreCase("IE")
			|| strBrowserType.equalsIgnoreCase("Internet Explorer")) {
		
		
		System.setProperty("webdriver.ie.driver",
				"AppliToolFramework/IEDriverServer.exe");
		
		DesiredCapabilities cap = DesiredCapabilities
				.internetExplorer();
		cap.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		driver = new InternetExplorerDriver(cap);
		
		

	} else if (strBrowserType.equalsIgnoreCase("FF")
			|| strBrowserType.equalsIgnoreCase("Firefox")) {
		
		
		System.setProperty("webdriver.gecko.driver","AppliToolFramework/geckodriver.exe" );  
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();  
        capabilities.setCapability("marionette",true);  
       
        driver= new FirefoxDriver(capabilities);
        driver = new FirefoxDriver();
	
		
	
	} else if (strBrowserType.equalsIgnoreCase("chrome")) {
          System.out.println("enter chrome");
		System.setProperty("webdriver.chrome.driver","AppliToolFramework/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D:/Users/arcsinha/Downloads/selenium/chrome.exe");
		driver = new ChromeDriver();
		
	} 
	
	else if (strBrowserType.equalsIgnoreCase("Edge")) {

		driver = new EdgeDriver();
		
	} 
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.manage().window().maximize();
return driver;
}

public String screenshot(String testCaseName,WebDriver driver) throws IOException
{

TakesScreenshot ts=(TakesScreenshot) driver;
File source =ts.getScreenshotAs(OutputType.FILE);
String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
FileUtils.copyFile(source,new File(destinationFile));
return destinationFile;
}

public boolean verifyElementPresent(WebDriver driver,
		String strElement, String strElementProperty,String element) {
	
	boolean exists = false;
	try {
		for (int interval = 0; interval < 5; interval++) {
			if (driver.findElements(By.linkText(strElement)).size() != 0
					&& driver.findElement(By.linkText(strElement))
							.isDisplayed()) {
				exists = true;
				break;
			} else if (driver.findElements(By.name(strElement)).size() != 0
					&& driver.findElement(By.name(strElement))
							.isDisplayed()) {
				exists = true;
				break;
			} else if (driver.findElements(By.id(strElement)).size() != 0
					&& driver.findElement(By.id(strElement)).isDisplayed()) {
				exists = true;
				break;
			} else if (driver.findElements(By.xpath(strElement)).size() != 0
					&& driver.findElement(By.xpath(strElement))
							.isDisplayed()) {
				exists = true;
				break;
			} else {
				exists = false;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} catch (Exception e1) {
		System.out.println("Exception occurred -- " + e1.getMessage());
	}
	if (exists) {
		log.info(element.toUpperCase() + " Elementpresent on the page");
		return true;
				
	} else {
		log.info(element.toUpperCase() + " Element is not present on the page");
		return false;
	}
	
}

public void verifyImagePresent(WebDriver driver,
		String strElement, String strElementProperty,String element) {
	String temp=element.toUpperCase();
	boolean exists = false;
	try {
		for (int interval = 0; interval < 5; interval++) {
			if (driver.findElements(By.linkText(strElement)).size() != 0
					&& driver.findElement(By.linkText(strElement))
							.isDisplayed()) {
				exists = true;
				break;
			} else if (driver.findElements(By.name(strElement)).size() != 0
					&& driver.findElement(By.name(strElement))
							.isDisplayed()) {
				exists = true;
				break;
			} else if (driver.findElements(By.id(strElement)).size() != 0
					&& driver.findElement(By.id(strElement)).isDisplayed()) {
				exists = true;
				break;
			} else if (driver.findElements(By.xpath(strElement)).size() != 0
					&& driver.findElement(By.xpath(strElement))
							.isDisplayed()) {
				exists = true;
				break;
			} else {
				exists = false;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} catch (Exception e1) {
		System.out.println("Exception occurred -- " + e1.getMessage());
	}
	if (exists) {
		log.info(strElement.toUpperCase() +"Elementpresent on the page");
	} else {
		log.info(strElement.toUpperCase() +"Element is not present on the page");
	}
}


public boolean  verifyLinkPresent(WebDriver driver, String strElement, String strLinkName) {

	boolean exists = false;
	try {
		for (int interval = 0; interval < 5; interval++) {
			if (driver.findElements(By.linkText(strElement)).size() != 0
					&& driver.findElement(By.linkText(strElement))
							.isDisplayed()) {
				exists = true;
				break;
			} else if (driver.findElements(By.name(strElement)).size() != 0
					&& driver.findElement(By.name(strElement))
							.isDisplayed()) {
				exists = true;
				break;
			} else if (driver.findElements(By.id(strElement)).size() != 0
					&& driver.findElement(By.id(strElement)).isDisplayed()) {
				exists = true;
				break;
			} else if (driver.findElements(By.xpath(strElement)).size() != 0
					&& driver.findElement(By.xpath(strElement))
							.isDisplayed()) {
				exists = true;
				break;
			} else {
				exists = false;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	} catch (Exception e1) {
		System.out.println("Exception occurred -- " + e1.getMessage());
		log.info(strLinkName +"is not present on the page");
		
		
	}
	if (exists) {
		
		log.info(strLinkName.toUpperCase() +"present on the page");
		return true;
	} else {
		log.info("Link is not present on the page");
		return false;
	}
	
}

//Verifying whether element is present on the page
	public boolean verifyelementPresent(WebDriver driver,
			String strElement, String strElementProperty,String strElementName,String strTestcaseName) {
		String temp=strElementName.toUpperCase();
		String testcasename  = strTestcaseName;
		boolean exists = false;
		try {
			for (int interval = 0; interval < 5; interval++) {
				if (driver.findElements(By.linkText(strElement)).size() != 0
						&& driver.findElement(By.linkText(strElement))
								.isDisplayed()) {
					exists = true;
					break;
				} else if (driver.findElements(By.name(strElement)).size() != 0
						&& driver.findElement(By.name(strElement))
								.isDisplayed()) {
					exists = true;
					break;
				} else if (driver.findElements(By.id(strElement)).size() != 0
						&& driver.findElement(By.id(strElement)).isDisplayed()) {
					exists = true;
					break;
				} else if (driver.findElements(By.xpath(strElement)).size() != 0
						&& driver.findElement(By.xpath(strElement))
								.isDisplayed()) {
					exists = true;
					break;
				} else {
					exists = false;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			System.out.println("Exception occurred -- " + e1.getMessage());
		}
		if (exists) {
			log.info(strElement.toUpperCase() +"Elementpresent on the page");
			return true;
		} else {
			log.info(strElement.toUpperCase() +"Element not present on the page");
			return false;
		}
	}
	
	public boolean  clicklink(String strDriverMethod, String strAttribute, WebDriver driver,String element) {
		String temp = element.toUpperCase();
		try {

			if (strDriverMethod.equals("findElementByLinkText")) {
				driver.findElement(By.linkText(strAttribute)).click();
			}
			else if (strDriverMethod.equals("findElementByName")) {
				driver.findElement(By.name(strAttribute)).click();
			}
			
			else if (strDriverMethod.equals("findElementByXpath")) {
				driver.findElement(By.xpath(strAttribute)).click();
			}
			
			
			
			else if (strDriverMethod.equals("findElementById")) {
				driver.findElement(By.id(strAttribute)).click();
			}
			else {
				driver.findElement(By.xpath(strAttribute)).click();
			}
			log.info("click on " +element);
		}
		catch (WebDriverException w1) {
			log.info("click on " +element);
			return false;
			
		}
		catch (Exception e1) {
			log.info("Not able click on " +element);
			return false;
		}
		return true;
	}
}
