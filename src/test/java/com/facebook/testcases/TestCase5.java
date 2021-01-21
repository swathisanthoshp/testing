 package com.facebook.testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.pageobjects.HomePage;

public class TestCase5 extends Base{

	//Enter Username, Password and click on the "Log In"  button.Repeat this for 4 times using Data provider.
	DataFormatter formatter = new DataFormatter();
	WebDriver driver;
	
	//Logger
	public static Logger log = LogManager.getLogger(TestCase5.class.getClass());
	
	
	//TestCase
	@Test(dataProvider = "values")
	public void testCase5(String email , String password) throws Exception {
		
		//Initializing browser
		driver = initializeBrowser("Chrome");
		log.info("Browser Initialized");
		
		
		//entering email and password
		HomePage ob = new HomePage(driver);
		ob.enterEmailID(email);
		log.info("email entered");
		ob.enterPasword(password);
		log.info("password entered");
		ob.clickLogin();
		log.info("Clicked on LogIn button");
		log.info("browser will be closed");
		tearDown();
	}
	
	
	
	@DataProvider
	public Object[][] values() throws IOException{
		FileInputStream fis;
		Object[][] data ;
			fis = new FileInputStream("./Configurations/FacebookDataProvider.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			int row_count = sheet.getPhysicalNumberOfRows();
			XSSFRow row = sheet.getRow(0);
			int column_count = row.getLastCellNum();
			System.out.println("number of rows "+row_count);
			data = new Object[row_count-1][column_count];
			for(int i=0;i<row_count-1;i++) {
				row = sheet.getRow(i+1);
					for(int j=0;j<column_count;j++) {
						XSSFCell cell = row.getCell(j);
						data[i][j] = formatter.formatCellValue(cell);
					}
			}
	
		return data;
		
	}
}
