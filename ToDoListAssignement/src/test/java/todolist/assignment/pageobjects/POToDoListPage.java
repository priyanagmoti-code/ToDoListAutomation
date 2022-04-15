package todolist.assignment.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import todolist.assignment.utils.Commons;

/**
 * Page Object for ToDO page
 * @author priya
 *
 */
public class POToDoListPage {
	
	private WebDriver driver;
	private Actions action ;
	
	@FindBy(how=How.XPATH,using = "//header/h1")
	private WebElement pageTitle;
	
	@FindBy(how=How.XPATH,using = "//header/input")
	private WebElement inputText;
	
	@FindBy(how = How.XPATH,using = "//li[not(@class='completed')]")
	private List<WebElement> liListNotSelected;
	
	@FindBy(how = How.XPATH,using = "//li")
	private List<WebElement> liListAll;
	
	@FindBy(how = How.XPATH,using = "//span[@class='todo-count']/strong")
	private WebElement listCountElement;
	
	@FindBy(how = How.XPATH,using = "//input[@class='toggle']")
	private List<WebElement> checkBoxAll ;
	
	@FindBy(how = How.CLASS_NAME,using = "clear-completed")
	private WebElement clearCompletedButton;
	

	@FindBy(how = How.XPATH,using = "//button[@class='destroy']")
	private List<WebElement> listDestroyButton ;
	
	public POToDoListPage(WebDriver driver) {
		this.driver=driver;
		action = new Actions(driver);
	}

	/**
	 * Method to add task in todo.
	 * @param todo
	 */
	public void addTodos(String todo) {
		Commons.highLighterMethod(driver, inputText);
		inputText.sendKeys(todo);
		inputText.sendKeys(Keys.ENTER);
	}

	/**
	 * Get Page Title
	 * @return String
	 */
	public String getPageTitle() {
		return pageTitle.getText();
	}

	/**
	 * Verify Item Left in the list
	 */
	public void verifyItemLeft() {
		Commons.highLighterMethod(driver, listCountElement);
		Assert.assertEquals(liListNotSelected.size(), Integer.parseInt(listCountElement.getText()));
	}
	
	/**
	 * Select All the Tasks.
	 */
	public void checkAllTasks() {
		for(WebElement checkbox : checkBoxAll) {
			action.moveToElement(checkbox).perform();
			checkbox.click();
		}
		
	}
	
	/**
	 * Click clear competed button.
	 */
	public void clickClearCompleted() {
		clearCompletedButton.click();
	}
	
	/**
	 * Check of Clear Completed Button is present or not
	 * @return true if present
	 */
	public boolean isCompletedButtonPresent() {
		return clearCompletedButton.isDisplayed();
		
	}
	
	/**
	 * Clear all task list
	 */
	public void clearTwoFromList() {
		for(int i=0;i<2;i++) {
			action.moveToElement(liListAll.get(i)).perform();
			listDestroyButton.get(i).click();
			
		}
	}
	
	/**
	 * Test case to edit first task
	 * @throws InterruptedException
	 */
	public void editFirstTask() throws InterruptedException {
		action.doubleClick(liListAll.get(0)).perform();
		liListAll.get(0).click();
		WebElement element = liListAll.get(0).findElement(By.className("edit"));
		element.sendKeys("Updated");

		element.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		Assert.assertEquals(liListAll.get(0).getText(), "First TaskUpdated");
		
		
	}
	
	/**
	 * Get task by index
	 * @param number
	 * @return
	 */
	public String getListItem(int number) {
		return liListAll.get(number).getText();
	}

	/**
	 * 
	 * @return int
	 */
	public int getCountNotSelectedTask() {
		return liListNotSelected.size();
	}

	/**
	 * 
	 * @return int
	 */
	public int getCountAllTasks() {
		return liListAll.size();
	}

	
}
