package agoda.utilities;

import com.aventstack.extentreports.ExtentTest;

public class Extent 
{
	private static ExtentTest test;
	
	public static ExtentTest getTest()
	{
		return test;
	}
	public static void seTest(ExtentTest test)
	{
		Extent.test = test; 
	}
}
