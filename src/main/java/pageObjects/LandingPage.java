package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com
public class LandingPage {

	
	public WebDriver driver;
	
	public String Home="//a[@id='A__showsubmen__23']";
	public String Men="//a[@id='A__showsubmen__25']";
	public String Women="//a[@id='A__showsubmen__27']";
	public String Running="//a[@id='A__showsubmen__29']";
	public String Training="//a[@id='A__showsubmen__31']";
	public String Logo="//img[@id='IMG____9']";
	public String HouseHoverElement="//img[@id='IMG__imgfluid__215']";
	public String AddFavroites="//i[@id='I__tiheart__225']";
	public String AddCompare="//i[@id='I__ticontrols__229']";
	public String AddCart="//i[@id='I__tishopping__233']";
	public String Product="//img[@id='IMG__imgfluid__286']";
	public String Product_Img="//div[@id='shoe_img']";
	public String AddCart_ProcutDetail="//div[@class='btn_add_to_cart']";
	public String SizeChat="//div[@class='nice-select wide']";
	public String SmallSize="//li[@class='option selected focus']";
	public String MSize="//li[contains(text(),'M')]";
	public String LSize="//main[@id='MAIN__bggray__64']//li[3]";
	public String XLSize="//li[contains(text(),'XL')]";
	public String ProductPrize="//span[@id='new_price']";
	public String AboutUs="//a[@id='A____425']";
	public String Faq="//a[@id='A____427']";
	public String Help="//a[@id='A____429']";
	public String My_Account="//a[@id='A____429']";
	public String Blog="//a[@id='A____433']";
	public String Contacts="//a[@id='A____435']";
	public String Contact_address="//li[@id='LI____440']";
	public String Contact_address1="//i[@id='I__tihome__441']";
	public String Mail_address="//a[@id='A____445']";
	public String TermsAndCondition="//a[@id='A____473']";
	public String Privacy="//a[@id='A____475']";
	public String CopyRight="//span[@id='SPAN____477']";
	public String Select_Country="//*[@id='SELECTselect-one____460']";
	public String Select_currency="//select[@id='SELECTselect-one____467']";
	public String Filter="//button[@id='filterBtn']";
	public String Reset="//button[@id='resetBtn']";
	public String Price_Filter="//span[@id='SPAN__checkmark__177']";
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}


	
	
	
}
