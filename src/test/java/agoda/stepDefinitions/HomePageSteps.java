package agoda.stepDefinitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import agoda.pageObjects.HomePage;
import agoda.utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps
{
	TestContext testContext;
	HomePage homePage;
	private Logger logger = LogManager.getLogger(this);

	public HomePageSteps(TestContext testContext)
	{
		this.testContext = testContext;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("user opens browser")
	public void user_opens_browser() {
	   homePage.enterBaseUrl();
	   logger.info("Url entered");
	}

	@Given("wait for {int} seconds")
	public void wait_for_seconds(Integer int1) throws InterruptedException {
	    homePage.waitSomeTime(int1);
	    logger.info("Waiting for some time");
	}

	@Then("check browser")
	public void check_browser() 
	{
		Assert.assertTrue(true);
	}
}
