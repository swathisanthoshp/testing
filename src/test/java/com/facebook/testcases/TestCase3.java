package com.facebook.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.facebook.pageobjects.HomePage;

public class TestCase3 extends Base{

	//Negative test case
	//To capture error message displayed and check if it is apt/as per requirement
	
	WebDriver driver;
	
	//Loggers
	public static Logger log = LogManager.getLogger(TestCase3.class.getClass());
	
	//TestCase
	
	@Test
	public void testCase3() {
		//initializing the driver
		driver = initializeBrowser("Chrome");
		log.info("Entered into TestCase1");
		log.info("driver is initialized for TestCase2");
		
		//Entering emailID
		HomePage obj = new HomePage(driver);
		obj.enterEmailID(randomEmail());
		log.info("entered the emailId");
		
		//Clicking on Log in Button
		obj.clickLogin();
		log.info("Clicked on Login button");
		
		//getting the error message
		String Error = obj.getErrorMessage();
		log.info("Captured the error message displayed");
		screenshot(driver,"TestCase3");
		System.out.println(Error);
		
		//Exiting browser
		tearDown();
		log.info("Browser closed");
	}
	
}
