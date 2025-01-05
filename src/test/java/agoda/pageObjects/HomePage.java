package agoda.pageObjects;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	private WebDriver driver;
	Actions action;
	Wait<WebDriver> wait;
	FluentWait<WebDriver> fWait;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@alt='Primary Logo']")
	WebElement primaryLogo;

	@FindBy(xpath = "//span[normalize-space()='Flight + Hotel']")
	WebElement flightPlusHotelMenu;

	@FindBy(xpath = "//span[normalize-space()='Hotels & Homes']")
	WebElement hotelsPlusHomesMenu;

	@FindBy(xpath = "//span[contains(text(),'Transport')]")
	WebElement transportMenu;

	@FindBy(xpath = "//div[@class='sc-bdfBwQ sc-gsTCUz cUjTQo sc-dQppl keUCIf drone-po-vis']")
	WebElement transportOptions;

	@FindBy(xpath = "//span[normalize-space()='Activities']")
	WebElement activitiesMenu;

	@FindBy(xpath = "//span[normalize-space()='Coupons & Deals']")
	WebElement couponsAndDealsMenu;

	@FindBy(xpath = "//img[@alt='English / India']")
	WebElement languageFlag;

	@FindBy(xpath = "//div[contains(@role,'dialog')]")
	WebElement suggestedLanguages;

	@FindBy(xpath = "//div[contains(@data-element-name,'header-right-section')]//div//div//div//div[contains(@role,'button')]//div//div") 
	WebElement currencyMenu;
		                  
	@FindBy(xpath  = "//ul[contains(@role,'listbox')]")
	WebElement currencyOptions;
	
	@FindBy(xpath = "//button[contains(@aria-pressed,'true')]")
	WebElement overnightStaysButton;
	
	@FindBy(xpath = "//input[@id='textInput']")
	WebElement searchBox;
	
	@FindBy(xpath = "//div[@id='check-in-box']")
	WebElement checkInDate;
	
	@FindBy(xpath = "//div[@id='check-out-box']")
	WebElement checkOutDate;

	public void enterBaseUrl()
	{
		driver.get("https://www.agoda.com/en-in/");
	}
	public boolean isPrimaryLogoDisplayed()
	{
		return primaryLogo.isDisplayed();
	}
	public void clickOnFlightPlusHotelMenu()
	{
		flightPlusHotelMenu.click();
	}
	public void clickOnHotelsPlusHomesMenu()
	{
		hotelsPlusHomesMenu.click();
	}
	public void clickOnTransportMenu()
	{
		transportMenu.click();
	}
	public boolean isTransportOptionsDisplayed()
	{
		return transportOptions.isDisplayed();
	}
	public void clickOnActivitiesMenu()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(currencyOptions));
		activitiesMenu.click();
	}
	public void clickOnCouponsAndDealsMenu()
	{
		couponsAndDealsMenu.click();
	}
	public String getTitleOfCouponAndDealsPage()
	{
		String title = null;
		String parent = driver.getWindowHandle(); // To switch to newly opened window to get title
		Set<String> handles = driver.getWindowHandles();
		for(String s : handles)
		{
			if(!parent.equals(s))
			{
				driver.switchTo().window(s);
				wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.titleIs("Agoda Promo Codes: Discounts + Coupons on Hotels Updated Daily"));
				title = driver.getTitle();
				driver.close();
				break;
			}
		}
		driver.switchTo().window(parent);
		return title;
	}
	public void clickOnLanguageMenu()
	{

		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(ElementClickInterceptedException.class);
		fWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		fWait.until(ExpectedConditions.elementToBeClickable(languageFlag)).click();

	}
	public boolean isSuggestedLanguagesDisplayed()
	{	
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		try
		{
			return wait.until(ExpectedConditions.visibilityOf(suggestedLanguages)).isDisplayed();
		}
		catch(Exception e)
		{
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FocusTrap\"]/div/div[2]/div/div[2]"))).isDisplayed();
		}
	}
	public void clickOnCloseSuggestedLanguages()
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		try
		{
			wait.until(ExpectedConditions.visibilityOf(suggestedLanguages)).isDisplayed();
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"FocusTrap\"]/div/div[2]/div/div[2]")));
		}
		action = new Actions(driver);	// To avoid click interception exception, used key events here
		action.sendKeys(Keys.SHIFT,Keys.ENTER).perform();
	}
	public void clickOnCurrencyMenu()
	{	
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		try
		{
		wait.until(ExpectedConditions.invisibilityOf(suggestedLanguages));
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\\\"FocusTrap\\\"]/div/div[2]/div/div[2]")));
		}
		
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(ElementClickInterceptedException.class);
		
		
		fWait.until(ExpectedConditions.elementToBeClickable(currencyMenu)).click();
	}
	public boolean isCurrencyOptionsDisplayed()
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		try {

			return wait.until(ExpectedConditions.visibilityOf(currencyOptions)).isDisplayed();
		}
		catch(Exception e)
		{
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[15]/div/div[2]/div/div[2]"))).isDisplayed();
		}
	}
	public void clickOnCloseCurrencyOptions()
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.visibilityOf(currencyOptions));
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[15]/div/div[2]/div/div[2]")));
		}
		action = new Actions(driver);	// To avoid click interception exception, used key events here
		action.sendKeys(Keys.SHIFT,Keys.ENTER).perform();
	}
}
