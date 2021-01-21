package com.facebook.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.facebook.pageobjects.HomePage;

public class TestCase2 extends Base {

	//To check if the text below facebook is "Facebook helps you connect and share with the people in your life"
	
	public static Logger log = LogManager.getLogger(TestCase2.class.getName());
	
	WebDriver driver;
	@Test
	public void testCase() {
		driver = initializeBrowser("Chrome");
		log.info("Entered into TestCase1");
		log.info("driver is initialized for TestCase2");
		
		//To capture text
		
		HomePage obj = new HomePage(driver);
		String actualtext = obj.getText();
		System.out.println(actualtext);
		
		//Comparing the text
		
		String requiredText = "Facebook helps you connect and share with the people in your life.";
		
		if(requiredText.equalsIgnoreCase(actualtext)) {
			tearDown();
			log.info("Browser closed");
			log.info("actualtext is same as requiredText");
			log.info("TestCase2 passed ");
			Assert.assertTrue(true);
			
		}
		else {
			tearDown();
			log.info("Browser closed");
			log.info("actualtext is not same as requiredText");
			log.info("TestCase2 failed");
			Assert.assertTrue(false);
		}
		
	}
	
	
}
