package Com.Orange.qa.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Orange.qa.Base.TestBase;
import Com.Orange.qa.Pages.OrangeHRMHomePage;
import Com.Orange.qa.Pages.OrangeHRMLoginPage;

public class HomePageTest extends TestBase{
	
	OrangeHRMLoginPage LoginPage;
	OrangeHRMHomePage HomePage;


	public HomePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	
	public void Setup() throws IOException {
		
		initilization();   //static method
		LoginPage = new OrangeHRMLoginPage(driver);
		HomePage = new OrangeHRMHomePage(driver);
	}
	
	@Test
	public void EmployeeName() throws InterruptedException {
		
		LoginPage.ValidateLoginPage(props.getProperty("User"), props.getProperty("Pass"));
		Thread.sleep(2000);
		HomePage.Reporterpage(props.getProperty("Name"));
	}
	
	@AfterMethod 
	
	public void TearDown() {
		
		driver.quit();
	}

}
