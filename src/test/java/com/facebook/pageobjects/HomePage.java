package com.facebook.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.facebook.testcases.Base;

public class HomePage extends Base {
	
	WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	By text = By.className("_8eso");
	By email = By.id("email");
	By password = By.id("pass");
	By logIn = By.name("login");
	By errorMessage = By.className("uiHeaderTitle");
	By forgotPasswordTab = By.linkText("Forgotten password?");
	
	
	//To get actual text below the facebook tag 
	public String getText() {
		String s = driver.findElement(text).getText();
		return s;
	}
	
	//To enter email id into the text box
	public void enterEmailID(String emailid) {
		System.out.println("Email Id for textbox: " + emailid);
		System.out.println("Drive is null: " + (driver == null));
		System.out.println("Email element exists?: " + (driver.findElement(email) != null));
		driver.findElement(email).sendKeys(emailid);
	}
	
	
	//To enter password
		public void enterPasword(String passWord) {
			System.out.println("passWord for textbox: " + passWord);
			driver.findElement(password).sendKeys(passWord);
		}
		
		//To click on LogIn button
		public void clickLogin() {
			driver.findElement(logIn).click();
		}
	
	//To get error message 
	public String getErrorMessage() {
		String error = driver.findElement(errorMessage).getText();
		return error;
	}
	
	//To click on Forgot Password tab
	public void clickForgotPwTab() {
		driver.findElement(forgotPasswordTab).click();
	}
	
	
	
	

}
