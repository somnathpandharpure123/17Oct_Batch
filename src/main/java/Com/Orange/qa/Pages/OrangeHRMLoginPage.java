package Com.Orange.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Orange.qa.Base.TestBase;

public class OrangeHRMLoginPage extends TestBase {

	WebDriver driver;
	//Variable declaration
	
		@FindBy(xpath="//input[@name=\"username\"]")
		private WebElement username;
		
		@FindBy(xpath="//input[@name=\"password\"]")
		private WebElement password;
		
		@FindBy(xpath="//button[@type=\"submit\"]")
		private WebElement Login;
		
		@FindBy(xpath="//span[@class=\"oxd-userdropdown-tab\"]")
		private WebElement HomepageID;
		
		//Variable Initialization
		
		public OrangeHRMLoginPage(WebDriver driver)throws IOException
		{
			PageFactory.initElements(driver, this);
		}
		
		//Variable use
		
		public boolean ValidateLoginPage(String User,String Pass) throws InterruptedException
		{
			username.sendKeys(User);
			Thread.sleep(2000);
			password.sendKeys(Pass);
			Thread.sleep(2000);

			Login.click();
			return HomepageID.isDisplayed();
		}
		
		public String validatePagetitle(String User,String Pass) throws InterruptedException
		{
			username.sendKeys(User);
			Thread.sleep(2000);
			password.sendKeys(Pass);
			Thread.sleep(2000);
			Login.click();
			return driver.getTitle();
		}
}
 