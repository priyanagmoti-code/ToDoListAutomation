package todolist.assignment.utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Class to read data from excel and fill it into data providers
 * @author priya
 *
 */
public class ExcelDataReader {


	private static final String DATA_SET_XLSX = System.getProperty("user.dir") + File.separator + "data"+File.separator+"ToDoListDataSet.xlsx";

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static  XSSFCell Cell;
	private static  DataFormatter formatter = new DataFormatter();


	/**
	 * Read data provider excel file
	 * @param FilePath
	 * @param SheetName
	 * @param startCol
	 * @param totalCols
	 * @return multidimensional array of object
	 * @throws Exception
	 */
	public static Object[][] readExcel(String SheetName) throws Exception {

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(DATA_SET_XLSX);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 0;


			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();


			tabArray = new String[4][1];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;

				for (int j = 0; j < 1; j++, cj++) {

					tabArray[ci][cj] = getCellData(i, j);
				}

			}

		}

		catch (FileNotFoundException e) {


			e.printStackTrace();

		}

		catch (IOException e) {


			e.printStackTrace();

		}

		return (tabArray);

	}



	private static String getCellData(int RowNum, int ColNum) throws Exception {

		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		
		return formatter.formatCellValue(Cell);

		

	}
	// Main function is calling readExcel function to read data from excel file
	
		public static void main(String[] args) throws Exception {


		// Prepare the path of excel file



		// Call read file method of the class to read data

		ExcelDataReader.readExcel("negative");

	}

}
