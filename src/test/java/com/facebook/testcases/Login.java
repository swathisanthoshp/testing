 package com.facebook.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.pageobjects.HomePage;

public class Login extends Base{

   //Enter Username, Password and click on the "Log In"  button.Repeat this for 3 times using Data provider.
	
	WebDriver driver;
	
	//Logger
	public static Logger log = LogManager.getLogger(Login.class.getClass());
	
	
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
	//public Object[][] values() throws IOException{
	public Object[][] values(){
		
		Object [][] data = new Object [3][2];
		
		//1st set
		
		data[0][0] = "auhtk@rrmail.com";
		data[0][1] = "536ni378";
		
		//2st set
		
		data[1][0] = "ajjdk@zmail.com";
		data[1][1] = "khh248";
				
		//3st set
				
		data[2][0] = "yiyrjk@gmail.com";
		data[2][1] = "lj329yde";
		
	
		return data;
	
	}
}
