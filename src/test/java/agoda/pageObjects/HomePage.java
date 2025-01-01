package agoda.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void launchBrowser()
	{
		driver.get("https://www.agoda.com/en-in/");
	}
	public void waitSomeTime(int i) throws InterruptedException
	{
		Thread.sleep(i*1000);
	}
}
