package Com.Orange.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.Orange.qa.Util.TestUtil;
import net.bytebuddy.utility.RandomString;

public class TestBase {

	public static WebDriver driver;
	
	public static Properties props;   //===========Properties-> It is a class,properties->reference variable.(Declare Globally)
	
	public TestBase() throws IOException {
		
		props = new  Properties();
		
		FileInputStream file =
		new FileInputStream("C:\\Users\\pandh\\eclipse-workspace\\Data_Driven_Framework1\\src\\main\\java\\Com\\Orange\\qa\\Configiration\\Config properties");
		props.load(file);     //==========load->method of properties class
	}
	
	public static void initilization() {
		System.setProperty("webdriver.chrome.driver", "F:\\Velocity\\software\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();   //============delete all cookies
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);==========another method for loading the page
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoad_time, TimeUnit.SECONDS);
		driver.get(props.getProperty("URL"));
	}
	
	public String getscreenshot(String testCaseName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String Random = RandomString.make(5);
		
		String destination =System.getProperty("user.dir")+"/ScreenShot/"+testCaseName+".png";
		
		FileUtils.copyFile(source, new File(destination));
		
		return destination;
	}
}
