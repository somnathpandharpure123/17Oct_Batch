package Com.Orange.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Orange.qa.Base.TestBase;
import Com.Orange.qa.Pages.OrangeHRMLoginPage;

public class LoginPageTest extends TestBase {
	
	OrangeHRMLoginPage LoginPage;

	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws IOException {
		
		initilization();          //static method 
		
		LoginPage = new OrangeHRMLoginPage(driver);
	}
	
	@Test
	public void sendOrangeHRMusername() throws InterruptedException {
		
		
		boolean userid=LoginPage.ValidateLoginPage(props.getProperty("User"), props.getProperty("Pass"));
		
		System.out.println(userid);
		
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void getHomeScreenTitle() throws InterruptedException {
		
		String pageTitle =LoginPage.validatePagetitle(props.getProperty("User"), props.getProperty("Pass"));
		
		System.out.println(pageTitle);
		
		Assert.assertEquals(pageTitle, props.getProperty("Title"));
		
	}
	@AfterMethod
	public void TearDown() {
		
		driver.quit();
	}
	

}
