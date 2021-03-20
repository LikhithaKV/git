package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	String val;
	Workbook wb;
	public String readData(String sheet, int row, int cell) {
FileInputStream fis;
try {
	fis = new FileInputStream(System.getProperty("user.dir")+"/Excel/data.xlsx");
     wb = WorkbookFactory.create(fis);
     val = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

} catch (Exception e) {
		System.out.println("failed to fetch data from excel");
	}
finally {
	try {
		wb.close();
	} catch (IOException e) {
		System.out.println("Failed to close excel");
	}
}
return val;
	}
	
	public void writeData(String sheet, int row, int cell, String value) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/Excel/data.xlsx");
		     wb = WorkbookFactory.create(fis);	
		     wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
		     FileOutputStream fos = new FileOutputStream("./Excel/data.xlsx");
				wb.write(fos);
		} catch (Exception e) {
			System.out.println("failed to store data inside excel");
		}
	finally {
		try {
			wb.close();
		} catch (IOException e) {
			System.out.println("Failed to close excel");
		}
	}
	}
}
