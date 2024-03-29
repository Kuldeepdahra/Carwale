package carwale.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import carwale.base.TestBase;

public class TestUtil extends TestBase {
public static long PAGELOAD_TIME=40;
public static long IMPLICIT_WAIT=40;
public static String TESTDATA_SHEET_PATH = "C:\\Users\\dawnbit\\workspace\\Carwale\\src\\main\\java\\carwale\\testdata\\CarwaleTestData.xlsx";

static Workbook book;
static Sheet sheet;

public static Object[][] getTestData(String sheetName){
	System.out.println("op1");
	FileInputStream file=null;
	try {
		file=new FileInputStream(TESTDATA_SHEET_PATH);
		System.out.println("op2"+file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		book=WorkbookFactory.create(file);
		System.out.println("op3"+book);
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	sheet=book.getSheet(sheetName);
	System.out.println("op4"+sheet);
	Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	System.out.println("op5");
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	
	return data;
}
}
