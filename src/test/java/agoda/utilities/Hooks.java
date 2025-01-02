package agoda.utilities;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks 
{

	@Before
	public void setUpExtent(Scenario scenario)
	{
		ExtentTest test = ExtentManager.getInstance().createTest(scenario.getName());
		Extent.seTest(test);
	}
	@After
	public void extentFlush()
	{
		ExtentManager.getInstance().flush();
	}
}
