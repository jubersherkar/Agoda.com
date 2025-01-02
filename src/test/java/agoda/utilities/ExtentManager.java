package agoda.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
	private static ExtentReports report;

	public static ExtentReports getInstance()
	{
		if(report == null)
		{
			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "/target/ExtentReports/spark.html");
			report = new ExtentReports();

			report.attachReporter(spark);

			return report; 
		}

		return report; 
	}
}
