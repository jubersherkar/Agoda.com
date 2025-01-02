package agoda.hooks;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import agoda.utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks
{
	private TestContext testContext;
	private WebDriver driver;
	private Logger log = LogManager.getLogger();
	
	public Hooks(TestContext testContext)
	{
		this.testContext = testContext;
	}

	@Before
	public void setUp()
	{
		driver  = testContext.getWebDriverManager().getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		log.info("Browser launched");
	}
	@After(order = 1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String fileName = scenario.getName().replaceAll(" ", "_");
			final byte[] sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourceFile, "image/png", fileName);
			log.info("Screenshot taken");
		}
	}
	@After(order = 0)
	public void flush()
	{
		driver.quit();
		log.info("Browser closed");
	}
}
