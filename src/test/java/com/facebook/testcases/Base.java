package com.facebook.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.utilities.ReadConfig;

public class Base {

	private WebDriver driver;
	
	// logger
	private static Logger log = LogManager.getLogger(Base.class.getName());

	// getting configurations from properties file through ReadConfig class
	ReadConfig rc = new ReadConfig();
	private String url = rc.getAplicationUrl();
	private String chroPath = rc.getChromedriverPath();
	private String firefoxPath = rc.getfirfoxdriverpath();
	private String iePath = rc.getIedriverPath();
	private String pageTitle = rc.getPageTitle();

	// Initializing Browser method
	public WebDriver initializeBrowser(String browser) {
		log.info("Control is in initializeBrowser method of Base class");
		if (browser != null && !"".equals(browser)) {
			// for Chrome Browser
			if (browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", chroPath);
				driver = new ChromeDriver();
				log.info("Chrome driver initalized");		
			}

			// for Firefox browser
			if (browser.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", firefoxPath);
				driver = new FirefoxDriver();
				log.info("Firefox driver initalized");
			}

			// for InternetExplorer

			if (browser.equals("InternetExplorer")) {
				System.setProperty("webdriver.ie.driver", iePath);
				driver = new InternetExplorerDriver();
				log.info("InternetExplorer driver initalized");
			}
		} else {
			System.setProperty("webdriver.chrome.driver", chroPath);
			driver = new ChromeDriver();
			log.info("Chrome driver initalized as a default browser");
		}

		// Opening application Url
		driver.get(url);
		log.info("Url opened");

		// Deleting Cookies,Maximizing Windows
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		log.info("Deleted all cookies and maximised the window");

		// wait method
		waitMethod();

		log.info("driver will be returned to actual testcase class, from base in next step");
		return driver;

	}

	// Closing browser method
	public void tearDown() {
		log.info("Driver will be exited in next step");
		driver.quit();
	}

	// Wait method(implicit wait)
	public void waitMethod() {
		log.info("Wait method in base class initiated");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		log.info("Wait method in base class ended");
	}

	// Wait method Explicit wait
	public void expicitlyWait(int duration, WebDriver driver, By object) {
		if(duration>0) {
		log.info("Explicit wait method is initiated for object" + object);
		WebDriverWait w = new WebDriverWait(driver, duration);
		w.until(ExpectedConditions.visibilityOfElementLocated(object));
		log.info("Explicit wait method is ended");
		}
		else {
			duration =0;
			log.info("Explicit wait method is initiated for object" + object +" ,with default duration=0. ");
			WebDriverWait w = new WebDriverWait(driver, duration);
			w.until(ExpectedConditions.visibilityOfElementLocated(object));
			log.info("Explicit wait method is ended");
		}
	}

	// ScreenShot Method
	public void screenshot(WebDriver driver, String tname) {
		if(driver != null) {
		log.info("TakescreenShot method in base class is initiated");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Control will go out of TakescreenShot method in base class");
		}
		else {
			log.info("driver is equall to null ,hence the screenshot can not be taken");
		}
	}

	public WebDriver getdriver() {
		return driver;

	}

	public String getTitle() {
		return pageTitle;

	}
	
	public String getpageurl() {
		return url;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		try {
			FileUtils.copyFile(source,new File(destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationFile;

	}
	
	//To enter a random emailID
		public String randomEmail() {
		String genaratedString = RandomStringUtils.randomAlphabetic(5);
		String randomEmail = genaratedString+"@gmail.com";
		return randomEmail;
	}
	
	

}
