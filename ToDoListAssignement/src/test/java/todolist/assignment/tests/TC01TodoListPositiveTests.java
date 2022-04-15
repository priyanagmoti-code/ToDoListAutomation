package todolist.assignment.tests;

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
 * Positive Test Cases
 * @author priya
 *
 */
public class TC01TodoListPositiveTests extends ToDoListDataProvider{
	
	private WebDriver driver;
	private POToDoListPage todoListPage;

	/**
	 * Loading initial driver setup and creating page objects.
	 * For creating page objects we are using Page Factory.
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
		Reporter.log("Page Title is :"+todoListPage.getPageTitle());
		
	}
	
	/**
	 * Test case to Add task in ToDo List.
	 * @param todo
	 */
	@Test(priority = 1,dataProvider = "todoList")
	public void createTodoList(String todo) {
		todoListPage.addTodos(todo);
		Reporter.log("Task added in ToDo List"+todo);
	}
	
	/**
	 * Verify the count of list is matching with displayed count
	 */
	@Test(priority = 2)
	public void verifyCountOfList() {
		todoListPage.verifyItemLeft();
		Reporter.log("Count of the ToDo List is correct");
	}
	
	/**
	 * Complete All tasks and verify list count
	 */
	@Test(priority = 3)
	public void completeAllTasks() {
		todoListPage.checkAllTasks();
		Reporter.log("All taks are completed");
		todoListPage.verifyItemLeft();
		Reporter.log("Count of the ToDo List is correct");
	}
	
	/**
	 * Check if clear complete button is present
	 */
	@Test(priority = 4)
	public void verifyClearCompleatedButton() {
		Assert.assertTrue(todoListPage.isCompletedButtonPresent());
		
		Reporter.log("Clear Completed button is present");
	}
	
	/**
	 * destroy tasks from list
	 */
	@Test(priority = 5)
	public void competeTwoList() {
		todoListPage.clearTwoFromList();
		Assert.assertEquals(2,todoListPage.getCountAllTasks());
		Reporter.log("Two tasks removed from the list");
	}
	
	/**
	 * Clear all tasks
	 */
	@Test(priority = 6)
	public void clearAllList() {

		todoListPage.clickClearCompleted();
		Assert.assertEquals(0, todoListPage.getCountAllTasks());
		Reporter.log("All the tasks are destroyed");
		
	}
	
	/**
	 * Test Case edit task.
	 * @throws InterruptedException 
	 */
	@Test(priority = 7)
	public void editTask() throws InterruptedException {
		todoListPage.addTodos("First Task");
		todoListPage.editFirstTask();
	}
	
	/**
	 * closing browser
	 * @throws InterruptedException 
	 */
	@AfterTest
	public void cleanUp() throws InterruptedException {
		driver.close();
	}


}
