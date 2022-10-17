package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
  static  ExtentReports extent;
	
public static ExtentReports getReportObject() {
	
	
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Data_Driven_Framework1");
	reporter.config().setDocumentTitle("Automation Execution Results");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("QA Automation Enginner", "Somnath Pandharpure");
	return extent;
}
}
