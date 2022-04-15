package todolist.assignment.tests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import todolist.assignment.dataprovider.ToDoListDataProvider;
import todolist.assignment.pageobjects.POToDoListPage;
import todolist.assignment.utils.BrowserBase;

/**
 * Negative Testing test cases
 * @author priya
 *
 */
public class TC02ToDoListNegativeTests extends ToDoListDataProvider {
	
	private WebDriver driver;
	private POToDoListPage todoListPage;

	/**
	 * Loading initial driver setup and creating page objects. For creating page
	 * objects we are using Page Factory.
	 * 
	 * @param url
	 * @param browser
	 */
	@BeforeTest
	@Parameters({ "url", "browser" })
	public void setUp(String url, String browser) {
		driver = BrowserBase.getDriver(url, browser);
		todoListPage = PageFactory.initElements(driver, POToDoListPage.class);
	}

	/**
	 * Check Page Title
	 */
	@Test(priority = 0)
	public void checkPageTitle() {

		Assert.assertEquals("todos", todoListPage.getPageTitle());
		Reporter.log("Page Title is :" + todoListPage.getPageTitle());

	}

	/**
	 * Adding Special characters in the list.
	 * 
	 * @param todo
	 */
	@Test(priority = 1, dataProvider = "todoListSpecialCharacher")
	public void createTodoList(String todo) {
		todoListPage.addTodos(todo);
		Reporter.log("Task added in ToDo List" + todo);
	}

	/**
	 * Add space as a task
	 * 
	 * @param todo
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void clearAllTasks() {
		todoListPage.checkAllTasks();
		todoListPage.clickClearCompleted();
		Reporter.log("All the tasks cleared");
	}

	/**
	 * Add space as a task
	 * 
	 * @param todo
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void addSpaceinTask() {
		todoListPage.addTodos("        ");

		Assert.assertEquals(0, todoListPage.getCountAllTasks());

		Reporter.log("Space Not added in ToDo List");
	}

	/**
	 * Negative test case to check Clear Complete button availability before adding
	 * any element
	 */
	@Test(priority = 4, expectedExceptions = { NoSuchElementException.class })
	public void clickClearAllButton() {
		todoListPage.clickClearCompleted();
	}

	/**
	 * Negative test case to check Clear Complete button availability before adding
	 * any element
	 */
	@Test(priority = 5, expectedExceptions = { NoSuchElementException.class })
	public void clickClearAllButtonAfterAddingTask() {
		todoListPage.addTodos("Sample ToDO");
		todoListPage.clickClearCompleted();
	}
	
	/**
	 * Test case Edit first task
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void verifySpaceStartingString() throws InterruptedException {
		todoListPage.checkAllTasks();
		todoListPage.clickClearCompleted();
		todoListPage.addTodos("         This is space starting string");
		Assert.assertEquals(todoListPage.getListItem(0), "This is space starting string");
		Reporter.log("Space is not getting added in task");
	}

	/**
	 * closing browser
	 * 
	 * @throws InterruptedException
	 */
	@AfterTest
	public void cleanUp() {
		driver.close();
	}

}
