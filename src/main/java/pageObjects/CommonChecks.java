package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import resources.base;

public class CommonChecks extends base {
	LandingPage lp=new LandingPage(driver);
	
	public void Header()
	{
		verifyElementPresent(driver,lp.Home,"xpath","Home tab is displayed");
		
		verifyElementPresent(driver,lp.Men,"xpath","Men tab is displayed");
		
		verifyElementPresent(driver,lp.Women,"xpath","Women tab is displayed");
		
		verifyElementPresent(driver,lp.Running,"xpath","Running tab is displayed");
		
		verifyElementPresent(driver,lp.Training,"xpath","Training tab is displayed");
		
		verifyElementPresent(driver,lp.Logo,"xpath","Logo is displayed");
		
	}
	
	public void Footer()
	{
		/*verifyElementPresent(driver,lp.AboutUs,"xpath","Quick link AboutUs is displayed");
		verifyElementPresent(driver,lp.Faq,"xpath","Faq link AboutUs is displayed");
		verifyElementPresent(driver,lp.Help,"xpath","Help link AboutUs is displayed");
		verifyElementPresent(driver,lp.My_Account,"xpath","Quick link My_Account is displayed");
		verifyElementPresent(driver,lp.Blog,"xpath","Quick link Blog is displayed");
		verifyElementPresent(driver,lp.Contacts,"xpath","Quick link Contacts is displayed");
		verifyElementPresent(driver,lp.TermsAndCondition,"xpath","TermsAndCondition is displayed");
		verifyElementPresent(driver,lp.Privacy,"xpath","Privacy is displayed");*/
		
		String Address=driver.findElement(By.xpath(lp.Contact_address)).getText().trim();
		System.out.println(Address);
		if(Address.contains("155 Bovet Rd #600"))
		{
			log.info("Contact address displayed is correct");
		}
		else
		{
			log.info("Contact address  is not correct");
		}
		
		String Mail_addres=driver.findElement(By.xpath(lp.Mail_address)).getText();
		System.out.println(Mail_addres);
		if(Mail_addres.equals("srd@applitools.com"))
		{
			log.info("Mail address displayed is correct");
		}
		else
		{
			log.info("Mail address  is not correct");
		}
		
		String CopyRightText=driver.findElement(By.xpath(lp.CopyRight)).getText().trim();
		System.out.println(CopyRightText);
		if(CopyRightText.equals("© 2020 Applitools"))
		{
			log.info("CopyRightText displayed is correct");
		}
		else
		{
			log.info("CopyRightText  is not correct");
		}
		
		Select drpCountry = new Select(driver.findElement(By.xpath(lp.Select_Country)));
		drpCountry.selectByVisibleText("English");
		drpCountry.selectByVisibleText("French");
		drpCountry.selectByVisibleText("Spanish");
		drpCountry.selectByVisibleText("Russian");
		
		Select drpCurrency = new Select(driver.findElement(By.xpath(lp.Select_currency)));
		drpCurrency.selectByVisibleText("US Dollars");
		drpCurrency.selectByVisibleText("Euro");
		

	}
	public CommonChecks(WebDriver driver) {
		this.driver=driver;
	}
}
