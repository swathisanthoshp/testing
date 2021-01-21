package com.facebook.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.facebook.pageobjects.HomePage;

import junit.framework.Assert;

public class TestCase4 extends Base {
	//Click on "Forgot Password" button .User must navigate to Find account Page.
	
	WebDriver driver;
	
	//Logger
	public static Logger log = LogManager.getLogger(TestCase4.class.getClass());
	
	//TestCase
	
	@Test
	public void testCase4() {
		//initializing driver
		driver = initializeBrowser("Chrome");
		
		//To click on Forgot Password Tab
		HomePage obj = new HomePage(driver);
		obj.clickForgotPwTab();
		log.info("Clicked on Forget Password link");
		
		//waits
		waitMethod();
		
		//Capture and check the page title
		String title = driver.getTitle();
		//System.out.println(title);
		
		//To check if title contains "Forgotten Password"
		if(title.contains("Forgotten Password")){
			tearDown();
			log.info("Browser closed");
			Assert.assertTrue(true);
			log.info("TestCase4 passed ");
		}
		else {
			tearDown();
			log.info("Browser closed");
			Assert.assertTrue(false);
			log.info("TestCase4 failed");

		}
	}

}
