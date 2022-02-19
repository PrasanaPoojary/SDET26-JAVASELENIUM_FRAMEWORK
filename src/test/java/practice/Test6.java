package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 {
	public static void main(String[] args) throws IOException {
    FileInputStream fis = new FileInputStream("./data/TestData.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
   String Org = wb.getSheet("Sheet1").getRow(3).getCell(1).getStringCellValue();
}
}