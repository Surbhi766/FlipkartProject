package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver_Initialization {

		public static WebDriver driver;
		
		public void setBrowserProperties(){
		System.out.println("Inside Property File");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Surbhi\\Selenium Jars\\Selenium Jars\\Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Surbhi\\Selenium Jars\\Selenium Jars\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Surbhi\\Selenium Jars\\Surbhi\\Drivers\\IEDriverServer.exe");
		}
		// browser parameter will be passed when openBrowser method will be called
		// based on the String value in browser, action will be taken
		
		public WebDriver openBrowser(String browser){
			
			if (browser.equalsIgnoreCase("FF")) {
				driver = new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("CHROME")) {
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				driver = new ChromeDriver(options);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			}
			else if (browser.equalsIgnoreCase("IE"))
				driver = new InternetExplorerDriver();
			
			driver.manage().window().maximize();
		
			return driver;
		}
}

