package todolist.assignment.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

/**
 * Base class to handle browser specific drivers
 * We can also add other browser specific operations in this class in future
 * @author priya
 *
 */
public class BrowserBase {

	/**
	 * Creates and returns WebDriver depending on input browser name
	 * @param url
	 * @param browser
	 * @return WebDriver
	 */
	public static WebDriver getDriver(String url, String browser) {

		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/priya/Downloads/driver/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			//need to setProperty for firefox
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			//need to setProperty for safari
			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		driver.get(url);
		Reporter.log("Browser opened and URL triggered.");
		
		return driver;
	}
}
