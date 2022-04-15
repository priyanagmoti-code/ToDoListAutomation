# ToDoListAutomation
#ToDo List Test Automation

 This project is built using maven.
 
 TestNG framework is used along with Selenuim and java for automating test cases.
 
 Page Object Design pattern is used. As well as it uses PageFactory to create instances of Page Objects.  
 
 All required dependencies are added in pom.xml
  
 This project contains testNG.xml which is a starting point of test execution.
 
 The project is structured as below -
 
 	- It is divided into four packages
 	- todolist.assignment.dataprovider : This package contains all the required data providers.
 	- todolist.assignment.pageobjects : This package contains a class for page, which we call as as page object.
 	- todolist.assignment.tests : This package contains all the test cases/ classes , which are getting called from TestNG.xml
 	- todolist.assignment.utils : This package contains all the utility classes who has specific purpose or reusable methods.
 	
 TC01TodoListPositiveTests this class has following positive test cases
 
 	- checkPageTitle : This is to check if we are on correct page.
 	- createTodoList : This is creating a ToDo list by using a data from DataProvider excel.
 	- verifyCountOfList : This test case verifies if count of added tasks is correct.
 	- completeAllTasks : This test case is for completing all tasks by clicking all tasks and verifying item left count.
 	- verifyClearCompleatedButton : This test case is verify if clear completed button is displayed.
 	- clickClearCompleted : This test case is to test clear completed button.
 	- editTask	: This test case is to edit task inline.
 	
 TC02ToDoListNegativeTests	this class has following negative test cases
 
 	- checkPageTitle : This is to check if we are on correct page.
 	- createTodoList : This test case to add special character words and duplicate words in the list.
 	- addSpaceinTask : This test case to check if only space can create a task or not.
 	- clickClearAllButton : This test case is to check if clear all button available without adding tasks expectedExceptions = { NoSuchElementException.class }
 	- clickClearAllButtonAfterAddingTask : This test is to check is clear all button available after adding tasks expectedExceptions = { NoSuchElementException.class }
 	- verifySpaceStartingString : This test case to verify by adding extra space before the word.
 	
Steps to clone and execute test cases 
	git clone https://github.com/priyanagmoti-code/ToDoListAutomation.git
	cd ToDoListAssignement
	mvn clean test	


#
TestNG is used because of below reasons -
	1)It can run multiple script at a time.
	2)It provides inbuilt reporting.
	3)It can feed data using data provider .
	4)Can prioritize the tests, like which needs to execute first and which next.
	5)We have option to set pre and post condition (what needs to happen before and after the execution of scripts)

	I have used Page Factory pattern because it is very easy to find element by just using annotations.
	Page Factory provide support to automatically creates objects for all given web elements.
	Using Page Object we can easily reuse all its methods in all the test cases in the framework.
