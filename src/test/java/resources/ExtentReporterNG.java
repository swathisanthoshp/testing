package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    static ExtentReports extent;
   
	public static ExtentReports getreporterobject(){
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		System.out.println("REport path: " + path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Facebook Testing Results");
		reporter.config().setReportName("Web Automation Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Swathi");
	
		return extent;
	}
	 
	
}
