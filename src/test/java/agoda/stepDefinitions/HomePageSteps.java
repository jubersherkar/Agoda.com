package agoda.stepDefinitions;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import agoda.pageObjects.HomePage;
import agoda.utilities.TestContext;
import io.cucumber.java.en.Given;

public class HomePageSteps
{
	TestContext testContext;
	WebDriver driver;
	HomePage homePage;
	
	private Logger log = LogManager.getLogger(this);

	public HomePageSteps(TestContext testContext)
	{
		this.testContext = testContext;
		driver = testContext.getWebDriverManager().getDriver();
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("User is on Home page")
	public void user_is_on_home_page() {
		homePage.enterBaseUrl();
		log.info("Entered base Url");
	}

	@Given("Validates App logo")
	public void validates_app_logo() {
		Assert.assertTrue(homePage.isPrimaryLogoDisplayed());
		log.info("App logo displayed");
	}

	@Given("Validate Flight + Hotel menu")
	public void validate_flight_hotel_menu() {
		homePage.clickOnFlightPlusHotelMenu();
		log.info("Clicked on Flight + Hotel menu");
		Assert.assertTrue(driver.getCurrentUrl().contains("packages"));
		log.info("Verified Flight + Hotel menu");
	}

	@Given("Validate Hotels + Homes menu")
	public void validate_hotels_homes_menu() {
		homePage.clickOnHotelsPlusHomesMenu();
		log.info("Clicked on Hotels + Homes menu");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.agoda.com/en-in/?"));
		log.info("Verified Hotels + Homes menu");
	}

	@Given("Validate Transport menu")
	public void validate_transport_menu() {
		homePage.clickOnTransportMenu();
		log.info("Clicked on Transport menu");
		Assert.assertTrue(homePage.isTransportOptionsDisplayed());
		log.info("Transport options displayed");
	}

	@Given("Validate Activities menu")
	public void validate_activities_menu() {
		homePage.clickOnActivitiesMenu();
		log.info("Clicked on Activities menu");
		Assert.assertTrue(driver.getCurrentUrl().contains("activities"));
		log.info("Verified Activities menu");
	}

	@Given("Validate Coupons and Deals menu")
	public void validate_coupons_and_deals_menu() {
		String actualTitle = "Agoda Promo Codes: Discounts + Coupons on Hotels Updated Daily";
		
		homePage.clickOnCouponsAndDealsMenu();
		log.info("Clicked on Coupons and Deals menu");
		Assert.assertEquals(homePage.getTitleOfCouponAndDealsPage(),actualTitle);
		log.info("Verified Coupons and Deals menu");
	}

	@Given("Validate language menu")
	public void validate_language_menu() {
		homePage.clickOnLanguageMenu();
		log.info("Clicked on language menu");
		Assert.assertTrue(homePage.isSuggestedLanguagesDisplayed());
		log.info("Language options displayed");
		homePage.clickOnCloseSuggestedLanguages();
		log.info("Closed suggested languages");
	}

	@Given("Validate currency menu")
	public void validate_currency_menu() {
		homePage.clickOnCurrencyMenu();
		log.info("Clicked on currency menu");
		Assert.assertTrue(homePage.isCurrencyOptionsDisplayed());
		log.info("Currency options displayed");
		homePage.clickOnCloseCurrencyOptions();
		log.info("closed currency options");
	}
}
