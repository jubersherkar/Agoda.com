package agoda.pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	private WebDriver driver;
	Wait<WebDriver> wait;
	
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
	
	@FindBy(xpath = "//body/div[@id='FocusTrap']/div[@role='dialog']/div/div[1]")
	WebElement suggestedLanguages;
	
	@FindBy(xpath = "//body/div[@id='FocusTrap']/div[contains(@role,'dialog')]/div/div/div/button[1]")
	WebElement closeSuggestedLangueagesButton;
	
	@FindBy(xpath = "//div[@role='button']//div//div//p")
	WebElement currencyMenu;
	
	@FindBy(xpath = "//div[@data-element-name='currency-popup']")
	WebElement currencyOptions;
	
	@FindBy(xpath = "//body/div[@id='FocusTrap']/div[contains(@role,'dialog')]/div/div/div/button[1]")
	WebElement closeCurrencyOptionsButton;
	
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
		activitiesMenu.click();
	}
	public void clickOnCouponsAndDealsMenu()
	{
		couponsAndDealsMenu.click();
	}
	public String getTitleOfCouponAndDealsPage()
	{
		String title = null;
		String parent = driver.getWindowHandle();
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
		languageFlag.click();
	}
	public boolean isSuggestedLanguagesDisplayed()
	{
		return suggestedLanguages.isDisplayed();
	}
	public void clickOnCloseSuggestedLanguages()
	{
		closeSuggestedLangueagesButton.click();
	}
	public void clickOnCurrencyMenu()
	{
		currencyMenu.click();
	}
	public boolean isCurrencyOptionsDisplayed()
	{
		return currencyOptions.isDisplayed();
	}
	public void clickOnCloseCurrencyOptions()
	{
		closeCurrencyOptionsButton.click();
	}
}
