package Com.Orange.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.Orange.qa.Base.TestBase;
import Resources.ExtentReportNG;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;

public class Listeners extends TestBase implements ITestListener{

	public Listeners() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	


	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test.Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		//Screenshot
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		String testmethodname = result.getMethod().getMethodName();
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result);
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getscreenshot(testmethodname), result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
