package agoda.utilities;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private WebDriver driver;
    final String browser = System.getProperty("browser", FileReaderManager.getInstance().getConfigReader().getBrowser());
    
    public WebDriver getDriver() 
    {   
        return driver == null ? createDriver() : driver;   
    }
    
    private WebDriver createDriver() 
    {      
        switch (browser) {
            case "chrome":
                  	
            	WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
//              options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                break;
            
            case "firefox":

        		WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options2 = new FirefoxOptions();
                options2.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                driver = new FirefoxDriver(options2);
                break;
        
            default: 
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }   
        return driver;        
    }

}
