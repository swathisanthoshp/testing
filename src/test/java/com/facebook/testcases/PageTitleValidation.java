package com.facebook.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PageTitleValidation extends Base{

	//Code to execute TS-1
	//To check if the title of the page matches the requirement.
	
	//logger
		public static Logger log =LogManager.getLogger(PageTitleValidation.class.getName());
	
	WebDriver driver;
	
	
	@Test
	public void testCase1() throws IOException {
		driver = initializeBrowser("Chrome");
		log.info("Entered into TestCase1");
		log.info("driver is initialized for TestCase1");
		
		//To capture page title
		String pageTitlenow = driver.getTitle();
		log.info("Page title Captured");
		
		//To verify the captured title is same as required title
		if(pageTitlenow.contains(getTitle())) {
			log.info("Page title obtained is same as requirment");
			log.info("TestCase1 passed");
			tearDown();
			Assert.assertTrue(true);
		}
		else {
			log.info("The title does not match the requirment");
			log.info("Test case failed");
			screenshot(driver,"TestCase1");
			log.info("Screenshot is taken for testCase1");
			tearDown();
			log.info("Obtained title is"+pageTitlenow+" where as required title is"+getTitle());
			Assert.fail();
		}
		
		
	}
}
