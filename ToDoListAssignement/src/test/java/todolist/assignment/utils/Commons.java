package todolist.assignment.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Commons class for utility methods
 * @author priya
 *
 */
public class Commons {
	// Creating a custom function
	public static void highLighterMethod(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
	}

}
