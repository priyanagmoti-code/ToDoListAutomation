package todolist.assignment.dataprovider;

import org.testng.annotations.DataProvider;

import todolist.assignment.utils.ExcelDataReader;

/**
 * Data Provider for Test cases.
 * @author priya
 *
 */
public class ToDoListDataProvider {
	
	/**
	 * Data Provider for happy flow
	 * @return 
	 * @throws Exception
	 */
	@DataProvider
	public Object[][] todoList() throws Exception{
		return ExcelDataReader.readExcel("positive");

	}
	
	/**
	 * Data provider special character strings.
	 * @return
	 * @throws Exception
	 */
	@DataProvider
	public Object[][] todoListSpecialCharacher() throws Exception{
		return ExcelDataReader.readExcel("negative");

	}

}
