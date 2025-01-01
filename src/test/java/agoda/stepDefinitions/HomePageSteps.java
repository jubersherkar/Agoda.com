package agoda.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import agoda.pageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps
{
	static WebDriver driver;
	public HomePage homePage;
	
	
	@Given("user opens browser")
	public void user_opens_browser() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
	   homePage.launchBrowser();
	}

	@Given("wait for {int} seconds")
	public void wait_for_seconds(Integer int1) throws InterruptedException {
	    homePage.waitSomeTime(int1);
	}

	@Then("check browser")
	public void check_browser() {
	   System.out.println("Done");
	   driver.close();
	}
}
