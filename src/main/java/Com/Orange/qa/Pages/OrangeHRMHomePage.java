package Com.Orange.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHomePage {
	WebDriver driver;
	//Variable Declaration
	
	@FindBy(xpath = "//a[text()='Reports']")
	private WebElement Reports;
	
	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	private WebElement ReportName;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement SearchButton;
	
	//Variable Initialization
	
	public OrangeHRMHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Variable Use
	
	public String Reporterpage(String Name) throws InterruptedException {
		Reports.click();
		Thread.sleep(2000);
		ReportName.sendKeys(Name);
		
		return ReportName.getText();
		
	}
}
