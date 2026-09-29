package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporters {

    public static ExtentReports reporObjectCreation() {

        String path = System.getProperty("user.dir")+"\\ExtentReports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Flipkar Automation Report");
        reporter.config().setDocumentTitle("Flipkart Test Report");
        reporter.config().setTheme(Theme.DARK);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Sudheer");
        return extent;
    }
}
