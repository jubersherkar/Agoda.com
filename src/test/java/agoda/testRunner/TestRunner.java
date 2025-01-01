package agoda.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"agoda.stepDefinitions"},				
		plugin = {"pretty",
		"html:target/cucumber-reports/cucumber-pretty",
		"json:target/cucumber-reports/CucumberTestReport.json",
		"rerun:target/cucumber-reports/rerun.txt"},
//		tags = "not @login and @flightSearchResult",
		monochrome = false,
		dryRun = false )
public class TestRunner extends AbstractTestNGCucumberTests
{
	
}
